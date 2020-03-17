package com.jeuneseven;

/**
 * 优先使用双向链表实现，因为是频繁在头尾两部分添加删除元素
 * Java底层也是使用链表实现队列的
 * 练习：https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 使用两个栈来实现队列，入队时push到inStack中，出队时如果outStack为空，将inStack中所有元素逐一弹出，push到outStack，outStack弹出栈顶元素
 * 如果outStack不为空，outStack弹出栈顶元素
 * @param <E>
 */
public class Queue<E>  {
    public int size() {
        return 0;
    }
    public boolean isEmpty() {
        return false;
    }

    /**
     * 入队
     * @param Element
     */
    public void enQueue(E Element) {

    }
    /**
     * 出队
     * @return
     */
    public E deQueue() {
        return null;
    }
    /**
     * 获取队列头部元素
     */
    public E front() {
        return null;
    }
}
