package csh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �ֹι��� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("==============================");
		System.out.println("�̷�ũ���� �ֹι�ȣ ���� �� ���� ���α׷�");
		System.out.println("                     - �ּ�ȯ");
		System.out.println("==============================\n");
		System.out.println("* �ֹι�ȣ �Է� (oooooo-ooooooo ������ ���� 14�ڸ�, exit �Է½� ����)\n");
		int tryCount=-1;
		int success=0;
		int fail=0;
		while(true) { 
			tryCount++;
			System.out.print(">> ������ �Է� : ");
			String inputJumin = br.readLine();
			if(inputJumin.equals("exit")) {
				System.out.println();
				System.out.println("------------------------------");
				System.out.println("* �������: ");
				System.out.println("   - �� �Է� �Ǽ�: " + tryCount + "��");
				float successf = ((float)success/(float)tryCount*100);
				System.out.println("   - ���� �ֹι�ȣ: " + success + "�� (" + String.format("%.2f", successf) +"%)"); //�ι�° �ڸ�����
				float failf = ((float)fail/(float)tryCount*100);
				System.out.println("   - ���� �ֹι�ȣ: " + fail + "�� (" + String.format("%.2f", failf) +"%)");
				break;
			} //exit�Է� ������ ���� ��

			boolean result = false; //���� ���� ���� ���ΰ��� ����

			int finalNum = 11; //������ ���� ����� 11
			int checkHap = 0; //�ֹι迭�� ���ڿ� ���ڸ� ���ؼ� ���� ��
			int lastNum = inputJumin.charAt(inputJumin.length()-1) - 48; //�ֹι�ȣ 13��° �ڸ���
			int checkLastNum = 0; //üũ�� 13��° �ڸ�������

			int[] juminArray = {2,3,4,5,6,7,8,9,2,3,4,5};

			if(inputJumin.contains("-")) {
				inputJumin = inputJumin.replace("-",""); //�������� ���ֱ�

				try {
					inputJumin = inputJumin.substring(0, inputJumin.length()-1); //üũ�� �� ���ڸ� ���꽺Ʈ��
					for(int i=0; i<juminArray.length; i++) {//üũ���� �����ֱ����� for��
						checkHap+= (inputJumin.charAt(i)-48) * juminArray[i];
					}
					checkLastNum = finalNum - (checkHap % finalNum);
					if(checkLastNum!=lastNum) {//�˻��� �������ڸ��� ���� �Է� �������� �����ʴٸ� �񱳺��� �ʱ�ȭ
						checkLastNum = 0;
					}
					if(checkLastNum==lastNum) {//�˻��� �������ڸ��� ���� �Է� �������� ���ٸ� true
						result = true;
					}
					if(result){
						success++;
						System.out.println("[���� ����] �������� �ֹι�ȣ�̸� ������ �����ϴ�.\n");
					} else {
						fail++;
						System.out.println("[���� ����] �ֹ� ��ȣ ��ġ���� ������ �ֽ��ϴ�.\n");
					}
				} catch(StringIndexOutOfBoundsException se) {//�Է¹��� ���������� ���� ĳġ
					System.out.println("-�� �����ϰ� ��� 0 ~ 9 �����̾�� �մϴ�.");
					System.out.println();
				}

			} else {//�Է¹��� �� -�� ���������� 
				System.out.println("�ֹι�ȣ�� oooooo-ooooooo ������ ���� 14�ڸ� �Դϴ�.");
				System.out.println();
			}
		}//while�� ��
	}//���� ��
}
