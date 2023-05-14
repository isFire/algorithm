package cn.qingtangbaimian.algorthm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="/"></a>
 * @date 2023-05-06 09:47:55
 */
public class Roman2Num {

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * @param s 罗马数字
     * @return 自然数
     */
    public static int roman2Int1(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            int num = switchRoman(aChar);
            // 只有I不需要处理
            result += num;
            if (aChar == 'I' || i == 0) {
                continue;
            }
            char aNewChar = chars[i - 1];
            while (switchRoman(aNewChar) < switchRoman(aChar)) {
                result -= switchRoman(aNewChar);
                if (i == 0 || switchRoman(chars[i--]) >= switchRoman(aChar)) {
                    break;
                }
                aNewChar = chars[i];
            }
        }
        return result;
    }

    static int switchRoman(Character aChar) {
        switch (aChar) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(roman2Int1("MCMXCIV"));
    }
}
