
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int N = 100000;
    static int [] honey = new int[N]; //꿀의 누적합
    static int [] prefix = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int tmp = 0;
        for (int i=0; i<N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            tmp += honey[i];
            prefix[i] = tmp;
        }

        int caseOfOne = caseOfHoney1(N);

        int caseOfThree = caseOfHoney3(N);

        tmp = 0;
        for (int i=N-1; i>=0; i--){
            tmp += honey[i];
            prefix[i] = tmp;
        }

        int caseOfTwo = caseOfHoney2(N);


        int result = Math.max(Math.max(caseOfOne, caseOfTwo), caseOfThree);
        System.out.println(result);



    }

    private static int caseOfHoney3(int N){
        //벌1 .. 꿀통 .. 벌2
        //벌1 = 0
        //벌2 = N-1
        int bean = prefix[N-1] - honey[N-1] - honey[0] + honey[1]; //꿀통의 위치가 1일때부터 계산..
        //벌2 - 벌2위치값 - 벌1위치값 + 꿀통의 값
        for (int i=2; i<N-1; i++){ //꿀통 위치를 옮겨가면서 계산
            int tmp = prefix[N-1] - honey[N-1] - honey[0] + honey[i];
            if (tmp > bean){
                bean = tmp;
            }
        }
        return bean;
    }

    private static int caseOfHoney2(int N) {
        //꿀통 ... 벌2 ... 벌1
        //벌1 = N-1
        //꿀통 = 0
        int bee2 = prefix[0] - prefix[N-2] - honey[N-2]; //처음 벌2의 위치 N-2
        for (int i = N-3; i>=0; i--){ //벌의 위치를 바꿔가면서 더 큰 값 가져오기
            int amount_bee2 = prefix[0] - prefix[i] - honey[i];
            if (bee2 < amount_bee2){
                bee2 = amount_bee2;
            }
        }

        return prefix[0] - prefix[N-1] + bee2; //꿀통 - 벌1 + 벌2
    }

    private static int caseOfHoney1(int N) {
        //벌1 ... 벌2 ... 꿀통
        //벌1 = 0
        //꿀통 = N-1
        int bee2 = prefix[N -1] - prefix[1] - honey[1]; //처음 벌2의 위치가 1일때 벌2가 가져오는 꿀의 양
        for (int i = 2; i< N; i++){ //벌의 위치를 바꿔가면서 더 큰 값을 가져온다
            int amount_bee2 = prefix[N -1] - prefix[i] - honey[i];
            if (bee2 < amount_bee2){
                bee2 = amount_bee2;
            }
        }

        return prefix[N -1] - prefix[0] + bee2; //꿀통 - 벌1 + 벌2
    }
}
