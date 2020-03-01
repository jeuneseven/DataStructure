package com.jeuneseven;

import com.jeuneseven.AbstractList;
//单向循环链表
public class SingleCycleLinkedList<E> extends AbstractList<E>  {
    private SingleCycleLinkedList.Node<E> first;

    private static class Node<E> {
        E element;
        SingleCycleLinkedList.Node<E> next;
        public Node(E element, SingleCycleLinkedList.Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        /*
         * 最好：O(1)
         * 最坏：O(n)
         * 平均：O(n)
         */
        SingleCycleLinkedList.Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == 0) {
            //先不要修改first结点
            Node<E> newFirst = new SingleCycleLinkedList.Node<>(element, first);
            Node<E>last = (size == 0) ? first : node(size - 1);//拿到最后一个结点
            last.next = newFirst;
            first = newFirst;
        } else {
            SingleCycleLinkedList.Node<E> prev = node(index - 1);
            prev.next = new SingleCycleLinkedList.Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        SingleCycleLinkedList.Node<E> node = first;
        if (index == 0) {
            if (size == 1) {//只剩下一个结点的时候特殊处理
                first = null;
            } else {
                //拿到最后一个结点，一定要放在前面
                Node<E> last = node(size - 1);
                last.next = first;

                first = first.next;
            }
        } else {
            SingleCycleLinkedList.Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            SingleCycleLinkedList.Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;

                node = node.next;
            }
        } else {
            SingleCycleLinkedList.Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;

                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点对象
     * @param index
     * @return
     */
    private SingleCycleLinkedList.Node<E> node(int index) {
        rangeCheck(index);

        SingleCycleLinkedList.Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        SingleCycleLinkedList.Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node.element);

            node = node.next;
        }
        string.append("]");

//		Node<E> node1 = first;
//		while (node1 != null) {
//
//
//			node1 = node1.next;
//		}
        return string.toString();
    }
}
