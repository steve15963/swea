package pBracketCheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class pBracketCheck {
	static Stack<Character> st = new Stack<Character>();
	public static boolean pushPop(char element) {
		switch(element) {
		case '(':
			st.push(')');
			break;
		case '[':
			st.push(']');
			break;
		case '{':
			st.push('}');
			break;
		case '<':
			st.push('>');
			break;
		case ')':
		case ']':
		case '}':
		case '>':
			if(st.empty() ||st.peek() != element)
				return true;
			st.pop();
		}
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 10;i++) {
			int length = Integer.parseInt(br.readLine());
			char data[] = br.readLine().toCharArray();
			int j;
			for(j = 0; j < length; j++) {
				if(pushPop(data[j])) break;
			}
			if(j == length)
				sb.append('#').append(i).append(" 1\n");
			else
				sb.append('#').append(i).append(" 0\n");
			st.clear();
		}
		System.out.println(sb.toString());
	}
}
