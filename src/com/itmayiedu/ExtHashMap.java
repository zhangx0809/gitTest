package com.itmayiedu;

/**
 * 纯手写HashMap集合 作者: 每特教育-余胜军<br>
 * 联系方式:QQ644064779|WWW.itmayiedu.com<br>
 */
public class ExtHashMap<K, V> implements ExtMap<K, V> {

    // 1.定义table 存放HasMap 数组元素 默认是没有初始化容器 懒加载
    Node<K, V>[] table = null;
    // 2. 实际用到table 存储容量 大小
    int size;
    // 3.HashMap默认负载因子，负载因子越小，hash冲突机率越低， 根据每个链表的个数
    float DEFAULT_LOAD_FACTOR = 0.75f;
    // 4.table默认初始大小 16
    static int DEFAULT_INITIAL_CAPACITY = 16; // 16

    public V put(K key, V value) {

        // 1.判断table 数组大小是否为空（如果为空的情况下 ，做初始化操作）
        if (table == null) {
            table = new Node[DEFAULT_INITIAL_CAPACITY];
        }
        // 2.判断数组是否需要扩容 实际存储容量=负载因子0.75*初始容量16 =12 相当于如果长度大于12的时候就需要开始数组扩容
        if (size >= (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY)) {
            System.out.println("开始扩容啦！！！！");
            resize();
        }

        // 3.计算hash值指定下标位置
        int index = getIndex(key, DEFAULT_INITIAL_CAPACITY);
        Node<K, V> node = table[index];
        if (node == null) {
            // 没有发生hash冲突问题
            node = new Node<K, V>(key, value, null);
            size++;
        } else {
            Node<K, V> newNode = node;
            while (newNode != null) {
                // // 已经发生hash冲突问题key 直接添加(冲突node)到前面了 不是往后面加

                if (newNode.getKey().equals(key) || newNode.getKey() == key) {
                    // hashCodoe 相同，而且equals 相等情况 说明是同一个对象 修改值
                    // node.value = value;
                    return newNode.setValue(value);
                } else {
                    // 继续添加，排在前面 hascode 取模余数相同 index 存放在链表 或者hashCode 相同但是对象不同
                    // 新的node 的next 原来的node
                    if (newNode.next == null) {
                        node = new Node<K, V>(key, value, node);
                        size++;
                    }
                }
                newNode = newNode.next;
            }
        }
        table[index] = node;
        return null;

    }

    // hashMap数组扩容机制
    private void resize() {

        // 1.定义新的数组元素
        Node[] newTables = new Node[DEFAULT_INITIAL_CAPACITY << 1];
        // 2. 将老的table的key index重新计算下标
        for (int i = 0; i < table.length; i++) {
            // 老的Node节点
            Node<K, V> oldNode = table[i];
            while (oldNode != null) {
                table[i] = null;
                // 重新计算index 索引下标位置
                K oldKey = oldNode.key;
                int index = getIndex(oldKey, newTables.length);
                // 老的next
                Node oldnext = oldNode.next;
                // 判断newTables数组中,是否存在下标相同，如果下标相同则存放在原来的.next
                oldNode.next = newTables[index];
                // 将原来的node赋值给新的node
                newTables[index] = oldNode;
                // 获取下一个节点,判断是否继续循环
                oldNode = oldnext;
            }

        }
        // 3.将newTable赋值给table;
        table = newTables;
        DEFAULT_INITIAL_CAPACITY = newTables.length;
        newTables = null;// 将 对象变为不可达对象
    }

    // hasMap数组扩容
    // private void resize() {
    //
    // // 1.定于新数组（） 按照两倍进行扩容 // 1.使用取模算法定位数组链表 DEFAULT_INITIAL_CAPACITY)*2
    // Node[] newTables = new Node[DEFAULT_INITIAL_CAPACITY << 1];
    // // 2.hashCode不会发生改变.但是index会发生改变,重新计算index 重新取模
    // for (int i = 0; i < table.length; i++) {
    // Node<K, V> node = table[i];
    // while (node != null) {
    // table[i] = null;
    // int index = getIndex(node.key, newTables.length);
    // // 获取下一个节点
    // ExtHashMap<K, V>.Node<K, V> next = node.next;
    // // 判断是否有下一个节点
    // node.next = newTables[index];
    // // 将之前node 计算的inde下标存放在 newTables
    // newTables[index] = node;
    // // 判断是否继续循环
    // node = next;
    // }
    //
    // }
    // // 将新的tables 赋值改老的table
    // table = newTables;
    // DEFAULT_INITIAL_CAPACITY = newTables.length;
    // newTables = null;// 变为不可达对象
    // }

    // 测试方法.打印所有的链表元素
    void print() {

        for (int i = 0; i < table.length; i++) {
            Node<K, V> node = table[i];
            System.out.print("下标位置[" + i + "]");
            while (node != null) {
                System.out.print("[ key:" + node.getKey() + ",value:" + node.getValue() + "]");
                node = node.next;
                // if (node.next != null) {
                // node = node.next;
                // } else {
                // // 结束循环
                // node = null;
                // }

            }
            System.out.println();
        }

    }

    public int getIndex(K k, int length) {
        // System.out.println("k:" + k + ",hashCode=" + hashCode);
        int index = k == null ? 0 : k.hashCode() % length;
        return index;
    }

    public V get(K k) {

        Node<K, V> node = getNode(table[getIndex(k, DEFAULT_INITIAL_CAPACITY)], k);
        return node == null ? null : node.value;
    }

    public Node<K, V> getNode(Node<K, V> node, K k) {
        while (node != null) {
            if (node.getKey().equals(k)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int size() {

        return size;
    }

    // 定义节点
    class Node<K, V> implements Entry<K, V> {
        // 存放Map 集合 key
        private K key;
        // 存放Map 集合 value
        private V value;
        // 下一个节点Node
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            super();
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V value) {
            // 设置新值的返回老的 值
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

    }

    public static void main(String[] args) {
        ExtHashMap extHashMap = new ExtHashMap<String, String>();
        extHashMap.put("a", "644");
        extHashMap.put("b", "123456");
        extHashMap.put("b", "123");
        System.out.println(extHashMap.get("b"));
    }

}
