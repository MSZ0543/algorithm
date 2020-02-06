package algorithm;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: javaStudy
 * @description:
 * @author: szm
 * @create: 2019-12-26 15:32
 **/
public class Leetcode20 {

    public static void main(String[] args) {


        String s = "()";
            if(s.length() == 0) System.out.println("return true");
            HashMap<Character, Character> map = new HashMap<>();
            map.put(')','(');
            map.put('}','{');
            map.put(']','[');
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                if(!stack.isEmpty()){
                    char temp = stack.peek();
                    if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == temp){
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
            System.out.println(stack.isEmpty());

    }
}
