package com.itmayiedu.offer;

//题目：我们把只包含因子 2,3, 和 5 的称为丑数。求按从小到大的顺序的第 1500
//个丑数。例如 6、8 都是丑数，但 14 不是，因为它包含因子 7. 习惯上我们把 1
//当做第一个丑数。
public class Problem34 {
    public static void main(String[] args) {
        Problem34 p= new Problem34();
        System. out .println(p.getUglyNumber(1500));
    }
    public int getUglyNumber( int n){
        if (n<0)
            return 0;
        int [] uglyArray= new int [n];
        uglyArray[0]=1;
        int multiply2=1;
        int multiply3=1;
        int multiply5=1;
        for ( int i=1;i<uglyArray. length ;i++){
            int min=min(multiply2*2,multiply3*3,multiply5*5);
            uglyArray[i]=min;
            while (multiply2*2<=min)
                multiply2++;
            while (multiply3*3<=min)
                multiply3++;
            while (multiply5*5<=min)
                multiply5++;
        }
        return uglyArray[n-1];
    }
    private int min( int i,  int j,  int k) {
        int min=(i<j)?i:j;
        return (min<k)?min:k;
    }
}
