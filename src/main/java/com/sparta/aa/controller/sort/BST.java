package com.sparta.aa.controller.sort;

import com.sparta.aa.controller.sort.binaryTree.Treeable;
import com.sparta.aa.model.exception.ChildNotFoundException;
import com.sparta.aa.model.exception.RootNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BST implements Sortable, Treeable {

    private Node root;

    public BST() {
    }

    public BST(int[] values) {
        addElements(values);
    }

    public BST(int value) {
        this.root = new Node(value);
    }
    
    class Node {
        private final int value;
        private Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeftChildNull() {
            return leftChild == null;
        }

        public boolean isRightChildNull() {
            return rightChild == null;
        }
    }

    @Override
    public int[] sort(int[] unsorted) {
        BST sorter = new BST(unsorted);
        return sorter.getSortedTreeAsc();
    }

    @Override
    public int getRootElement() throws RootNotFoundException {
        if (root != null) {
            return root.getValue();
        }
        throw new RootNotFoundException("Root node does not exist");
    }

    @Override
    public int getNumberOfElements() {
        return getNodeCount(root);
    }

    @Override
    public void addElement(int element) {
        addNodeToTree(root, element);
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addNodeToTree(root, element);
        }
    }

    @Override
    public boolean findElement(int value) {
        try {
            Node node = getElementLevelOrder(root, value);
        } catch (ChildNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = getElementLevelOrder(root, element).getLeftChild();
        if (node != null) {
            return node.getValue();
        }
        throw new ChildNotFoundException("Left child of " + element +" does not exist");
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = getElementLevelOrder(root, element).getRightChild();
        if (node != null) {
            return node.getValue();
        }
        throw new ChildNotFoundException("Right child of " + element +" does not exist");
    }

    @Override
    public int[] getSortedTreeAsc() {
        return traverseInorderAndGetNodeValuesAscending(root).stream().mapToInt(i->i).toArray();
    }

    @Override
    public int[] getSortedTreeDesc() {
        return traverseInorderAndGetNodeValuesDescending(root).stream().mapToInt(i->i).toArray();
    }

    public int getNodeCount(final Node node) {
        return (node != null) ? 1 + getNodeCount(node.getLeftChild()) + getNodeCount(node.getRightChild()) : 0;
    }

    public void addNodeToTree(Node node, int element) {
        if(node == null) {  // root element has not been set
            root = new Node(element);
        } else if (element < node.getValue()) {                            // Smaller value
            if (node.isLeftChildNull()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else {                                                    // Greater or equal value
            if (node.isRightChildNull()) {
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    public Node getElementLevelOrder(Node node, int value) throws ChildNotFoundException {
        if (node != null) {
            if (node.getValue() == value) {
                return node;
            }
            getElementLevelOrder(node.getLeftChild(), value);
            getElementLevelOrder(node.getRightChild(), value);
        }
        throw new ChildNotFoundException("Node with value " + value + " does not exist");
    }

    public List<Integer> traverseInorderAndGetNodeValuesAscending(Node node) {
        if (node != null) {

            List<Integer> valuesAscending = new ArrayList<>();
            if (!node.isLeftChildNull()) {
                valuesAscending.addAll(traverseInorderAndGetNodeValuesAscending(node.getLeftChild()));
            }

            valuesAscending.add(node.getValue());

            if (!node.isRightChildNull()) {
                valuesAscending.addAll(traverseInorderAndGetNodeValuesAscending(node.getRightChild()));
            }

            return valuesAscending;
        }
        return new ArrayList<>(0);
    }

    public List<Integer> traverseInorderAndGetNodeValuesDescending(Node node) {
        if (node != null) {

            List<Integer> valuesAscending = new ArrayList<>();

            if (!node.isRightChildNull()) {
                valuesAscending.addAll(traverseInorderAndGetNodeValuesDescending(node.getRightChild()));
            }

            valuesAscending.add(node.getValue());

            if (!node.isLeftChildNull()) {
                valuesAscending.addAll(traverseInorderAndGetNodeValuesDescending(node.getLeftChild()));
            }

            return valuesAscending;
        }
        return new ArrayList<>(0);
    }
}
