package neverchina;

/**
 * 使用数组实现队列
 *
 * @author edisonwd
 * @version v1.0.0
 * @date 2021-12-11 22:16
 */
public class MyQueue2 {

    /**
     * 队列管道
     */
    private Object[] queue;
    //队列的头部，pop数据时总是从头部获取
    private int head;
    //队列尾部，push数据时总是从尾部添加
    private int tail;
    //队列长度
    private int size;
    //数组中能存放数据的最大容量
    private final static int MAX_CAPACITY = 1<<30;
    //数组长度
    private int capacity;
    //最大下标
    private int maxIndex;

    public MyQueue2(int initialCapacity){
        if (initialCapacity > MAX_CAPACITY)
            throw new OutOfMemoryError("initialCapacity too large");
        if (initialCapacity <= 0)
            throw new IndexOutOfBoundsException("initialCapacity must be more than zero");
        queue = new Object[initialCapacity];
        capacity = initialCapacity;
        maxIndex = initialCapacity - 1;
        head = tail = -1;
        size = 0;
    }
    public MyQueue2(){
        queue = new Object[16];
        capacity = 16;
        head = tail = -1;
        size = 0;
        maxIndex = 15;
    }

    /**
     * 往队列尾部添加数据
     * @param object 数据
     */
    public void push(Object object){
        if (size >= capacity){
            System.out.println("queue's size more than or equal to array's capacity");
            return;
        }
        if (++tail > maxIndex){
            tail = 0;
        }
        queue[tail] = object;
        size++;
    }

    /**
     * 从队列头部拉出数据
     * @return 返回队列的第一个数据
     */
    public Object pop(){
        if (size <= 0){
            System.out.println("the queue is null");
            return null;
        }
        if (++head > maxIndex){
            head = 0;
        }
        size--;
        Object old = queue[head];
        queue[head] = null;
        return old;
    }

    /**
     * 查看第一个数据
     */
    public Object peek(){
        return queue[head + 1];
    }

    /**

    /**
     * 队列是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.push(1);
        myQueue2.push(2);
        myQueue2.push(3);
        System.out.println(myQueue2.pop()); // 1
        System.out.println(myQueue2.peek()); // 2
        System.out.println(myQueue2.isEmpty()); // false
    }


}
