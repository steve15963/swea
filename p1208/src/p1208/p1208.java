package p1208;

import java.util.Arrays;
import java.util.Scanner;

public class p1208 {
	//출력 버퍼로 사용.
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int data[] = new int[100];
		for(int i = 1; i <= 10; i++) {
			int dump = sc.nextInt();
			//입력
			for(int j = 0; j< 100;j++) {
				data[j] = sc.nextInt();
			}
			//테케 출력 규격을 위한 버퍼에 추가.
			sb.append("#").append(i).append(" ");
			
			while(dump > 0) {
				// 최대와 최소를 찾기 위해서.
				Arrays.sort(data); 
				// 최대 --
				data[data.length-1]--;
				//최소 ++
				data[0]++;
				//교환 회수 --;
				dump--;
			}
			// 정렬해서
			Arrays.sort(data);
			// 최대 최소의 차이를 버퍼에 저장
			sb.append(data[data.length-1]-data[0]).append("\n");
		}
		// 버퍼 출력
		System.out.println(sb.toString());
	}
}
