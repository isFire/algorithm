package cn.qingtangbaimian.algorthm.string;

import java.util.List;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description
 * @date 2023-05-09 11:21:01
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        String result = "1";
        if (n == 1) {
            return result;
        }
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char lastChar = result.charAt(0);
            int num = 0;
            for (int j = 0; j < result.length(); j++) {
                char charAt = result.charAt(j);
                if (lastChar != charAt) {
                    builder.append(num).append(lastChar);
                    num = 0;
                }
                if (j == result.length() - 1) {
                    builder.append(++num).append(charAt);
                    break;
                }
                num++;
            }
            result = builder.toString();
        }
        return result;
    }
}
