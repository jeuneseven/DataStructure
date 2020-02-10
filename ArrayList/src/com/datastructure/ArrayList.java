package com.datastructure;

public class ArrayList <Element> {
    /**
     * 元素的数量
     */
    private int size;
    /**
     * 所有的元素
     */
    private Element[] elements;
    //final相当于const
    private static final int DEFAULT_CAPACITY = 3;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        elements = (Element[]) new Object[capaticy];//所有的类都继承自Object
    }

    public ArrayList() {
        //构造函数之间相互调用通过this
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        /**     如果觉得有些浪费可以这样实现
         *          if (size <= 100) {
         *             size = 0;
         *         } else {
         *             elements = null;
         *         }
         */
        //更改为泛型之后，要将整个内存地址清空，尽量循环利用，而非 elements = null，这是将整个数组清空并销毁
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        //高效利用空间和时间，无需清空真正内存，不会造成内存浪费
        size = 0;

    }

    /**
     * 元素的数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(Element element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     * @param element
     */
    public void add(Element element) {
        elements[size++] = element;
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public Element get(int index) {
        if (index < 0 || index >= size) {
            //抛出异常
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public Element set(int index, Element element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }

        Element old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index, Element element) {
        //允许在尾部插入元素
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }

        ensureCapacity(size + 1);

        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }
    //保证容量并扩容
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
//        int newCapacity = oldCapacity + (oldCapacity >> 1); 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity * 2;
        Object [] newElements = (Object [])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = (Element [])newElements;
    }

    /**
     * 删除index位置的元素
     * @param index
     * @return 返回被删除的值
     */
    public Element remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
        Element old = elements[index];
        for (int i = index + 1; i <= size - 1; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        //改为泛型后，要将最后一个位置清空
        elements[size] = null;

        return old;
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(Element element) {
        for (int i = 0; i < size; i++) {
            //改为泛型后，需要判断对象是否相等可以留给元素来实现，这样可以自定义，如果元素不实现，默认是 ==
            if (elements[i].equals(element)) return i;
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
//            if (i != size - 1) {//如果不是最后一个元素
//                string.append(",");
//            }
        }
        string.append("]");
        return string.toString();
    }
}
