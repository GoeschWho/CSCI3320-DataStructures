/*
 * Copyright (c) 2017 Gregory Gelfond
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

//package edu.gregory.gelfond.interfaces;

/**
 * The {@code Set} interface defines a minimal suite of operations that are to
 * be support by the Set abstract data type.
 *
 * @param <T> the type of the objects contained within the {@code Set}
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
     * {@code false} otherwise
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
     * {@code false} otherwise
     */
    boolean remove(T obj);

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
    Object[] toArray();
}