package com.close.ai.service;

import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.HumanMapper;
import com.close.ai.pojo.Human;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;

/**
 * @author taifu
 * @since 2025-01-21
 */
@Service
public class HumanService {
    private final HumanMapper humanMapper;

    public HumanService(HumanMapper humanMapper) {
        this.humanMapper = humanMapper;
    }

    public ResponseCode createBlankHumanWithUserId(Long userId) {
        Human human = new Human();
        human.setId(IdUtil.getSnowflake().nextId());
        human.setUserId(userId);
        Integer res = humanMapper.insertHuman(human);
        if (res != 1) {
            return ResponseCode.HUMAN_INSERT_ERROR;
        }
        return ResponseCode.OK;
    }
}
