package ru.samsung.lesson12032021;

public class BinaryTree {
    int value;
    BinaryTree lchild;
    BinaryTree rchild;

    public BinaryTree(int value) {
        this.value = value;
        this.lchild = null;
        this.rchild = null;
    }

    public BinaryTree insertNode(BinaryTree node, int targetValue) {
        if (node == null) {
            node = new BinaryTree(targetValue);
            return node;
        }

        if (node.value > targetValue) {
            if (node.lchild == null) {
                return node.lchild = new BinaryTree(targetValue);
            } else
                return insertNode(node.lchild, targetValue);
        }
        if (node.value < targetValue) {
            if (node.rchild == null) {
                return node.rchild = new BinaryTree(targetValue);
            } else
                return insertNode(node.rchild, targetValue);
        }

        return null;
    }

    public String printBinaryTree(BinaryTree node, int level) {
        String s = "";
        if (node != null) {
            s =s+ printBinaryTree(node.lchild, level + 1);
            s =s+node.value+", ";
            s += printBinaryTree(node.rchild, level + 1);
        }
        return s;
    }
}
