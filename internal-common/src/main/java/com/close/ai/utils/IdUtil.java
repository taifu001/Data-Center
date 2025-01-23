package com.close.ai.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author nbwyctf
 * @since 2025-01-20
 */
@Component
public class IdUtil {
    @Value("${datacenter.server.datacenterId}")
    private Integer dataCenterId;
    @Value("${datacenter.server.workerId}")
    private Integer workerId;

    private static volatile SnowflakeIdGenerator snowflakeIdGenerator;

    // 在初始化完成后，将非静态变量赋值到静态变量中
    @PostConstruct
    public void init() {
        snowflakeIdGenerator = new SnowflakeIdGenerator(workerId, dataCenterId);
    }

    public static SnowflakeIdGenerator getSnowflake() {
        return snowflakeIdGenerator;
    }

    /**
     * 雪花算法内部类
     */
    public static class SnowflakeIdGenerator {

        // 起始时间戳 (2024-01-01 00:00:00)
        private static final long START_TIMESTAMP = 1704067200000L;

        // 各部分占用的位数
        private static final long SEQUENCE_BIT = 12;  // 序列号占用位数
        private static final long MACHINE_BIT = 5;   // 工作机器 ID 占用位数
        private static final long DATACENTER_BIT = 5; // 数据中心 ID 占用位数

        // 各部分最大值
        private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);     // 4095
        private static final long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);   // 31
        private static final long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT); // 31

        // 各部分向左位移量
        private static final long MACHINE_SHIFT = SEQUENCE_BIT;
        private static final long DATACENTER_SHIFT = SEQUENCE_BIT + MACHINE_BIT;
        private static final long TIMESTAMP_SHIFT = DATACENTER_SHIFT + DATACENTER_BIT;

        private final long datacenterId; // 数据中心 ID
        private final long workerId;     // 工作机器 ID
        private long sequence = 0L;      // 当前序列号
        private long lastTimestamp = -1L; // 上次生成 ID 的时间戳

        public SnowflakeIdGenerator(long workerId, long datacenterId) {
            if (workerId > MAX_MACHINE_NUM || workerId < 0) {
                throw new IllegalArgumentException("WorkerId can't be greater than " + MAX_MACHINE_NUM + " or less than 0");
            }
            if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
                throw new IllegalArgumentException("DatacenterId can't be greater than " + MAX_DATACENTER_NUM + " or less than 0");
            }
            this.workerId = workerId;
            this.datacenterId = datacenterId;
        }

        /**
         * 生成下一个唯一 ID (线程安全)
         * @return 唯一 ID
         */
        public synchronized long nextId() {
            long currentTimestamp = System.currentTimeMillis();

            if (currentTimestamp < lastTimestamp) {
                throw new RuntimeException("Clock moved backwards. Refusing to generate id.");
            }

            if (currentTimestamp == lastTimestamp) {
                // 同一毫秒内序列号递增
                sequence = (sequence + 1) & MAX_SEQUENCE;
                if (sequence == 0L) {
                    // 如果序列号已用完，等待下一毫秒
                    currentTimestamp = getNextMillisecond();
                }
            } else {
                // 不同毫秒，序列号重置
                sequence = 0L;
            }

            lastTimestamp = currentTimestamp;

            // 拼接各部分生成唯一 ID
            return ((currentTimestamp - START_TIMESTAMP) << TIMESTAMP_SHIFT) // 时间戳部分
                    | (datacenterId << DATACENTER_SHIFT)                     // 数据中心部分
                    | (workerId << MACHINE_SHIFT)                            // 工作机器部分
                    | sequence;                                              // 序列号部分
        }

        /**
         * 等待到下一毫秒
         * @return 当前时间戳
         */
        private long getNextMillisecond() {
            long mill = System.currentTimeMillis();
            while (mill <= lastTimestamp) {
                mill = System.currentTimeMillis();
            }
            return mill;
        }
    }
}

