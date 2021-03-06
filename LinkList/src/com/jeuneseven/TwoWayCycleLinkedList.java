package com.jeuneseven;
//双向循环链表
public class TwoWayCycleLinkedList<E> extends AbstractList<E> {
    private TwoWayCycleLinkedList.Node<E> first;
    private TwoWayCycleLinkedList.Node<E> next;
    private TwoWayCycleLinkedList.Node<E> current;
    /**
     * 为代码精简，可增加虚拟头结点，统一处理所有节点
     *
     public TwoWayCycleLinkedList()	{
     first = new Node<>(null, null);
     }
     */

    private static class Node<E> {
        E element;
        TwoWayCycleLinkedList.Node<E> next;
        public Node(E element, TwoWayCycleLinkedList.Node<E> next) {
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
    /**
     * 最好O(1) 首节点
     * 最坏O(n) 尾结点
     * 平均O(n)
     */
    public E get(int index) {
        return node(index).element;
    }

    @Override
    /**
     * 最好O(1) 首节点
     * 最坏O(n) 尾结点
     * 平均O(n)
     */
    public E set(int index, E element) {
        TwoWayCycleLinkedList.Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //平均O(n)
        /**
         * 增加虚拟头结点可以统一处理成
         * Node<E> prev = index == 0 ? first : node(index - 1);
         * prev.next = new Node<>(element, prev.next);
         * size++;
         */
        //最好O(1)
        if (index == 0) {
            first = new TwoWayCycleLinkedList.Node<>(element, first);
        } else {
            //最坏O(n)
            TwoWayCycleLinkedList.Node<E> prev = node(index - 1);
            prev.next = new TwoWayCycleLinkedList.Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        /**
         * 最好O(1) 首节点
         * 最坏O(n) 尾结点
         * 平均O(n)
         */
        /**
         * 增加虚拟头结点可以统一处理成
         * Node<E> prev = index == 0 ? first : node(index - 1);
         * node = prev.next;
         * prev.next = node.next;
         * size--;
         */

        TwoWayCycleLinkedList.Node<E> node = first;//保存被删除的元素
        if (index == 0) {
            first = first.next;
        } else {
            TwoWayCycleLinkedList.Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            TwoWayCycleLinkedList.Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;

                node = node.next;
            }
        } else {
            TwoWayCycleLinkedList.Node<E> node = first;
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
    private TwoWayCycleLinkedList.Node<E> node(int index) {
        rangeCheck(index);
        /**
         * 最好O(1) 首节点
         * 最坏O(n) 尾结点
         * 平均O(n)
         */
        TwoWayCycleLinkedList.Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void reset() {
        current = first;
    }

    public E next() {
        if (current == null) {
            return null;
        }

        current = current.next;
        return current.element;
    }

    public E remove() {
        if (current == null) {
            return null;
        }
//        remove(current);

        return null;
    }

    private E remove(Node<E> node) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        TwoWayCycleLinkedList.Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node.element);

            node = node.next;
        }
        string.append("]");
        //也可以通过while循环
//		Node<E> node1 = first;
//		while (node1 != null) {
//			node1 = node1.next;
//		}
        return string.toString();
    }
}