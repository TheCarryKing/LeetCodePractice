package com.xuthus.leetcode.practice.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len / 2);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("不存在两数之和满足条件.");
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) return 0;
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return len;
    }

    public int searchInsert2(int[] nums, int target) {
        // 二分查找
        int left = 0;
        int right = nums.length - 1;
        int curr;
        while (left < right) {
            int mid = (left + right) / 2;
            curr = nums[mid];
            if (curr == target) {
                return mid;
            } else if (curr < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;

        // 1. 状态定义
        // dp[i] 表示前 i 个元素的最大连续子数组的和
        int[] dp = new int[nums.length];

        // 2. 状态初始化，数组中第一个元素的最大和就是第一个元素值
        dp[0] = nums[0];
        ans = nums[0];

        // 3. 状态转移
        // 转移方程：dp[i] = max(dp[i - 1], 0) + nums[i]
        //  dp 当前元素的值等于前一个元素值和 0 的最大值再加上 nums[i]
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            // 更新最大和
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }


    public int maxSubArray1(int[] nums) {
        // 分而治之
        // 问题分解
        // 左边最大子数组 || 左边部分最大和+右边部分最大和 || 右边最大子数组
        return subArray(nums,0,nums.length -1);
    }

    private int subArray(int[] nums,int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        int leftVal = subArray(nums, left, mid);
        int rightVal = subArray(nums, mid + 1, right);
        int midVal = mid(nums, left, right);
        return Math.max(Math.max(leftVal, rightVal), midVal);
    }

    private int mid(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right)/2;
        int sum = 0;
        int leftMax =  Integer.MIN_VALUE;
        for(int i = mid; i > left-1;i--){
            sum +=nums[i];
            if(sum > leftMax){
                leftMax = sum;
            }
        }

        int rightMax =  Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid+1; i < right+1;i++){
            sum +=nums[i];
            if(sum > rightMax){
                rightMax = sum;
            }
        }

        return leftMax + rightMax;
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len-1;i>=0;i--){
            if(digits[i] <9){
                digits[i] = digits[i]+1;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[m - 1] < nums2[n-1] ? nums2[m-2] : nums1[p1--];
        }
        System.out.println(Arrays.toString(nums1));

    }

/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);

示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"

示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
*/
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int size = Math.min(numRows, s.length());
        List<StringBuilder> list = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            list.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();
        int len = 2 * numRows - 2;
        int index;
        int mode;
        for (int i = 0; i < chars.length; i++) {
            mode = i % len;
            index = mode < numRows ? mode : len - mode;
            list.get(index).append(chars[i]);
        }

        StringBuilder ret = new StringBuilder(s.length());
        for (StringBuilder sb : list) {
            ret.append(sb);
        }

        return ret.toString();


    }

}
