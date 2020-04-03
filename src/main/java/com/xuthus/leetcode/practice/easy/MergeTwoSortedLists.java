/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MergeTwoSortedLists
 * Author:   Administrator
 * Date:     2019/10/24 23:04
 * Description: 合并两个有序的链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xuthus.leetcode.practice.easy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈合并两个有序的链表〉
 *
 * @author Administrator
 * @create 2019/10/24
 * @since 1.0.0
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    public void testMergeTwoLists()
    {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}