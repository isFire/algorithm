package cn.qingtangbaimian.algorthm.string;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">李昭</a>
 * @description <a href="/"></a>
 * @date 2023-05-05 10:47:07
 */
public class RemoveDuplicate {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        char lastChar = 0;
        for (char aChar : chars) {
            if (builder.length() == 0 || lastChar == 0) {
                lastChar = aChar;
                builder.append(lastChar);
                continue;
            }
            builder = lastChar == aChar ? builder.deleteCharAt(builder.length() - 1)
                    : builder.append(aChar);
            lastChar = lastChar == aChar ?
                    builder.length() > 0 ? builder.substring(builder.length() - 1).toCharArray()[0] : 0 :
                    aChar;
        }
        return builder.toString();
    }
}
