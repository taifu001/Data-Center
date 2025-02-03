package com.close.ai.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
public class JacksonUtil {
    private static final Logger logger = LogManager.getLogger(JacksonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
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
}
