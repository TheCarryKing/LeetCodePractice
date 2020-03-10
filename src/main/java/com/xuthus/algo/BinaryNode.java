package com.xuthus.algo;

/**
 * 二叉树节点
 * @param <T> 存储的数据的类型
 */
public class BinaryNode<T> {
    /**
     * 当前节点的数据
     */
    T data;

    /**
     * 当前节点的左子节点
     */
    BinaryNode<T> left;

    /**
     * 当前节点的右子节点
     */
    BinaryNode<T> right;

    public BinaryNode(T data) {
        this(data,null,null);
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
