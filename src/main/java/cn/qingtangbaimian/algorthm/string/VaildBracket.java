package cn.qingtangbaimian.algorthm.string;

import java.util.Stack;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/two-sum/">第1题 两数之和</a>
 * @date 2023-05-07 23:21:55
 */
public class VaildBracket {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Stack<Byte> stack = new Stack<>();
        char[] brackets = s.toCharArray();
        for (char bracket : brackets) {
            byte index = getIndex(bracket);
            if (index <= 0) {
                return false;
            }
            if (index <= 3) {
                stack.push(index);
                continue;
            }
            if (stack.isEmpty() || stack.pop() != index - 3) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static byte getIndex(char bracket) {
        switch (bracket){
            case '{': return 1;
            case '[': return 2;
            case '(': return 3;
            case '}': return 4;
            case ']': return 5;
            case ')': return 6;
            default: return 0;
        }
    }

}
