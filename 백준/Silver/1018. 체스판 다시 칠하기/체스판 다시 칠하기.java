import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    public static int check(char [][]board){
        int ans1=64;
        int ans2=64;
        char [][]board1
            = {{'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'}};
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (board[i][j] == board1[i][j]) ans1-=1;
                else ans2-=1;
            }
        }
        return min(ans1, ans2);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();
        s.nextLine();

        char [][] board = new char[N][M];
        for (int i=0; i<N; i++){
            board[i] = s.nextLine().toCharArray();
        }

        N-=7;
        M-=7;
        int ans = 64;

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                char [][] temp = new char[8][8];
                for (int k=0; k<8; k++){
                    temp[k] = new String(board[i+k],j,8).toCharArray();
                    //board에서 (i+k)번째 행 추출
                    //시작 인덱스 j 부터 길이가 8인 문자열 추출
                    //8*8 보드를
                    // 1 2 3
                    // 4 5 6 형태로 확인
                }
                ans = Math.min(ans,check(temp)); //check 함수를 통해 얼마나 고쳐야하는지 확인
                // min 함수를 통해 더 작은 값으로 업데이트
            }
        }
        System.out.println(ans);

    }
}
