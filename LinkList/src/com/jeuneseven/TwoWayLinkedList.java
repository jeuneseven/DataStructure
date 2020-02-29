package com.jeuneseven;
import com.jeuneseven.AbstractList;
/**
 * 双向链表，增加链表的灵活度，Java使用的就是双向链表
 * 删除操作数量n/2 + n^2 / 4，除以n平均1/2 + n/4 比单向链表节省一半
 * 复杂度与单链表一样
 * 开辟、销毁内存空间次数比较多，不会造成内存的浪费
 * 如果是在尾部进行添加和删除来操作，选择动态数组还是链表都可以
 * 如果是在头部或任意位置进行频繁添加删除，尽量选择双向链表
 */
public class TwoWayLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        /**
         * JAVA 中不会造成循环引用
         */
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
}
