package com.jeuneseven;

public class BinarySearchTree<E> {
    private int size;
    private Node<E> rootNode;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        elementNotNullCheck(element);
        //添加根节点
        if (rootNode == null) {
            rootNode = new Node<>(element, null);
            size++;
            return;
        }
        //添加的不是第一个节点
        Node<E>node = rootNode;


    }

    public void clear() {

    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    private int compare(E e1, E e2) {

        return 0;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element can not null");
        }
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element, Node<E>parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
