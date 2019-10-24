/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ReverseInteger
 * Author:   Administrator
 * Date:     2019/10/24 21:29
 * Description: Given a 32-bit signed integer, reverse digits of an integer.
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xuthus.leetcode.practice.easy;

import org.junit.jupiter.api.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Given a 32-bit signed integer, reverse digits of an integer.〉
 *
 * @author Administrator
 * @create 2019/10/24
 * @since 1.0.0
 */
public class ReverseInteger {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
    }

    @Test
    public void testReverse() {
        System.out.println(reverse(-121));
        System.out.println(reverse(12431));
    }
}