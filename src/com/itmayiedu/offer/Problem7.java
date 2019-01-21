package com.itmayiedu.offer;

import java.util.Stack;

//用两个栈实现一个队列，实现对了的两个函数 appendTail 和
//deleteHead ，分别完成在队列尾插入结点和在队列头部删除结点的功能。
public class Problem7<T> {
    private Stack<T> stack1 =new Stack<T>();
    private Stack<T>  stack2 =new Stack<T>();
    public void appendTail(T t){
        stack1 .push(t);
    }
    public T deleteHead()  throws Exception{
        if ( stack2 .isEmpty()){
            while (! stack1 .isEmpty()){
                stack2 .push( stack1 .pop());
            }
        }
        if ( stack2 .isEmpty()){
            throw new Exception( " 队列为空，不能删除 " );
        }
        return stack2 .pop();
    }
    public static void main(String args[])  throws Exception
    {
        Problem7<String> p7= new Problem7<>();
        p7.appendTail( "1" );
        p7.appendTail( "2" );
        p7.appendTail( "3" );
        String s = p7.deleteHead();
        System.out.println(s);

    }
}
