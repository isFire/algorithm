package cn.qingtangbaimian.algorthm.string;

public class LastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("  fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        char[] charArray = s.trim().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            if (c == ' ') {
                break;
            }
            builder.insert(0, c);
        }
        return builder.length();
    }
}
