package cn.qingtangbaimian.algorthm.array;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description
 * @date 2023-05-08 15:57:58
 */
public class RemoveTarget {

    public static int remoteElements(int[] nums, int val) {
        if (nums.length < 1) {
            return 0;
        }
        int index = 0;
        int free = 0;
        do {
            if (nums[index] == val) {
                nums[index] = 0;
                continue;
            }
            nums[free++] = nums[index];
        } while (++index < nums.length && free < nums.length);
        return free;
    }

    public static void main(String[] args) {
        System.out.println(remoteElements(new int[]{3,2,2,3}, 3));
    }
}
