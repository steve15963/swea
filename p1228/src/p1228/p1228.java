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
			//���� �Է� ����
			int length = Integer.parseInt(br.readLine());
			//����Ʈ�� ��ũ�帮��Ʈ�� ��ȯ.
			LinkedList<String> LLS = new LinkedList<String>(
					Arrays.asList(
							br.readLine().split(" ")
					)
			);
			//��ɾ� ���̸� �а�
			int command_length = Integer.parseInt(br.readLine());
			//I�� �������� ������
			StringTokenizer st = new StringTokenizer(
					br.readLine(),
					"I"
			);
			//��ɾ� ���̸�ŭ �ݺ�
			for(int j = 1; j<=command_length;j++) {
				//��ɾ " "�� �������� ������
				StringTokenizer st2 = new StringTokenizer(
						st.nextToken()
				);
				// ������ġ�� �Է¹ް�
				int index = Integer.parseInt(st2.nextToken());
				// ��� ���ڿ��� �����Ұ��� �޴´�.
				int add_length = Integer.parseInt(st2.nextToken());
				// ���ڿ��� ����ŭ �ݺ��ϸ�
				for(int k = 0; k < add_length; k++) {
					// ����Ʈ�� �߰��Ѵ�.
					LLS.add(index+k, st2.nextToken());
				}
			}
			//���� �԰� ���
			System.out.print("#" + i + " ");
			for(int j = 0; j < 10; j++) {
				// ���� 10�����
				System.out.print(LLS.get(j)+ " ");
			}
			//����
			System.out.println();
		}
	}
}
