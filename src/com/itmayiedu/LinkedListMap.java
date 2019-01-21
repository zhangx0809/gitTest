package com.itmayiedu;

import java.util.LinkedList;

public class LinkedListMap<Key, Value> {

    // 实际存放Map元素
    LinkedList<Entry>[] tables = new LinkedList[998];
    // 实际Map大小
    private int size;

    public void put(Object key, Object value) {
        // 创建entry；
        Entry newEntry = new Entry(key, value);
        // hashCode
        int hash = getHash(key);
        // 判断是否已经在数组重存在
        LinkedList<Entry> entrylinkedList = tables[hash];
        if (entrylinkedList == null) {
            // 数组中没有存放元素
            LinkedList<Entry> linkedList = new LinkedList<>();
            linkedList.add(newEntry);
            tables[hash] = linkedList;
        } else {
            // hashCode 相同情况下 存放在链表后面
            for (Entry entry : entrylinkedList) {
                if (entry.key.equals(key)) {
                    // hashCode相同 对象也相同
                    entry.value = value;
                } else {
                    // hashCode 相同，但是对象不同。
                    entrylinkedList.add(newEntry);
                }
            }

        }
        size++;
    }

    public int getHash(Object key) {
        int hashCode = key.hashCode();
        int hash = hashCode % tables.length;
        return hash;
    }

    public Value get(Object key) {
        return (Value) getEntry(key).value;
    }

    public Entry getEntry(Object key) {
        // hashCode
        int hash = getHash(key);
        LinkedList<Entry> listEntry = tables[hash];
        if (listEntry != null) {
            for (Entry entry : listEntry) {
                if (entry.key.equals(key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListMap linkedListMap = new LinkedListMap<String, String>();
        linkedListMap.put("a", "644");
        linkedListMap.put("b", "123456");
        linkedListMap.put("b", "123");
        System.out.println(linkedListMap.get("b"));
    }

}

class Entry1 {

    public Entry1(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    Object key;
    Object value;

}

