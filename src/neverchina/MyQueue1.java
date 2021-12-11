package neverchina;

import java.util.Stack;

/**
 * 使用双栈实现一个队列
 * 队列的特性：先进先出
 * @author edisonwd
 * @version v1.0.0
 * @date 2021-12-11 22:05
 */
public class MyQueue1 {

    /**
     * 定义入栈
     */
    private final Stack<Integer> inStack;
    /**
     * 定义出栈
     */
    private final Stack<Integer> outStack;

    public MyQueue1() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue1 myQueue1 = new MyQueue1();
        myQueue1.push(1);
        myQueue1.push(2);
        myQueue1.push(3);
        System.out.println(myQueue1.pop()); // 1
        System.out.println(myQueue1.peek()); // 2
        System.out.println(myQueue1.isEmpty()); // false
    }

}
