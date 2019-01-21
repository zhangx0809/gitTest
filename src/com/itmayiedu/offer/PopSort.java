package com.itmayiedu.offer;

public class PopSort {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
//        BubbleSort(a);
        SelectSort(a);
//        System.out.println("最优冒泡算法交换次数：" + count);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void BubbleSort(int[] a) {
        int lastExchangeIndex = 0;
        int sortBorder = a.length - 1;
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    flag = false;
                    lastExchangeIndex = j;
                }

            }
            sortBorder = lastExchangeIndex;
            if (flag) {
                break;
            }
        }
    }

    public static void SelectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int k = i;
            for (int j = k + 1; j < a.length - 1; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
                if (i != k) {
                    int t = a[k];
                    a[k] = a[i];
                    a[i] = t;
                }
            }

        }
    }
}
