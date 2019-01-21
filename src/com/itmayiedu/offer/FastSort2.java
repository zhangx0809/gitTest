package com.itmayiedu.offer;

public class FastSort2 {
    public static void main(String[] args) {
        int[] a = {5, 4, 2, 3, 9, 7, 1, 2, 15, 11, 8};
        System.out.println("快速排序前");
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println("快速排序后");
        int start = 0;
        int end = a.length - 1;
        fastSort(a, start, end);
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void fastSort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];
        while (end > start) {
            while (end > start && a[end] >= key)
                end--;
            if (a[end] <= key) {
                int t = a[end];
                a[end] = a[start];
                a[start] = t;
            }
            while (end > start && a[start] <= key)
                start++;
            if (a[start] >= key) {
                int t = a[end];
                a[end] = a[start];
                a[start] = t;
            }
        }
        if (start > low) fastSort(a, low, start - 1);
        if (end < high) fastSort(a, end +1, high);
    }
}
