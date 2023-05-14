package cn.qingtangbaimian.algorthm.array;

import java.util.Arrays;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="/"></a>
 * @date 2023-05-04 16:41:23
 */
public class HeightChecker {

    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(sort(heights));
    }

    public static int sort(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
