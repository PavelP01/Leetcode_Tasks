package leetcode.others.parenthesis;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Deque<Character> items = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character head = items.peekFirst();
            if (head != null && ((head == '{' && chars[i] == '}') ||
                            (head == '[' && chars[i] == ']') ||
                            (head == '(' && chars[i] == ')'))) {
                items.removeFirst();
            } else {
                items.addFirst(chars[i]);
            }

        }
        return items.isEmpty();
    }
}
