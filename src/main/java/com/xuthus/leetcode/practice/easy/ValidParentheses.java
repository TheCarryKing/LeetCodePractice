/*
  Copyright (C), 2015-2019, XXX有限公司
  FileName: ValidParentheses
  Author:   Administrator
  Date:     2019/10/24 22:41
  Description: 检查括号是否合法
  History:
  <author>          <time>          <version>          <desc>
  作者姓名           修改时间           版本号              描述
 */
package com.xuthus.leetcode.practice.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 〈一句话功能简述〉<br> 
 * 〈检查括号是否合法〉
 *
 * @author Administrator
 * @create 2019/10/24
 * @since 1.0.0
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // 利用先进后出的特性对括号进行对应的匹配
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c:chars)
        {
            switch (c){
                case '(':stack.push(')');break;
                case '[':stack.push(']');break;
                case '{':stack.push('}');break;
                default: if (stack.empty() ||stack.pop() != c)
                {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    @Test
    public void testValidParentheses(){
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("()[]{}"));
    }
}