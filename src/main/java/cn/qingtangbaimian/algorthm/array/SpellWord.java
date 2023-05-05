package cn.qingtangbaimian.algorthm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description
 * @date 2023-05-04 14:25:51
 */
public class SpellWord {

    public static void main(String[] args) {
        String[] words = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        System.out.println(refactorSpell(words, chars));
    }

    public static int refactorSpell(String[] words, String chars) {
        int[] charArr = new int[26];
        for (char aChar : chars.toCharArray()) {
            charArr[aChar - 'a']++;
        }
        int len = 0;
        for (String word : words) {
            int[] wordArr = new int[26];
            for (char aChar : word.toCharArray()) {
                wordArr[aChar - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < wordArr.length; i++) {
                if (wordArr[i] > charArr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                len += word.length();
            }
        }
        return len;
    }

    /**
     * 方案一
     * @param words 单词数组
     * @param chars 字符表
     * @return 总长度
     */
    public static int spell(String[] words, String chars) {
        HashMap<Character, Integer> charMap = new HashMap<>(chars.length());
        for (char aChar : chars.toCharArray()) {
            Integer num = charMap.getOrDefault(aChar, 0);
            charMap.put(aChar, ++num);
        }
        int len = 0;
        for (String word : words) {
            HashMap<Character, Integer> copyMap = (HashMap<Character, Integer>)charMap.clone();
            boolean flag = false;
            for (char c : word.toCharArray()) {
                Integer num = copyMap.getOrDefault(c, 0);
                num -= 1;
                copyMap.put(c, num);
                if (num < 0) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                len+=word.length();
            }
        }
        return len;
    }
}
