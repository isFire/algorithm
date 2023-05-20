package cn.qingtangbaimian.algorthm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/climbing-stairs/"></a>
 * @date 2023-05-18 10:46:18
 */
public class ClimbStairs {


    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    static Map<Integer, Integer> memorandum = new HashMap<>();

    /**
     * 这道题是参考了<a href="https://zhuanlan.zhihu.com/p/365698607">看一遍就理解：动态规划详解</a>写出来的
     * 动态规划类问题确实是个短板，通过备忘录方式，记录已经计算出来的
     * @param n 楼梯阶数
     * @return 爬楼方法数
     */
    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        if (memorandum.containsKey(n)) {
            return memorandum.get(n);
        }
        int num = climbStairs(n - 1) + climbStairs(n - 2);
        memorandum.put(n, num);
        return num;
    }
}
