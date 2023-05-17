package cn.qingtangbaimian.algorthm.array;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="/"></a>
 * @date 2023-05-13 22:59:42
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {4,5,6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastNum1 = m - 1;
        int lastNum2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            while (lastNum1 < 0 && lastNum2 >= 0) {
                nums1[i--] = nums2[lastNum2--];
            }
            while (lastNum2 < 0 && lastNum1 >= 0) {
                nums1[i--] = nums1[lastNum1--];
            }
            if (lastNum1 < 0 && lastNum2 < 0) {
                break;
            }
            if (nums1[lastNum1] >= nums2[lastNum2]) {
                nums1[i] = nums1[lastNum1--];
                continue;
            }
            nums1[i] = nums2[lastNum2--];
        }
        System.out.println(nums1);
    }
}
