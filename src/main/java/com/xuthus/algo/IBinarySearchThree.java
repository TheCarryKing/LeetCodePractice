package com.xuthus.algo;

import java.util.List;

public interface IBinarySearchThree<T> {
    /**
     * 判断当前树是否是空的
     * @return 当前树是否是空的
     */
    boolean isEmpty();

    /**
     *
     */
    void makeEmpty();

    /**
     *
     * @param data
     * @return
     */
    boolean contains(T data);

    /**
     *
     * @return
     */
    T findMin();

    /**
     *
     * @return
     */
    T findMax();

    /**
     *
     * @param data
     * @return
     */
    BinaryNode<T> insert(T data);

    /**
     *
     * @param data
     * @return
     */
    BinaryNode<T> remove(T data);

    /**
     * 前序遍历
     *
     * @return List<T> oject.
     */
    List<T> preOrderTraversal();


    /**
     * 中序遍历
     *
     * @return List<T> object.
     */
    List<T> inOrderTraversal();

    /**
     * 后序遍历
     *
     * @return List<T> object
     */
    List<T> postOrderTraversal();



}
