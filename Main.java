/*
Задана строка α, состоящая только из скобок (круглых, квадратных и фигурных). Требуется определить, является ли она правильной скобочной последовательностью. 

Примеры:
правильные последовательности: [{(())}({})], []{}(), {}, (), [];
неправильные последовательности: [{(})], [(]())]{}.

 */

package TestTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static boolean checkBrackets(String a) {
        Map<Character, Character> myMap = new HashMap<>();
        myMap.put(']', '[');
        myMap.put('}', '{');
        myMap.put(')', '(');
        
        Stack<Character> myStack = new Stack<>();

        for (Character el : a.toCharArray()) {
            if (myMap.containsValue(el)) {
                myStack.push(el);
            } 
            else if (myMap.containsKey(el)) {
                if (myStack.isEmpty() || myMap.get(el) != myStack.pop()) {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        String a = "[(]())]{}";
        String b = "[{(())}({})],";
        System.out.println(checkBrackets(a));
        System.out.println(checkBrackets(b));
    }
}
