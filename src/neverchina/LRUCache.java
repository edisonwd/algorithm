package neverchina;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Design a data structure for Least Recently Used cache, which supports get&put operations.
 * Requirements: The time complexity should be O(1).
 *
 * LRUCache 算法实现
 * 实现思路：
 * 使用 HashMap + 双向链表实现
 *  1. 添加元素的时候，先判断元素是否存在，如果存在则删除原来的元素并添加到链表头部
 *  如果不存在，则判断链表大小是否超过缓存容量，如果超过则移除链表最后一个元素并添加到链表头部
 * 2. 获取元素的时候，判断 map 中是否包含 key，如果包含key 则删除原来的元素, 并将其添加到链表的头部，返回key对应的value,
 * 否则返回 -1
 * @date 2021-12-11 21:19
 */
public class LRUCache {
    /**
     * 缓存的容量
     */
    private final int capacity;
    /**
     * 双向链表保存缓存的元素
     */
    private final LinkedList<Integer> list;
    /**
     * map 用于快速获取对应的元素
     */
    private final HashMap<Integer, Integer> map;

    /**
     * 定义一个构造方法用于初始化并指定缓存的容量
     * @param capacity 指定容量
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        // 判断map 中是否包含 key，如果包含key 则删除原来的元素, 并将其添加到链表的头部, 否则返回 -1
        if (map.containsKey(key)) {
            list.removeFirstOccurrence(key);
            list.addFirst(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.removeFirstOccurrence(key);
        } else {
            if (list.size() >= capacity) {
                Integer last = list.removeLast();
                map.remove(last);
            }
        }
        list.addFirst(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        System.out.println(lruCache.get(1)); // -1
        System.out.println(lruCache.get(2)); // 2
        System.out.println(lruCache.get(3)); // 3
    }

}
