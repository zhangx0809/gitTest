package com.itmayiedu;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.纯手写HasMap集合 完全采用Arraylist实现 缺点效率低 <br>
 * 作者: 每特教育-余胜军<br>
 * 联系方式:QQ644064779|WWW.itmayiedu.com<br>
 */
public class ExtArrayListMap<Key, Value> {

    List<Entry<Key, Value>> tables = new ArrayList<>();

    public void put(Key key, Value value) {
        // 判断key是否已经重复
        Entry existEntry = getEntry(key);
        if (existEntry != null) {
            existEntry.value = value;
            return;
        }
        Entry entry = new Entry<>(key, value);
        tables.add(entry);
    }

    public Value get(String key) {
        for (Entry<Key, Value> entry : tables) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(Key key) {
        Entry existEntry = getEntry(key);
        if (existEntry != null) {
            tables.remove(existEntry);
        }
    }

    public Entry<Key, Value> getEntry(Key key) {
        for (Entry<Key, Value> entry : tables) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ExtArrayListMap<String, String> extArrayListMap = new ExtArrayListMap<>();
        extArrayListMap.put("a", "aaaaa");
        extArrayListMap.put("b", "bbb");
        extArrayListMap.put("a", "aa");
//        extArrayListMap.remove("b");
        System.out.println(extArrayListMap.get("a"));
    }
}

class Entry<Key, Value> {

    Key key;
    Value value;

    public Entry(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

}







