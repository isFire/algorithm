package cn.qingtangbaimian.algorthm.array;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description
 * @date 2023-05-08 14:07:44
 */
public class DeleteDuplicate {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int notEq = 0;
        int free = 1;
        do {
            // 如果当前位置小于下一个值，则继续
            if (nums[notEq] != nums[++notEq]) {
                nums[free++] = nums[notEq];
            }
        } while (notEq != nums.length - 1);
        return free;
    }
}
