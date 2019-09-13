package com.lee.phoenix.common.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * jackson工具类. <p />
 *
 * @author lee
 * @version 1.0.0
 * @date 2018/08/07 23:00
 * @since JDK1.8
 */
public class JSONHelper {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T fromJSON(String jsonString, Class<T> valueType) {
        try {
            return mapper.readValue(jsonString, valueType);
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> List<T> fromJSON2List(String jsonString, Class<T> valueType) {
        try {
            JavaType javaType = getCollectionType(mapper, ArrayList.class, valueType);
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            return null;
        }
    }

    private static JavaType getCollectionType(ObjectMapper objectMapper, Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static <T> T fromJSON(byte[] bytes, Class<T> valueType) {
        try {
            return mapper.readValue(new ByteArrayInputStream(bytes), valueType);
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> String toJSON(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            System.out.println("JSON序列化失败：" + e.getMessage());
        }
        return null;
    }

    public static <T> byte[] toJSONBytes(T object) {
        try {
            return mapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            System.out.println("JSON序列化失败：" + e.getMessage());
        }
        return null;
    }
}
