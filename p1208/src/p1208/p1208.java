package p1208;

import java.util.Arrays;
import java.util.Scanner;

public class p1208 {
	//��� ���۷� ���.
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int data[] = new int[100];
		for(int i = 1; i <= 10; i++) {
			int dump = sc.nextInt();
			//�Է�
			for(int j = 0; j< 100;j++) {
				data[j] = sc.nextInt();
			}
			//���� ��� �԰��� ���� ���ۿ� �߰�.
			sb.append("#").append(i).append(" ");
			
			while(dump > 0) {
				// �ִ�� �ּҸ� ã�� ���ؼ�.
				Arrays.sort(data); 
				// �ִ� --
				data[data.length-1]--;
				//�ּ� ++
				data[0]++;
				//��ȯ ȸ�� --;
				dump--;
			}
			// �����ؼ�
			Arrays.sort(data);
			// �ִ� �ּ��� ���̸� ���ۿ� ����
			sb.append(data[data.length-1]-data[0]).append("\n");
		}
		// ���� ���
		System.out.println(sb.toString());
	}
}
