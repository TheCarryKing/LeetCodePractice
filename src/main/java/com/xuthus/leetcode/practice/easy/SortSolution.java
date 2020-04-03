package com.xuthus.leetcode.practice.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 常用的排序算法
 */
public class SortSolution {

    /**
     * 插入排序,指针从1->LENGTH保证，再此之前的顺序
     * @param arr 入参数组
     */
    public void insertionSort(int[] arr){
        int pre;
        for (int p = 1; p < arr.length; p++) {
            int temp = arr[p];
            for (pre = p; pre > 0 && arr[pre - 1] > temp; pre--) {
                // 需要交换值则依次移位
                arr[pre] = arr[pre - 1];
            }
            // 交换值
            arr[pre] = temp;
        }

    }

    @Test
    public void testInsertionSort(){
        int[] arr = new int[]{34,8,64,51,32,21};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序
     * @param arr 入参数组
     */
    public void shellSort(int[] arr){
        int j;
        for (int gap = arr.length/2;gap>0;gap/=2){
            for (int i = gap;i < arr.length;i++){
                int temp = arr[i];
                for (j = i; j>=gap && temp <arr[j - gap];j-=gap){
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }
        }
    }

    @Test
    public void testShellSort(){
        int[] arr = new int[]{81,94,11,96,12,35,17,95,28,58,41,75,15};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序，升序使用最大堆
     * @param arr 入参数组
     */
    public void heapSort(int[] arr) {
        //1.构建大顶堆
        int length = arr.length;
        //从第一个非叶子结点从下至上，从右至左调整结构
        for (int i = length / 2 - 1; i >= 0; i--) {
            buildHeap(arr, length, i);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            //将堆顶元素与末尾元素进行交换
            arr[j] = arr[0] + arr[j];
            arr[0] = arr[j] - arr[0];
            arr[j] = arr[j] - arr[0];

            //重新对堆进行调整,更新arr[0]
            buildHeap(arr, j, 0);
        }
    }

    private void buildHeap(int[] arr, int length, int i) {
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {

            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            int temp = arr[i];
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }

            //将temp值放到最终的位置
            arr[i] = temp;
        }
    }

    @Test
    public void testHeapSort(){
        int[] arr = new int[]{7, 6, 7, 11, 5, 12, 3, 0, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param arr 入参数组
     */
    public void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] tempArr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tempArr, start, mid);
            mergeSort(arr, tempArr, mid + 1, end);
            merge(arr, tempArr, start, mid, end);
        }
    }

    private void merge(int[] arr, int[] tempArr, int start, int mid, int end) {
        int rightStart = mid +1;
        int tmpPos = start;
        int num = end - start + 1;
        while (start <= mid && rightStart <= end){
            if(arr[start] <= arr[rightStart]){
                tempArr[tmpPos++] = arr[start++];
            }else{
                tempArr[tmpPos++] = arr[rightStart++];
            }
        }

        // 处理剩余部分
        while (start <= mid){
            tempArr[tmpPos++] = arr[start++];
        }

        while (rightStart <= end){
            tempArr[tmpPos++] = arr[rightStart++];
        }

        for (int i = 0; i < num; i++) {
            arr[end] = tempArr[end];
            end--;
        }
    }

    @Test
    public void testMergeSort(){
        int[] arr = new int[]{24, 13, 26, 1, 2, 27, 38, 15};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr 入参数组
     */
    public void quickSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    @Test
    public void testQuickSort(){
        int[] arr = new int[]{24, 13, 26, 1, 2, 27, 38, 15};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
