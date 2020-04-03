package com.xuthus.leetcode.practice.easy;

import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void removeElement() {
        int[] nums = new int[]{1, 2,3,2};
        int len = solution.removeElement(nums, 2);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    @Test
    void maxSubArray() {
        int[] nums = new int[]{1, 2,-3,2};
        int len = solution.maxSubArray1(nums);
        System.out.println(len);
    }

    @Test
    void merge() {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        solution.merge(nums1,0,nums2,1);
    }

    @Test
    void convert() {
        String str = "PAYPALISHIRING";
        System.out.println(solution.convert(str,3));
    }
}