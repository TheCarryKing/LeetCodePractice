package com.xuthus.leetcode.practice.easy;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class TwoSum {

    private int[] twoSum( int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>(nums.length/2);
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(target - nums[i])) {
                return new int[]{m.get(target - nums[i]), i};
            } else {
                m.put(nums[i], i);
            }
        }
        return nums;
    }

    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
}
