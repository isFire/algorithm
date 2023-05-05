package cn.qingtangbaimian.algorthm.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description
 * @date 2023-05-04 11:22:07
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        for (int i : sum(nums, target)) {
            System.out.println(i);
        }
    }

    public static int[] sum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer remainder = numMap.get(target - nums[i]);
            if (Objects.nonNull(remainder)) {
                return new int[]{i, remainder};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }
}
