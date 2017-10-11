/**
 * The {@code Set} interface defines a minimal suite of operations that are to
 * be support by the Set abstract data type.
 *
 * @param <T> the type over which a {@code Set} is defined
 * @author Gregory Gelfond (ggelfond@unomaha.edu)
 * @version 1.0
 */
public interface Set<T> {
 
    /**
     * Adds the specified object to the set.
     *
     * @param obj object to be added to the set
     */
    void add(T obj);
 
    /**
     * Removes all of the elements from the set.
     */
    void clear();
 
    /**
     * Returns {@code true} if the set contains the specified object and
     * {@code false} otherwise.
     *
     * @param obj the object to find in the set
     * @return {@code true} if the set contains the specified object and
     *         {@code false} otherwise
     */
    boolean contains(T obj);
 
    /**
     * Returns {@code true} if the set is empty and {@code false} otherwise.
     *
     * @return {@code true} if the set is empty and {@code false} otherwise
     */
    boolean isEmpty();
 
    /**
     * Remove the specified object from the set, if it is present.
     *
     * @param obj the object to remove
     * @return {@code true} if the set contained the specified object and
     *         {@code false} otherwise
     */
    void remove(T obj);
 
    /**
     * Returns the number of elements in the set.
     *
     * @return the number of elements in the set
     */
    int size();
 
    /**
     * Returns an array containing all of the objects in the set in the proper
     * order (from least to greatest).
     *
     * @return an array containing the objects in the set
     */
    T[] toArray();
 
}