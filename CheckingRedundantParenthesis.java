import java.util.Scanner;
import java.util.Stack;

public class CheckingRedundantParenthesis {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
	
		for(int i = 0 ; i < t ; i++) {
			String str = scn.next();
			if(Redundant_Parenthesis(stack, str)) {
				System.out.println("Not Duplicates");
			}else {
				System.out.println("Duplicate");
			}
		}
		scn.close();
	}
	
	public static boolean Redundant_Parenthesis(Stack<String> stack , String str) {
		
		int i = 0 ;
		while(i < str.length()) {
			if(str.charAt(i) == '(') {
				stack.push("(");
				i++;
			}
			
			if(str.charAt(i) != '(' && str.charAt(i) != ')') {
				String str1 = "" ;
				while(str.charAt(i) != '(' && str.charAt(i) != ')') {
					str1 = str1 + str.charAt(i);
					i++;
				}
				stack.push(str1);
			}
			
			if(str.charAt(i) == ')') {
				if(stack.peek() != "(") {
					stack.pop();
					stack.pop();
					i++;
				}else {
					return false ;
				}
			}
				
		}
		return true ;
	}	

}
