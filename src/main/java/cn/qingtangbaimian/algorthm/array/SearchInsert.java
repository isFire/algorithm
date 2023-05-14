package cn.qingtangbaimian.algorthm.array;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="/"></a>
 * @date 2023-05-08 16:29:39
 */
public class SearchInsert {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3,4}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] >= target ? 0 : 1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] > target) {
                high = middle - 1;
            }
            if (nums[middle] < target) {
                low = middle + 1;
            }
        }
        if (low > high) {
            return low;
        }
        return high < 0 ? 0 : low >= nums.length ? nums.length : -1;
    }
}
