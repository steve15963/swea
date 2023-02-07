package P1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1210 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1 ;tc <= 10;tc++) {
			char MAP[][] = new char[100][100];
			String temp = br.readLine(); //첫 숫자 제거 필요 없으므로 테케가 10개라 명시적.
			// 99까지 하는 이유는 마지막 라인에서 2를 찾아야 하기 때문.
			for(int i = 0 ;i < 99;i++) {
				// String을 입력받아 공백을 제거해서 char타입으로 만든다.
				MAP[i] = br.readLine().replace(" ","").toCharArray();
			}
			//마지막 지점의 데이터를 받고 공백을 제거한다.
			String te = br.readLine().replace(" ","");
			//2의 인덱스를 받고
			int start = te.indexOf('2');
			//마지막 맵을 넣는다.
			MAP[99] = te.toCharArray();
			// 1줄씩 올라가면서
			for(int i = 99; i >=0;i-- ) {
				//만약 start왼쪽이 1아닐떄까지
				if(start - 1 >= 0  && MAP[i][start-1] == '1') {
					// 아닐떄까지 반복.
					while(start - 1 >= 0  && MAP[i][start-1] == '1') {
						start--;
					}
				}
				//만약 start오른쪽이 1이 아닐떄까지.
				else if(start + 1 < 100 && MAP[i][start+1] == '1') {
					while(start + 1 < 100 && MAP[i][start+1] == '1') {
						start++;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(start).append("\n");
		}
		System.out.println(sb.toString());
	}
}
