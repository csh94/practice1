package csh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주민문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("==============================");
		System.out.println("미래크립토 주민번호 검증 및 집계 프로그램");
		System.out.println("                     - 최수환");
		System.out.println("==============================\n");
		System.out.println("* 주민번호 입력 (oooooo-ooooooo 하이픈 포함 14자리, exit 입력시 종료)\n");
		int tryCount=-1;
		int success=0;
		int fail=0;
		while(true) { 
			tryCount++;
			System.out.print(">> 데이터 입력 : ");
			String inputJumin = br.readLine();
			if(inputJumin.equals("exit")) {
				System.out.println();
				System.out.println("------------------------------");
				System.out.println("* 최종결과: ");
				System.out.println("   - 총 입력 건수: " + tryCount + "건");
				float successf = ((float)success/(float)tryCount*100);
				System.out.println("   - 정상 주민번호: " + success + "건 (" + String.format("%.2f", successf) +"%)"); //두번째 자리까지
				float failf = ((float)fail/(float)tryCount*100);
				System.out.println("   - 오류 주민번호: " + fail + "건 (" + String.format("%.2f", failf) +"%)");
				break;
			} //exit입력 받으면 종료 끝

			boolean result = false; //검증 실패 성공 여부결정 변수

			int finalNum = 11; //정해진 공식 상수값 11
			int checkHap = 0; //주민배열의 숫자와 각자리 곱해서 더한 값
			int lastNum = inputJumin.charAt(inputJumin.length()-1) - 48; //주민번호 13번째 자리값
			int checkLastNum = 0; //체크할 13번째 자리값저장

			int[] juminArray = {2,3,4,5,6,7,8,9,2,3,4,5};

			if(inputJumin.contains("-")) {
				inputJumin = inputJumin.replace("-",""); //하이픈을 빼주기

				try {
					inputJumin = inputJumin.substring(0, inputJumin.length()-1); //체크할 맨 뒷자리 서브스트링
					for(int i=0; i<juminArray.length; i++) {//체크합을 구해주기위한 for문
						checkHap+= (inputJumin.charAt(i)-48) * juminArray[i];
					}
					checkLastNum = finalNum - (checkHap % finalNum);
					if(checkLastNum!=lastNum) {//검사한 마지막자리와 실제 입력 마지막이 같지않다면 비교변수 초기화
						checkLastNum = 0;
					}
					if(checkLastNum==lastNum) {//검사한 마지막자리와 실제 입력 마지막이 같다면 true
						result = true;
					}
					if(result){
						success++;
						System.out.println("[검증 성공] 정상적인 주민번호이며 오류가 없습니다.\n");
					} else {
						fail++;
						System.out.println("[검증 실패] 주민 번호 수치상의 오류가 있습니다.\n");
					}
				} catch(StringIndexOutOfBoundsException se) {//입력범위 맞지않을시 오류 캐치
					System.out.println("-을 제외하고 모두 0 ~ 9 숫자이어야 합니다.");
					System.out.println();
				}

			} else {//입력받을 시 -이 빠져있을때 
				System.out.println("주민번호는 oooooo-ooooooo 하이픈 포함 14자리 입니다.");
				System.out.println();
			}
		}//while문 끝
	}//메인 끝
}
