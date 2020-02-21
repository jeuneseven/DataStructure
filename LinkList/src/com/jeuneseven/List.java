package com.jeuneseven;

public interface List<Element> {
	static final int ELEMENT_NOT_FOUND = -1;
	/**
	 * 清除所有元素
	 */
	void clear();

	/**
	 * 元素的数量
	 * @return
	 */
	int size();

	/**
	 * 是否为空
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	boolean contains(Element element);

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	void add(Element element);

	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	Element get(int index);

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	Element set(int index, Element element);

	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	void add(int index, Element element);

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	Element remove(int index);

	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	int indexOf(Element element);
}
