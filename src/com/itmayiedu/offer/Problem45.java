package com.itmayiedu.offer;

//题目： 0,1 ，...,n-1 这 n 个数排成一个圆圈，从数字 0 开始每次从这个圆圈里
//删除第 m个数字。求出这个圆圈里剩下的最后一个数字。
public class Problem45 {
    public static void main(String[] args) {
        Problem45 p= new Problem45();
        System. out .println(p.lastRemaining(6, 2));
    }
    public int lastRemaining( int n, int m){
        if (n<1||m<1)
            return -1;
        int last=0;
        for ( int i=2;i<=n;i++){
            last=(last+m)%i;
        }
        return last;
    }
}
