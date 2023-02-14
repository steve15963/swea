package p1233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p1233 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int TC = 1; TC <= 10; TC++) {
			int N = Integer.parseInt(br.readLine());
			
			int answer = 1;

			for(int i = 1; i <= N; i++) {
				StringTokenizer st =  new StringTokenizer(br.readLine());
				
				//���� ��ȣ�� �ǹ̰� �����Ƿ� ����.
				st.nextToken();
				
				//node�� ���� �޾ƿͼ�.
				char node = st.nextToken().charAt(0); 
				
				//3��,4�� ���� ������ �ڽ� ��尡 �ִµ�
				if(st.hasMoreTokens()) { // �ܸ� ��尡 �ƴ� �� 
					//�ڽ� ��尡 �־ ���� �����ڰ� �ƴ� ���ڶ��.
					//���� ������ �߻��Ѵ�.
					if(node >= '0' && node <= '9') {
						answer = 0;
						//���� �ʿ� ���� �����͸� �Է� ���ۿ��� ���ش�.
						for(int j = i; j < N;j++) {
							br.readLine();
						}
						// ���� �� �ʿ䰡 �����Ƿ� �����.
						break;
					}
				} else { // �ܸ� ����� �� 
					if(node < '0' || node > '9') { // ���ڿ��� �� 
						answer = 0;
						//���� �ʿ� ���� �����͸� �Է� ���ۿ��� ���ش�.
						for(int j = i; j < N;j++) {
							br.readLine();
						}
						// ���� �� �ʿ䰡 �����Ƿ� �����.
						break;
					}
				}
			}
			sb.append("#" + TC + " " + answer + '\n');
		}
		System.out.println(sb.toString());
	}

}
