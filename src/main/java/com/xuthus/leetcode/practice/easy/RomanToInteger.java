/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RomanToInteger
 * Author:   Administrator
 * Date:     2019/10/24 21:53
 * Description: 将罗马数字转换成阿拉伯数字
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xuthus.leetcode.practice.easy;

import org.junit.jupiter.api.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈将罗马数字转换成阿拉伯数字〉
 *
 * @author Administrator
 * @create 2019/10/24
 * @since 1.0.0
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();

        int prev = 0;
        int curr;
        int sum = 0;
        for (char c : chars) {
            switch (c) {
                case 'M':
                    curr = 1000;
                    break;
                case 'D':
                    curr = 500;
                    break;
                case 'C':
                    curr = 100;
                    break;
                case 'L':
                    curr = 50;
                    break;
                case 'X':
                    curr = 10;
                    break;
                case 'V':
                    curr = 5;
                    break;
                case 'I':
                    curr = 1;
                    break;
                default:
                    return 0;
            }

            sum = sum + curr;
            if (curr > prev) {
                sum = sum - prev * 2;
            }

            prev = curr;
        }

        return sum;
    }

    @Test
    public void testRomanToInt() {
        System.out.println(romanToInt("MCMXCIV"));
    }
}