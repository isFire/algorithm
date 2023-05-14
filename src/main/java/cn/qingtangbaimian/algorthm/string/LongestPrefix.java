package cn.qingtangbaimian.algorthm.string;

import java.util.Arrays;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/longest-common-prefix/">第14题 最长公共前缀</a>
 * @date 2023-05-06 15:32:02
 */
public class LongestPrefix {

    public static void main(String[] args) {
        System.out.println(longest1(new String[]{"aaa","aa","aaa"}));
    }

    /**
     * 解题思路：
     * 假设strs[0]就是最长公共前缀，定义最大长度字符数组为strs[0].toCharArray() 然后从str[1]开始遍历数组
     * 如果遍历的字符串长度,小于目前的最大公共字符数组长度，则截断数组，只保留最前N违
     * @param strs
     * @return
     */
    public static String longest1(String[] strs) {
        // 假设数组第一位就是最大长度
        char[] maxPossible = strs[0].toCharArray();
        // 从第二位开始对比
        for (int i = 1; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            if (chars.length == 0 || maxPossible.length == 0) {
                return "";
            }
            int min = Math.min(chars.length, maxPossible.length);
            int maxIndex = -1;
            for (int j = 0; j < min; j++) {
                if (maxPossible[j] != chars[j]) {
                    break;
                }
                maxIndex = j;
            }
            maxPossible = Arrays.copyOfRange(maxPossible, 0, maxIndex+1);
        }
        return new String(maxPossible);
    }
}
