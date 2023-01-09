package org.yeasheng.redis;

import java.util.Map;

/**
 * Redis常用方法
 *
 * @author yansh
 * @version 2022/1/16
 **/

public interface RedisService {

    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 在列表的最左边插入一个value
     *
     * @param key
     * @param value
     */
    void lpush(String key, String value);


    /**
     * 获取指定索引位置的值, index为-1时，表示返回的是最后一个；当index大于实际的列表长度时，返回null
     * @param key
     * @param index
     * @return
     */
    String index(String key, int index);

    String range(String key,int start,int end);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     *
     * @param delta 自增步长
     */
    Long increment(String key, long delta);


    /**
     * 使用管道批量插入
     *
     * @param map     插入参数
     * @param seconds 过期时间
     */
    void executePipelined(Map<String, String> map, long seconds);


}
