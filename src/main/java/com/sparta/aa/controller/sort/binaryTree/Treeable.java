package com.sparta.aa.controller.sort.binaryTree;

import com.sparta.aa.model.exception.ChildNotFoundException;
import com.sparta.aa.model.exception.RootNotFoundException;

public interface Treeable {

    int getRootElement() throws RootNotFoundException;

    int getNumberOfElements();

    void addElement(int element);

    void addElements(final int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}
