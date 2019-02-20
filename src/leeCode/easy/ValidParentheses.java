package leeCode.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/10/9 20:24
 */

public class ValidParentheses {
    public static void main(String[] args) {
        Solution s=new ValidParentheses().new Solution();
        System.out.println(s.isValid("{[]}"));
    }

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack=new Stack<>();
            for (int i=0;i<s.length();i++){
                Character c=s.charAt(i);
                switch (c){
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);
                        break;
                    case ')':
                        if(stack.empty()){
                           return false;
                        }else {
                            if(stack.peek()=='('){
                                stack.pop();
                            }else{
                                return false;
                            }
                        }
                        break;
                    case ']':
                        if(stack.empty()){
                            return false;
                        }else {
                            if(stack.peek()=='['){
                                stack.pop();
                            }else{
                                return false;
                            }
                        }
                        break;
                    case '}':
                        if(stack.empty()){
                            return false;
                        }else {
                            if(stack.peek()=='{'){
                                stack.pop();
                            }else{
                                return false;
                            }
                        }
                        break;
                }
            }
            return stack.empty();
        }
    }
}
