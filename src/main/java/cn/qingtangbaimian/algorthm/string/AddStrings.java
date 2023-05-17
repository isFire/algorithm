package cn.qingtangbaimian.algorthm.string;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/add-strings/">第415题 字符串相加</a>
 * @date 2023-05-17 23:36:02
 */
public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }

    /**
     * 这道题前后做了三次，第一次使用if判断
     * 执行耗时:3 ms,击败了17.33% 的Java用户
     * 内存消耗:42.8 MB,击败了5.03% 的Java用户
     * ```Java
     * if (n1Index >= 0) {
     *    num += num1.charAt(n1Index--) - '0';
     * }
     * if (n2Index >= 0) {
     *     num += num2.charAt(n2Index--) - '0';
     * }
     * ```
     * 第二次，将if改为了三目运算符
     * 执行耗时:2 ms,击败了38.42% 的Java用户
     * 内存消耗:42.7 MB,击败了5.03% 的Java用户
     * ```
     * num += n1Index > -1 ? num1.charAt(n1Index--) - '0' : 0;
     * num += n2Index > -1 ? num2.charAt(n2Index--) - '0' : 0;
     * ```
     * 第三次，参考了其他大佬的方式，将builder.insert(0， num%10)改成了builder.append(num%10)
     * 在最后通过reverse()进行反转，结果效果确实比insert(0) 要好得多
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:40.6 MB,击败了95.63% 的Java用户
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int n1Index = num1.length() - 1;
        int n2Index = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        int num = 0;
        while (n1Index > -1 || n2Index > -1) {
            num = num > 9 ? 1 : 0;
            num += n1Index > -1 ? num1.charAt(n1Index--) - '0' : 0;
            num += n2Index > -1 ? num2.charAt(n2Index--) - '0' : 0;
            builder.insert(0, num % 10);
        }
        return num > 9 ? builder.insert(0, 1).toString() : builder.toString();
    }
}
