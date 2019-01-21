package com.itmayiedu;

public class PrintAB {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    print.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                for (int j = 0; j < 10; j++) {
                    print.printB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

    static class Print {
        private boolean flag = false;

        public synchronized void printA() throws InterruptedException {
            while (flag) {
                this.wait();
            }
            System.out.println("A");
            flag = true;
            this.notify();
        }

        public synchronized void printB() throws InterruptedException {
            while (!flag) {
                this.wait();
            }
            System.out.println("B");
            flag = false;
            this.notify();
        }
    }
}
