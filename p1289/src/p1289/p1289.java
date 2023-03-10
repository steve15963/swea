package p1289;

import java.util.Scanner;

public class p1289 {
	
	public static int recall(char data[],int index) {
		if(data.length == index) return 0;
		else if(data[index-1]==data[index]) return 0 + recall(data, index + 1); 
		else return 1 + recall(data, index + 1);  
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char data[] = sc.nextLine().toCharArray();
			
			int count = data[0] - '0';
			System.out.println("#" + test_case + " " + (count + recall(data,1)));
			/*for(int i = 1; i < data.length; i++) {
				if(data[i-1]!=data[i]) count++;
			}
			System.out.println("#" + test_case + " " + count);
			*/
		}
	}
}
