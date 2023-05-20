package cn.qingtangbaimian.algorthm.search;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/sqrtx/">第69题 X的平方根</a>
 * @date 2023-05-16 11:36:18
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(6));
    }

    /**
     * 使用牛顿迭代法+2分法思想
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int low = 0;
        int high = x;
        int pre;
        double j;
        do {
            pre = (low + high) / 2;
            j = (double) x / pre;
            j = j - pre;
            high = j < 0.0 ? pre : high;
            low = j > 1.0 ? pre : low;
            if (j > 0 && j < 1) {
                return pre;
            }
            if (j < 0 && j >= -1) {
                return (low + high) / 2;
            }
            j = j < 0 ? -j : j;
        } while (j >= 1.0);
       return pre;
    }
}
