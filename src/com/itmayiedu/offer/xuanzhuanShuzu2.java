package com.itmayiedu.offer;

public class xuanzhuanShuzu2 {
    public static void main(String[] args) {
        xuanzhuanShuzu2 xuanzhuanShuzu2 = new xuanzhuanShuzu2();
        int[][] arr = xuanzhuanShuzu2.getClockwiseMatrix(8);
        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr.length; l++) {
                System.out.print(arr[k][l]+"  ");

            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        int[][] arr2 = getClockwiseMatrix2(9);
        for (int k = 0; k < arr2.length; k++) {
            for (int l = 0; l < arr2.length; l++) {
                System.out.print(arr2[k][l]+"  ");

            }
            System.out.println();
        }
        System.out.println("-----------------------------------");

    }

    int[][] getClockwiseMatrix(int n) {
        int[][] res = new int[n][n];
        int m = 1;
        for(int i=0; i<n/2; i++) {
            //right
            for(int j=i; j<n-i-1; j++) {
                    res[i][j] = m++; //00 01 02 03
            }
            //down
            for(int j=i; j<n-i-1; j++) { //04 14 24 34
                    res[j][n-i-1] = m++;
            }
            //left
            for(int j=n-i-1; j>i; j--) {//44 43 42 41
                    res[n-i-1][j] = m++;
            }
            //up
            for(int j=n-i-1; j>i; j--) {//40 30 20 10
                    res[j][i] = m++;
            }

        }
        if(1 == n % 2)
            res[n/2][n/2] = m;
        return res;
    }

    static int[][] getClockwiseMatrix2(int n) {
        int[][] res = new int[n][n];
        int m = 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                res[i][j] = m++;
            }
            for (int j = i; j < n - i - 1; j++) {
                res[j][n - i - 1] = m++;
            }
            for (int j = n - i - 1; j > i; j--) {
                res[n - i - 1][j] = m++;
            }
            for (int j = n - i - 1; j > i; j--) {
                res[j][i] = m++;
            }
        }
        if(1 == n % 2)
            res[n/2][n/2] = m;
        return  res;
    }
}
