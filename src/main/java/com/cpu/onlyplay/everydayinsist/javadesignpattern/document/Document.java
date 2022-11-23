package com.cpu.onlyplay.everydayinsist.javadesignpattern.document;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author: cpuRick
 * @createTime: 2022/08/16 9:45
 * @description: 抽象文档
 */
public interface Document {

    /**
     * 放内容
     *
     * @param key
     * @param value
     */
    void put(String key, Object value);


    /**
     * 获取内容
     *
     * @param key
     * @return
     */
    Object get(String key);


    /**
     * 流式处理
     *
     * @param key
     * @param constructor
     * @param <T>
     * @return
     */
    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
