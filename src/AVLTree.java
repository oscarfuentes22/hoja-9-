import structure5.Structure;

import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;

class AVLTree<E> implements Structure<E> {

    @Override
    public void add() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E value) {
        return false;
    }

    @Override
    public void add(E value) {

    }

    @Override
    public E remove(E value) {
        return null;
    }

    @Override
    public Enumeration elements() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Collection<E> values() {
        return null;
    }

    @Override
    public Palabra get(Palabra palabra) {
        return null;
    }

    private class AVLNode {
        String data;
        int height;
        AVLNode left;
        AVLNode right;

        public AVLNode(String data) {
            this.data = data;
            height = 1;
            left = null;
            right = null;
        }
    }

    private AVLNode root;
    private Comparator<String> comparator;

    public AVLTree() {
        this.root = null;
        this.comparator = Comparator.naturalOrder();
    }

    public void insert(String data) {
        root = insert(root, data);
    }

    private AVLNode insert(AVLNode node, String data) {
        if (node == null) {
            return new AVLNode(data);
        }

        if (comparator.compare(data, node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (comparator.compare(data, node.data) > 0) {
            node.right = insert(node.right, data);
        } else {
            // Duplicate data, do nothing
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balanceFactor = balanceFactor(node);

        if (balanceFactor > 1) {
            if (comparator.compare(data, node.left.data) < 0) {
                return rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (balanceFactor < -1) {
            if (comparator.compare(data, node.right.data) > 0) {
                return rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }
}
