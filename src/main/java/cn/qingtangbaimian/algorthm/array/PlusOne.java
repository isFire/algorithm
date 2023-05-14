package cn.qingtangbaimian.algorthm.array;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="/"></a>
 * @date 2023-05-10 23:02:15
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] ints = new int[]{9};
        for (int i : plusOne(ints)) {
            System.out.println(i);
        }
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = ++digits[i] % 10;
            if (digits[i] > 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
