package com.close.ai.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Collections;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
public class JacksonUtil {
    private static final Logger logger = LogManager.getLogger(JacksonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Pattern CAMEL_CASE_PATTERN = Pattern.compile("([a-z])([A-Z]+)");
    public static <T> List<T> parseJsonToList(String json, Class<T> clazz) {
        if (json == null || json.isEmpty()) {
            return Collections.emptyList();
        }
        try {
            return OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            logger.error("Failed to parse JSON to List<{}>: {}", clazz.getSimpleName(), json);
            return Collections.emptyList();
        }
    }

    public static <T> String listToJson(List<T> list) {
        if (list == null) {
            return "[]";
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            logger.error("Failed to serialize List<T>: {}", list);
            return "[]";
        }
    }

    // JSON 转 Map<String, Object>
    public static Map<String, Object> parseJsonToMap(String json) {
        if (json == null || json.isEmpty()) {
            return new HashMap<>();
        }
        try {
            return OBJECT_MAPPER.readValue(json, new TypeReference<Map<String, Object>>() {});
        } catch (IOException e) {
            logger.error("Failed to parse JSON to Map: {}", json, e);
            return new HashMap<>();
        }
    }

    // Map<String, Object> 转 JSON
    public static String mapToJson(Map<String, Object> map) {
        if (map == null) {
            return "{}";
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            logger.error("Failed to serialize Map to JSON", e);
            return "{}";
        }
    }

    // 驼峰转下划线
    public static String camelToSnake(String str) {
        return CAMEL_CASE_PATTERN.matcher(str).replaceAll("$1_$2").toLowerCase();
    }

    // 将 Map 的所有键转换为下划线格式
    public static Map<String, Object> convertKeysToSnakeCase(Map<String, Object> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(
                        // 转换键
                        entry -> camelToSnake(entry.getKey()),
                        // 保持值
                        Map.Entry::getValue,
                        // 若冲突，保留新值
                        (oldValue, newValue) -> newValue,
                        // 保持有序
                        LinkedHashMap::new
                ));
    }
}
