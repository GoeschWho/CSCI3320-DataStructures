public interface Sequence<T> {
 
    /**
     * Adds the specified object to the end of the sequence.
     *
     * @param obj object to be appended to this sequence
     */
    void add(T obj);
 
    /**
     * Adds the specified object at the given position in the sequence.
     *
     * @param idx index at which the specified object is to be inserted
     * @param obj object to be appended to this sequence
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index > size())
     */
    void add(int idx, T obj) throws IndexOutOfBoundsException;
 
    /**
     * Removes all of the elements from the sequence.
     */
    void clear();
 
    /**
     * Returns the object at the specified position in the sequence.
     *
     * @param idx index of the element to return
     * @return the object at the specified position in the sequence
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index > size())
     */
    T get(int idx) throws IndexOutOfBoundsException;
 
    /**
     * Returns {@code true} if the sequence contains the specified object and
     * {@code false} otherwise.
     *
     * @param obj the object to find in the sequence
     * @return {@code true} if the sequence contains the specified object and
     *         {@code false} otherwise
     */
    boolean contains(T obj);
 
    /**
     * Returns the index of the first occurrence of the specified object in
     * this sequence, or -1 if object is not present.
     *
     * @param obj the object to find in the sequence
     * @return the index of the first occurrence of the specified object in
     *         this sequence, or -1 if object is not present
     */
    int indexOf(T obj);
 
    /**
     * Returns {@code true} if the sequence is empty and {@code false}
     * otherwise.
     *
     * @return {@code true} if the sequence is empty and {@code false}
     *         otherwise
     */
    boolean isEmpty();
 
    /**
     * Removes the object at the specified position in the sequence.
     *
     * @param idx index of the element to remove
     * @return the object previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index > size())
     */
    T remove(int idx) throws IndexOutOfBoundsException;
 
    /**
     * Remove the first occurrence of the specified object from the sequence,
     * if it is present.
     *
     * @param obj the object to remove
     * @return {@code true} if the sequence contained the specified object and
     *         {@code false} otherwise
     */
    boolean remove(T obj);
 
    /**
     * Returns the number of elements in the sequence.
     *
     * @return the number of elements in the sequence
     */
    int size();
 
    /**
     * Returns an array containing all of the elements in the sequence in the
     * proper order (from first to last).
     *
     * @return an array containing the elements of the sequence
     */
    Object[] toArray();
 
}