package com.itmayiedu.offer;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(1);
        solution.push(-1);
        solution.push(0);
        solution.push(5);
        int min = solution.min;
        System.out.println("最小值为"+min);
    }
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if(node < min){
            temp.push(node);
            min = node;
        }
        else
            temp.push(min);
    }

    public void pop() {
        stack.pop();
        temp.pop();
    }

    public int top() {
        int t = stack.pop();
        stack.push(t);
        return t;
    }

    public int min() {
        int m = temp.pop();
        temp.push(m);
        return m;
    }
}