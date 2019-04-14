package example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class practice {
	public static void main(String[] args) {
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<5;i++)
			stack.push(i);
		System.out.println(stack);
		Collections.reverse(stack);
		System.out.println(stack);
		
		Map<Integer,Integer> map=new HashMap<>();
		
	}

}
