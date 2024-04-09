
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수열 길이 입력
        int S = Integer.parseInt(st.nextToken()); //합 출력기준
        int res = Integer.MAX_VALUE;

        int[] arr = new int[N + 1]; //입력받을 수열을 저장하는 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); //수열을 이루는 수 입력
        }

        int start = 0, end = 0, sum = 0; //길이를 구하기 위한 start, end 변수선언, sum은 start~end까지의 합
        
        while(start <= N && end <= N) {
            if(sum >= S && res > end - start) res = end - start;

            if(sum < S) sum += arr[end++];
            else sum -= arr[start++];
        }

        if (res == Integer.MAX_VALUE) System.out.println(0); //res값이 업데이트 되어 있지 않다면 0출력 == 합을 만드는 것이 불가능함을 의미
        else System.out.println(res); //이외에 경우 업데이트 한 res값 출력
    }
}