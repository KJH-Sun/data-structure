package com.study.data.structure.iterable.collection.list;

public interface List<E> {

		/**
		 * @param value Elements to add to the list
		 * @return Returns {@code false} if the list does not allow duplication and
		 * returns {@code true} if the list already has duplicate elements
		 */
		boolean add(E value);

		void add(int index, E value);

		E remove(int index);

		/**
		 * @param value Elements to remove to the list
		 * @return Returns {@code false} if there are no elements in the list to delete,
		 * or {@code true} if the deletion is successful
		 */
		boolean remove(Object value);

		E get(int index);

		void set(int index, E value);

		boolean contains(Object value);

		int indexOf(Object value);

		int size();

		boolean isEmpty();

		public void clear();

}
