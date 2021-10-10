package org.yeasheng.util;

import com.google.common.collect.Maps;
 
import java.util.Map;

/**
 * @author yansh
 * @version 2020/11/25
 **/
public class MapOrderByUtils {
 
    /**
     * 根据map的key排序
     * @param map 原始map
     * @param isDesc true：降序，false：升序
     * @param <K> key
     * @param <V> value
     * @return java.util.Map<K,V>
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> orderByKey(Map<K, V> map, boolean isDesc) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }
}