package com.itmayiedu;

public class wsTest {
    public static void main(String[] args) {
        for(int m=2;m<10000;m++){
            int s=0;
            for(int i=1;i<m;i++){
                if((m%i)==0)
                    s+=i;
            }
            if(s==m){
                System.out.print(m+" its factors are:");
                for(int j=1;j<m;j++)
                {
                    if((m%j)==0){
                        System.out.print(j);
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}

