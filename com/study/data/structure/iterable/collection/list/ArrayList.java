package com.study.data.structure.iterable.collection.list;

import java.util.Arrays;

public class ArrayList<E> implements List<E>, Cloneable {

	private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기
	private static final Object[] EMPTY_ARRAY = {};	// 빈 배열

	private int size;	// 요소 개수

	Object[] array;	// 요소를 담을 배열

	public ArrayList() {
		this.array = EMPTY_ARRAY;
		this.size = 0;

	}

	public ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}


	private void resize() {
		int currentCapacity = array.length;

		if (Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}

		if (size == currentCapacity) {
			int expandCapacity = currentCapacity * 2;
			array = Arrays.copyOf(array, expandCapacity);
			return;
		}
		if (size < (currentCapacity / 2)) {
			int expandCapacity = currentCapacity / 2;
			array = Arrays.copyOf(array, Math.max(expandCapacity, DEFAULT_CAPACITY));
		}
	}

	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}

	public void addLast(E value) {

		if (size == array.length) {
			resize();
		}
		array[size] = value;
		size++;
	}


	@Override
	public void add(int index, E value) {

		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == size) {
			addLast(value);
		}
		else {

			if(size == array.length) {
				resize();
			}

			if (size - index >= 0)
				System.arraycopy(array, index, array, index + 1, size - index);

			array[index] = value;	// index 위치에 요소 할당
			size++;
		}
	}

	public void addFirst(E value) {
		add(0, value);
	}


	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return (E) array[index];
	}


	@Override
	public void set(int index, E value) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			array[index] = value;
		}
	}


	@Override
	public int indexOf(Object value) {
		int i = 0;

		for (i = 0; i < size; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}


	public int lastIndexOf(Object value) {
		for(int i = size - 1; i >= 0; i--) {
			if(array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}


	@Override
	public boolean contains(Object value) {
		return indexOf(value) >= 0;
	}



	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		E element = (E) array[index];
		array[index] = null;

		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
			array[i + 1] = null;
		}
		size--;
		resize();
		return element;
	}

	@Override
	public boolean remove(Object value) {
		int index = indexOf(value);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		resize();
	}


	// 부록 메소드
	@Override
	public Object clone() throws CloneNotSupportedException {

		ArrayList<?> cloneList = (ArrayList<?>)super.clone();

		cloneList.array = new Object[size];

		System.arraycopy(array, 0, cloneList.array, 0, size);

		return cloneList;
	}

	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}


	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			return (T[]) Arrays.copyOf(array, size, a.getClass());
		}
		System.arraycopy(array, 0, a, 0, size);
		return a;
	}

}