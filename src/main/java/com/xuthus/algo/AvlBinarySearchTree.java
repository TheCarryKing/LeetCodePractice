package com.xuthus.algo;

/**
 * 平衡二叉树
 * 加入旋转自平衡
 * @param <T>
 */
public class AvlBinarySearchTree<T extends Comparable<? super T>> extends BinarySearchTree<T>{

    /**
     * 左右子树允许最大高度差
     */
    private static final int ALLOWED_IMBALANCE = 1;

    private int height( BinaryNode<T> root) {
        if (root instanceof AvlBinaryNode) {
            return ((AvlBinaryNode<T>) root).height;
        }

        return -1;
    }

    /**
     * 右单旋：将左子节点旋转为新的根节点，原根节点作为新根节点的右子节点
     * @param root 原根节点
     * @return 新的根节点
     */
    private AvlBinaryNode<T> rotateWithLeftChild(AvlBinaryNode<T> root) {
        AvlBinaryNode<T> newRoot = (AvlBinaryNode<T>) root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        // 更新节点的高
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), root.height) + 1;
        return newRoot;
    }

    /**
     * 左单旋：将右子节点旋转为新的根节点，原根节点作为新根节点的左子节点
     * @param root 原根节点
     * @return 新的根节点
     */
    private AvlBinaryNode<T> rotateWithRightChild(AvlBinaryNode<T> root) {
        AvlBinaryNode<T> newRoot = (AvlBinaryNode<T>) root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        // 更新节点的高
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        newRoot.height = Math.max(height(newRoot.right), root.height) + 1;
        return newRoot;
    }

    /**
     * 右双旋：将左子树的右子节点作为新的根节点，原根节点作为新根节点的右子节点
     * 原左子树的右节点下的右节点作为新的右子树的左节点
     * 原左子树的右节点下的左节点作为新的左子树的右节点
     * 先将左子节点左旋，然后对根节点右旋
     *            K3          |     |                K2
     *     K1           D     |---->|       K1               K3
     * A       K2             |---->|   A        B      C          D
     *      B      C          |     |
     * @param root 原根节点K3
     * @return 新根节点K2
     */
    private AvlBinaryNode<T> doubleWithLeftChild(AvlBinaryNode<T> root) {
        root.left = rotateWithRightChild((AvlBinaryNode<T>) root.left);
        return rotateWithLeftChild(root);
    }

    /**
     * 左双旋
     * @param root 原根节点
     * @return 新的根节点
     */
    private AvlBinaryNode<T> doubleWithRightChild(AvlBinaryNode<T> root) {
        root.right = rotateWithLeftChild((AvlBinaryNode<T>) root.right);
        return rotateWithRightChild(root);
    }

    /**
     * 指定根节点下插入指定数据
     * @param root 指定根节点
     * @param data 指定数据
     * @return 更新后的根节点
     */
    private AvlBinaryNode<T> insert(AvlBinaryNode<T> root, T data) {
        if (root == null) {
            return new AvlBinaryNode<T>(data);
        }

        int compareResult = compareData(data, root.data);
        if(compareResult < 0){
            root.left = insert((AvlBinaryNode<T>) root.left, data);
        }else if(compareResult >0){
            root.right = insert((AvlBinaryNode<T>) root.right, data);
        }

        // 插入完毕需要进行平衡操作
        return balance(root);
    }

    private AvlBinaryNode<T> balance(AvlBinaryNode<T> root) {
        if (root == null) {
            return root;
        }

        if (height(root.left) - height(root.right) > ALLOWED_IMBALANCE) {
            if (height(root.left.left) - height(root.left.right) > ALLOWED_IMBALANCE) {
                rotateWithLeftChild(root);
            } else {
                doubleWithLeftChild(root);
            }
        } else if (height(root.right) - height(root.left) > ALLOWED_IMBALANCE) {
            if (height(root.right.right) - height(root.right.left) > ALLOWED_IMBALANCE) {
                rotateWithRightChild(root);
            } else {
                doubleWithRightChild(root);
            }
        }

        // 重新计算根节点的高度
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    /**
     * 删除指定节点下的数据
     * @param root 指定的根节点
     * @param data 指定的数据
     * @return 返回更新后的根节点
     */
    private AvlBinaryNode<T> remove(AvlBinaryNode<T> root, T data) {
        if (root == null) {
            return null;
        }

        int compareResult = compareData(data, root.data);
        if (compareResult < 0) {
            root.left = remove((AvlBinaryNode<T>) root.left, data);
        } else if (compareResult > 0) {
            root.right = remove((AvlBinaryNode<T>) root.right, data);
        } else if (root.left != null && root.right != null) {
            root.data = findMin(root.right).data;
            root.right = remove((AvlBinaryNode<T>) root.right, root.data);
        } else {
            root = (AvlBinaryNode<T>) (root.left == null ? root.right : root.left);
        }

        return balance(root);
    }

}
