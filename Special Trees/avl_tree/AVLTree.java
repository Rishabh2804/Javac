package avl_tree;

//AVL tree class
public class AVLTree {

    private AVLNode root;
    private int size;

    // Constructor
    public AVLTree() {
        root = null;
        size = 0;
    }

    // Returns the size of the tree
    public int size() {
        return size;
    }

    // Returns true if the tree is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the root of the tree
    public AVLNode getRoot() {
        return root;
    }

    // Returns the height of the tree
    public int height() {
        return height(root);
    }

    // Returns the height of the tree rooted at the given node
    private int height(AVLNode node) {
        if (node == null)
            return -1;
        else
            return node.height;
    }

    // Returns the balance factor of the tree
    public int balanceFactor() {
        return balanceFactor(root);
    }

    // Returns the balance factor of the tree rooted at the given node
    private int balanceFactor(AVLNode node) {
        if (node == null)
            return 0;
        else
            return height(node.left) - height(node.right);
    }

    // Returns the balance factor of the tree
    public int balanceFactor(int key) {
        return balanceFactor(search(key), key);
    }

    // Returns the balance factor of the tree rooted at the given node
    private int balanceFactor(AVLNode node, int key) {
        if (node == null)
            return 0;
        else if (key < node.data)
            return height(node.left) - height(node.right);
        else
            return height(node.right) - height(node.left);
    }

    // Returns the node with the given key
    public AVLNode search(int key) {
        return search(root, key);
    }

    // Returns the node with the given key rooted at the given node
    private AVLNode search(AVLNode node, int key) {
        if (node == null)
            return null;
        else if (key < node.data)
            return search(node.left, key);
        else if (key > node.data)
            return search(node.right, key);
        else
            return node;
    }

}