package com.itmayiedu.offer;

public class SelectSort2 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 3, 9, 7, 1, 2, 15, 11, 8};
        System.out.println("选择排序前");
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("选择排序后");
        for (int i = 0; i < arr.length-1; i++) {
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k=j;

                }

            }
            if(i!=k){
                int t=arr[i];
                arr[i]=arr[k];
                arr[k]=t;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
