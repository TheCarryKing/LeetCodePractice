package com.xuthus.algo;

import java.nio.BufferUnderflowException;
import java.util.Comparator;
import java.util.List;

/**
 * 二叉查找树
 *
 * @param <T>
 * @author Administrator
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements IBinarySearchThree<T> {

    /**
     * 二分查找树的根节点
     */
    private BinaryNode<T> root;

    /**
     * 比较工具
     */
    private Comparator<? super T> comparator;

    public BinarySearchTree() {
        this.root = null;
    }

    public void setComparator(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    protected int compareData(T data1, T data2) {
        if (comparator != null) {
            return comparator.compare(data1, data2);
        } else {
            return data1.compareTo(data2);
        }
    }

    /**
     * 判断是否是空树
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 将当前树置空
     */
    @Override
    public void makeEmpty() {
        this.root = null;
    }

    /**
     * 当前树是否包含指定节点
     *
     * @param data 指定的数据
     * @return 是否包含指定数据
     */
    @Override
    public boolean contains(T data) {
        return contains(root, data);
    }

    /**
     * 当前树是否包含指定节点
     *
     * @param data 指定的数据
     * @return 是否包含指定数据
     */
    private boolean contains(BinaryNode<T> root, T data) {
        if (isEmpty()) {
            return false;
        }

        int compareResult = compareData(data, root.data);
        if (compareResult < 0) {
            return contains(root.left, data);
        } else if (compareResult > 0) {
            return contains(root.right, data);
        } else {
            return true;
        }
    }

    /**
     * 获取当前树下全部节点的最小值
     *
     * @return 当前树下全部节点的最小值
     */
    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).data;
    }


    /**
     * 获取当前树下全部节点的最小值对应的节点
     *
     * @param root 当前树的根节点
     * @return 当前树下全部节点的最小值对应的节点
     */
    protected BinaryNode<T> findMin(BinaryNode<T> root) {
        if (root != null) {
            while (root.left != null) {
                root = root.left;
            }
        }

        return root;
    }

    /**
     * 获取当前树下全部节点的最大值
     *
     * @return 当前树下全部节点的最大值
     */
    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMax(root).data;
    }

    /**
     * 获取当前树下全部节点的最大值对应的节点
     *
     * @param root 当前树的根节点
     * @return 当前树下全部节点的最大值对应的节点
     */
    private BinaryNode<T> findMax(BinaryNode<T> root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }

        return root;
    }

    /**
     * 向当前树插入指定数据节点
     *
     * @param data 指定数据
     * @return 返回对应的节点
     */
    @Override
    public BinaryNode<T> insert(T data) {
        return insert(this.root, data);
    }

    /**
     * 向指定根节点插入指定数据节点
     * 判断当前数据是不是已经存在，已经存在则不需要插入，不存在则进行插入
     *
     * @param root 指定根节点
     * @param data 指定数据
     * @return 返回更新后的根节点
     */
    private BinaryNode<T> insert(BinaryNode<T> root, T data) {
        if (root == null) {
            return new BinaryNode<>(data, null, null);
        }

        int compareResult = compareData(data, root.data);
        if (compareResult < 0) {
            root.left = insert(root.left, data);
        } else if (compareResult > 0) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    /**
     * 删除指定数据
     *
     * @param data 指定数据
     * @return 更新后的节点
     */
    @Override
    public BinaryNode<T> remove(T data) {
        return remove(root, data);
    }

    /**
     * 删除指定节点下的指定数据
     *
     * @param root 指定的根节点
     * @param data 指定的数据
     * @return 更新后的节点
     */
    private BinaryNode<T> remove(BinaryNode<T> root, T data) {
        if (root == null) {
            return null;
        }

        int compareResult = compareData(data, root.data);
        if (compareResult < 0) {
            root.left = remove(root.left, data);
        } else if (compareResult > 0) {
            root.right = remove(root.right, data);
        } else if (root.left != null && root.right != null) {
            //用右子树的最小子节点作为新的根节点，并删除右子树的最小子节点
            root.data = findMin(root.right).data;
            root.right = remove(root.right, root.data);
        } else {
            root = root.left == null ? root.right : root.left;
        }

        return root;
    }

    @Override
    public List<T> preOrderTraversal() {
        return null;
    }

    @Override
    public List<T> inOrderTraversal() {
        return null;
    }

    @Override
    public List<T> postOrderTraversal() {
        return null;
    }
}
