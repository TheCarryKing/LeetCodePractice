package com.xuthus.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 伸展树
 * 均摊时间
 * @param <T>
 */
public class SplayBinarySearchTree<T extends Comparable<? super T>> extends BinarySearchTree<T>{
    /**
     * 右单旋：将左子节点旋转为新的根节点，原根节点作为新根节点的右子节点
     * @param root 原根节点
     * @return 新的根节点
     */
    private BinaryNode<T> rotateWithLeftChild(BinaryNode<T> root) {
        if(root.left == null){
            return root;
        }

        BinaryNode<T> newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    /**
     * 左单旋：将右子节点旋转为新的根节点，原根节点作为新根节点的左子节点
     * @param root 原根节点
     * @return 新的根节点
     */
    private BinaryNode<T> rotateWithRightChild(BinaryNode<T> root) {
        if(root.right == null){
            return root;
        }

        BinaryNode<T> newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }

    /**
     * 指定根节点下插入指定数据
     * @param root 指定根节点
     * @param data 指定数据
     * @return 更新后的根节点
     */
    private BinaryNode<T> insert(BinaryNode<T> root, T data) {
        if (root == null) {
            return new BinaryNode<T>(data);
        }

        int compareResult = compareData(data, root.data);
        if(compareResult < 0){
            root.left = insert(root.left, data);
        }else if(compareResult >0){
            root.right = insert(root.right, data);
        }

        // 插入完毕后进行伸展
        return splay(root, compareResult < 0 ?root.left.data:root.right.data);
    }

    /**
     * 对指定树的指定节点进行伸展
     * @param root 指定树的根节点
     * @param data 指定的节点数据
     * @return
     */
    private BinaryNode<T> splay(BinaryNode<T> root, T data) {
        if (root == null) {
            return root;
        }

        int compareData = compareData(data, root.data);
        // 如果data对应root的根节点的左子节点
        if(compareData < 0){
            // data绕root右旋
            root = rotateWithLeftChild(root);
        }else{
            root = rotateWithRightChild(root);
        }
        return root;
    }

    /**
     * 删除指定节点下的数据
     * @param root 指定的根节点
     * @param data 指定的数据
     * @return 返回更新后的根节点
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
            root.data = findMin(root.right).data;
            root.right = remove(root.right, root.data);
        } else {
            root = (root.left == null ? root.right : root.left);
        }

        return splay(root, compareResult < 0 ?root.left.data:root.right.data);
    }

    private void  printTree(BinaryNode<T> root){
        System.out.println(root.data);

    }

    public static void main(String[] args) {
        SplayBinarySearchTree<Integer> tree = new SplayBinarySearchTree<>();
        BinaryNode<Integer> splayRoot = new BinaryNode<>(2);

        int[] preData = new int[]{3,6,5,4};
        for (int preDatum : preData) {
            splayRoot = tree.insert(splayRoot, preDatum);
        }

        ArrayList<Integer> list = tree.printFromTopToBottom(splayRoot);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public ArrayList<Integer> printFromTopToBottom(BinaryNode<Integer> pTreeRoot){ //非递归版本
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(pTreeRoot == null){
            return null;
        }
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        queue.offer(pTreeRoot);
        while(!queue.isEmpty()){
            BinaryNode<Integer> treeNode = queue.poll();
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            list.add(treeNode.data);
        }
        return list;
    }




}
