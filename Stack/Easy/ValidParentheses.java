package Stack.Easy;

import java.util.*;

public class ValidParentheses {

    private boolean isValid(String s){
        Map<Character,Character> parenthesesEnum = Map.of(
                ')' , '(',
                '}' , '{',
                ']', '['
        );

        List<Character> stack = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(parenthesesEnum.containsKey(c)){
                if(!stack.isEmpty() && stack.getLast() == parenthesesEnum.get(c)){
                    stack.removeLast();
                }else {
                    return false;
                }
            }else{
                stack.add(c);
            }

        }
        return stack.isEmpty();

    }

    //clean version using Dequeue
    private boolean isValidCleanVersion(String s){
        Map<Character,Character> pair = Map.of(
                ')', '(',
                '}', '{',
                ']','['
        );
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(pair.containsValue(c)){
                stack.push(c);
            }else if(pair.containsKey(c)){
                if(stack.isEmpty() || stack.pop() != pair.get(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validator = new ValidParentheses();

        String[] testCases = {
                "()",       // true
                "()[]{}",   // true
                "(]",       // false
                "([)]",     // false
                "{[]}",     // true
                "(((",      // false
                "",         // true
                "[",        // false
                "([]{})",   // true
                "([}}])",   // false
        };

        for (String test : testCases) {
            System.out.println("Input: " + test);
            System.out.println("isValid: " + validator.isValid(test));
            System.out.println("isValidCleanVersion: " + validator.isValidCleanVersion(test));
            System.out.println("----");
        }
    }
}
