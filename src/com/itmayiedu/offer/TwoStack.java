package com.itmayiedu.offer;

import java.util.Stack;

public class TwoStack<T> {
    private Stack<T> stack1 = new Stack();
    private Stack<T> stack2 = new Stack();
    public void append(T t){
        stack1.push(t);
    }
    public T deleteHead() throws Exception {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new Exception("队列为空，不能删除");
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        TwoStack<String> twoStack = new TwoStack<>();
        twoStack.append("1");
        twoStack.append("2");
        twoStack.append("3");
//        twoStack.append("4");
//        twoStack.append("5");
        String s = twoStack.deleteHead();
        System.out.println(s);

    }
}
