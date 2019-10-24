/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LongestCommonPrefix
 * Author:   Administrator
 * Date:     2019/10/24 22:14
 * Description: 获取字符串最长的公共前缀
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xuthus.leetcode.practice.easy;

import org.junit.jupiter.api.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈获取字符串最长的公共前缀〉
 *
 * @author Administrator
 * @create 2019/10/24
 * @since 1.0.0
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }

        if (strs.length == 1){
            return strs[0];
        }

        // 拿第一个字符串和后面的字符串一次进行比较
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }

    @Test
    public void testLongestCommonPrefix(){
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}