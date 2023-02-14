package p1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1228 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i< 10;i++) {
			//길이 입력 받음
			int length = Integer.parseInt(br.readLine());
			//리스트를 링크드리스트로 변환.
			LinkedList<String> LLS = new LinkedList<String>(
					Arrays.asList(
							br.readLine().split(" ")
					)
			);
			//명령어 길이를 읽고
			int command_length = Integer.parseInt(br.readLine());
			//I를 기준으로 나눠서
			StringTokenizer st = new StringTokenizer(
					br.readLine(),
					"I"
			);
			//명령어 길이만큼 반복
			for(int j = 1; j<=command_length;j++) {
				//명령어를 " "을 기준으로 나누고
				StringTokenizer st2 = new StringTokenizer(
						st.nextToken()
				);
				// 삽입위치를 입력받고
				int index = Integer.parseInt(st2.nextToken());
				// 몇개의 문자열을 삽일할건지 받는다.
				int add_length = Integer.parseInt(st2.nextToken());
				// 문자열의 수만큼 반복하며
				for(int k = 0; k < add_length; k++) {
					// 리스트에 추가한다.
					LLS.add(index+k, st2.nextToken());
				}
			}
			//테케 규격 출력
			System.out.print("#" + i + " ");
			for(int j = 0; j < 10; j++) {
				// 상위 10개출력
				System.out.print(LLS.get(j)+ " ");
			}
			//개행
			System.out.println();
		}
	}
}
