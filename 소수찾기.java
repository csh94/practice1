package csh.java;

public class 소수문제 {
    public static void main(String[] args) {
        System.out.println("======================");
        System.out.println("미래크립토 소수 판단 프로그램");
        System.out.println("             -최수환");
        System.out.println("======================");
        int minNum = 1000;
        int maxNum = 0;
        int total = 0;
        for(int i = 0 ; i < 100; i++){ 
             int num = (int)(Math.random()*1000)+1; //1부터 1000까지의 숫자중 랜덤 숫자
             if(check(num)){ 
                 System.out.println("소수발견: "  + num);
                 total++;
                 if(minNum > num) {minNum = num;}
                 if(maxNum < num) {maxNum = num;}
             }//if문 끝
        }//for문 끝
        System.out.println("----------------------");
        System.out.println("최종결과: ");
        System.out.println("   소수 개수: " + total);
        System.out.println("   최소 소수: " + minNum);
        System.out.println("   최대 소수: " + maxNum);
        System.out.println("======================");
    }//main문 끝

    public static boolean check(int count){
        boolean checkResult = true;
        for(int i = 2; i < count; i++){ //소수는 1과 자신이외에 나누어떨어지는 수가 없어야함.
            if(count%i == 0){ 
                checkResult = false; 
                break;
            } else {
            	checkResult = true; 
            }
        }
        return checkResult;
    }//check메서드 끝
}