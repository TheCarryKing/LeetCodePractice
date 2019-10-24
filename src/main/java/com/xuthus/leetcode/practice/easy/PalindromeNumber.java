/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PalindromeNumber
 * Author:   Administrator
 * Date:     2019/10/24 21:41
 * Description: 判断是否为回型数字
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xuthus.leetcode.practice.easy;

import org.junit.jupiter.api.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈判断是否为回型数字〉
 *
 * @author Administrator
 * @create 2019/10/24
 * @since 1.0.0
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        // 带符号必然不可能是回型
        if (x < 0) {
            return false;
        }

        // 将数字从中间分成两段
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x = x / 10;
        }

        // 偶数长度：右边和左边相等；奇数长度：左边是右边除以10的余数，则为回型
        return right == x || right / 10 == x;
    }

    @Test
    public void testIsPalindrome() {
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(1231));
        System.out.println(isPalindrome(12321));
    }

}