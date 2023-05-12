package cn.qingtangbaimian.algorthm.string;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description
 * @date 2023-05-12 10:28:11
 */
public class BinarySum {

    public static void main(String[] args) {
        System.out.println(addBinary1("1010", "1011"));
    }

    public static String addBinary2(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int mark = 0;
        StringBuilder builder = new StringBuilder();
        while (aIndex >= 0 || bIndex >= 0) {
            int num = 0;
            char aChar;
            if (aIndex >= 0) {
                aChar = a.charAt(aIndex--);
                num += aChar - '0';
            }
            if (bIndex >= 0) {
                aChar = b.charAt(bIndex--);
                num += aChar - '0';
            }
            num += mark;
            mark = 0;
            if (num >= 2) {
                mark = 1;
                num = num % 2;
            }
            builder.insert(0, num);
        }
        return mark == 1 ? builder.insert(0, 1).toString() : builder.toString();
    }

    public static String addBinary1(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int mark = 0;
        StringBuilder builder = new StringBuilder();
        while (aIndex >= 0 || bIndex >= 0) {
            int num = 0;
            char aChar;
            if (aIndex >= 0) {
                aChar = a.charAt(aIndex--);
                num += aChar - '0';
            }
            if (bIndex >= 0) {
                aChar = b.charAt(bIndex--);
                num += aChar - '0';
            }
            num += mark;
            mark = 0;
            if (num >= 2) {
                mark = 1;
                num = num % 2;
            }
            builder.insert(0, num);
        }
        if (mark == 1) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }
}
