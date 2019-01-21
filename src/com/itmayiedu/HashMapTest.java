package com.itmayiedu;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1,new User("张三",26));
        users.put(2,new User("李四",22));
        users.put(3,new User("王五",24));
        System.out.println(users);
        HashMap<Integer, User> sortHashMap = sorthashMap(users);
        System.out.println(sortHashMap);
        singleton1.INSTANCE.fun1();
        singleton1.INSTANCE.fun1();
        singleton1.INSTANCE.fun1();

    }

    public static HashMap<Integer, User> sorthashMap(HashMap<Integer, User> hashMap){
        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();
        List<Map.Entry<Integer, User>> entryArrayList = new ArrayList<>(entries);
//        Collections.sort(entryArrayList, new Comparator<Map.Entry<Integer, User>>() {
//            @Override
//            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
//                return o2.getValue().getAge()-o1.getValue().getAge();
//            }
//        });
        Collections.sort(entryArrayList,(o1, o2) -> o2.getValue().getAge()-o1.getValue().getAge());
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, User> integerUserEntry : entryArrayList) {
            linkedHashMap.put(integerUserEntry.getKey(),integerUserEntry.getValue());
        }
        return linkedHashMap;
    }
}
