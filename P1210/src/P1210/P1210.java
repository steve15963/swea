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
			String temp = br.readLine(); //ù ���� ���� �ʿ� �����Ƿ� ���ɰ� 10���� �����.
			// 99���� �ϴ� ������ ������ ���ο��� 2�� ã�ƾ� �ϱ� ����.
			for(int i = 0 ;i < 99;i++) {
				// String�� �Է¹޾� ������ �����ؼ� charŸ������ �����.
				MAP[i] = br.readLine().replace(" ","").toCharArray();
			}
			//������ ������ �����͸� �ް� ������ �����Ѵ�.
			String te = br.readLine().replace(" ","");
			//2�� �ε����� �ް�
			int start = te.indexOf('2');
			//������ ���� �ִ´�.
			MAP[99] = te.toCharArray();
			// 1�پ� �ö󰡸鼭
			for(int i = 99; i >=0;i-- ) {
				//���� start������ 1�ƴҋ�����
				if(start - 1 >= 0  && MAP[i][start-1] == '1') {
					// �ƴҋ����� �ݺ�.
					while(start - 1 >= 0  && MAP[i][start-1] == '1') {
						start--;
					}
				}
				//���� start�������� 1�� �ƴҋ�����.
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
