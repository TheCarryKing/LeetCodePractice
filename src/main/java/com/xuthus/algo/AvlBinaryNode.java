package com.xuthus.algo;

/**
 * 平衡二叉树节点
 * @param <T> 存储的数据的类型
 */
public class AvlBinaryNode<T> extends BinaryNode<T> {
    /**
     * 当前节点的数据
     */
    int height;

    public AvlBinaryNode(T data) {
        this(data,null,null);
    }

    public AvlBinaryNode(T data, AvlBinaryNode<T> left, AvlBinaryNode<T> right) {
        super(data,left,right);
        this.height = 0;
    }
}
