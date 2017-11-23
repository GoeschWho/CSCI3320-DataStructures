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

//package edu.gregory.gelfond.datatypes;

//import edu.gregory.gelfond.interfaces.GraphVizWriteable;
//import edu.gregory.gelfond.interfaces.Set;

/**
 * The {@code BinarySearchTree} class defines an implementation of the {@code Set}
 * abstract data type via a binary search tree.
 *
 * @param <T> the type of the objects contained within the {@code BinarySearchTree}
 * @author Gregory Gelfond (ggelfond@unomaha.edu)
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<T>> implements Set<T>, GraphVizWriteable {

    // A binary search tree is defined in terms of nodes, where a node is
    // a simple record comprised of a datum and references to the left and
    // right subtrees. In addition, the size of the subtree rooted by that
    // node is also maintained.

    class Node {
        T datum;
        int size;
        Node left;
        Node right;

        Node(T obj, int sz) {
            datum = obj;
            size = sz;
            left = null;
            right = null;
        }
    }

    // A tree is referred to via its root node.

    private Node root;

    /**
     * Initialize an empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Adds the specified object to the set.
     *
     * @param obj object to be added to the set
     */
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("argument to add() is null");
        }

        root = add(root, obj);
    }

    private Node add(Node x, T obj) {
        if (x == null) return new Node(obj, 1);

        int cmp = obj.compareTo(x.datum);

        if (cmp < 0) {
            x.left = add(x.left, obj);
        } else if (cmp > 0) {
            x.right = add(x.right, obj);
        }

        x.size = 1 + size(x.left) + size(x.right);

        return x;
    }

    /**
     * Removes all of the elements from the set.
     */
    public void clear() {
        root = null;
    }

    /**
     * Returns {@code true} if the set contains the specified object and
     * {@code false} otherwise.
     *
     * @param obj the object to find in the set
     * @return {@code true} if the set contains the specified object and
     * {@code false} otherwise
     */
    public boolean contains(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }

        return contains(root, obj);
    }

    private boolean contains(Node x, T obj) {
        if (x == null) {
            return false;
        }

        int cmp = obj.compareTo((x.datum));
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return contains(x.left, obj);
        } else {
            return contains(x.right, obj);
        }
    }

    /**
     * Returns {@code true} if the set is empty and {@code false} otherwise.
     *
     * @return {@code true} if the set is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Remove the specified object from the set, if it is present.
     *
     * @param obj the object to remove
     * @return {@code true} if the set contained the specified object and
     * {@code false} otherwise
     */
    public boolean remove(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("argument to remove() is null");
        }

        int prior = size(root);

        root = remove(root, obj);

        return prior != size(root);
    }

    private Node remove(Node x, T obj) {
        if (x == null) {
            return null;
        }

        int cmp = obj.compareTo(x.datum);

        if (cmp < 0) {
            x.left = remove(x.left, obj);
        } else if (cmp > 0) {
            x.right = remove(x.right, obj);
        } else {
            // x.datum == obj and x has no right subtree
            if (x.right == null) return x.left;

            // x.datum == obj and x has no left subtree
            if (x.left == null) return x.right;

            // x.datum == obj and x has both subtrees
            Node tmp = x;
            x = min(x.right);
            x.right = deleteMin(x.right);
            x.left = tmp.left;
        }

        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the number of elements in the set
     */
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }

        return x.size;
    }

    /**
     * Returns an array containing all of the objects in the set in the proper
     * order (from least to greatest).
     *
     * @return an array containing the objects in the set
     */
    public Object[] toArray() {
        if (isEmpty()) {
            return new Object[0];
        }

        Object[] data = new Object[size()];

        toArray(root, data, 0);

        return data;
    }

    private int toArray(Node x, Object[] xs, int idx) {
        if (x == null) {
            return idx;
        }

        int pos = toArray(x.left, xs, idx);
        xs[pos++] = x.datum;
        return toArray(x.right, xs, pos);
    }

    /**
     * Return a {@code String} representation of the binary search tree.
     *
     * @return a {@code String} representation of the  binary search tree.
     */
    public String toString() {
        StringBuilder repr = new StringBuilder();

        repr.append("{");
        generateString(root, repr);
        repr.append("}");

        return repr.toString();
    }

    private void generateString(Node x, StringBuilder repr) {
        if (x != null) {
            if (x.left != null) {
                generateString(x.left, repr);
                repr.append(", ");
            }

            repr.append(x.datum);

            if (x.right != null) {
                repr.append(", ");
                generateString(x.right, repr);
            }
        }
    }

    /**
     * Returns the GraphViz dot file representation of the calling object.
     *
     * @return the GraphViz dot file representation of the calling object
     */
    public String graphvizForm() {
        return graphvizForm(root);
    }

    private String graphvizForm(Node t) {
        StringBuilder repr = new StringBuilder();

        repr.append("digraph G {\n");
        repr.append("graph [ dpi = 150 ]\n");
        repr.append("nodesep=0.3;\n");
        repr.append("ranksep=0.2;\n");
        repr.append("margin=0.1;\n");
        repr.append("node [shape=circle];\n");
        repr.append("edge [arrowsize=0.8];\n");

        StringBuilder content = graphvizForm(new StringBuilder(), t, 1);

        repr.append(content);
        repr.append("}");

        return repr.toString();
    }

    private StringBuilder graphvizForm(StringBuilder repr, Node t, int base) {
        // if the given tree is empty, do nothing
        if (t == null) {
            return repr;
        }

        // Add to the representation the datum associated with the given node
        repr.append(String.format("node%d [label=\"%s\"];\n", base, t.datum));

        // enumerate the left and right subtrees
        int left = 2 * base;
        int right = 2 * base + 1;

        // add the content of the left subtree to our representation
        if (t.left != null) {
            repr.append(String.format("node%d -> node%d;\n", base, left));
            graphvizForm(repr, t.left, left);
        }

        // add the content of the right subtree to our representation
        if (t.right != null) {
            repr.append(String.format("node%d -> node%d;\n", base, right));
            graphvizForm(repr, t.right, right);
        }

        return repr;
    }

    /**
     * Remove the smallest element from the binary search tree rooted at x.
     *
     * @param x the root of the binary search tree
     * @return the root of the binary search tree that results from removing
     * the smallest element from the binary search tree rooted at x
     */
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;

        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    /**
     * Returns the node which contains the smallest element in the binary search
     * tree rooted at x.
     *
     * @param x the root of the binary search tree to search
     * @return the node which contains the smallest key in the binary search tree
     * rooted at x
     */
    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }

        return min(x.left);
    }
}