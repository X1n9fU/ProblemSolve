
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        final int INF = 987654321;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int [] num = new int[N];
        st = new StringTokenizer(br.readLine());
        int prefix = 0;
        for (int i=0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == S) {
                System.out.println(1);
                return;
            }
            prefix += tmp;
            num[i] = prefix;
        }

        if (num[N-1] == S) {
            System.out.println(N);
            return;
        }

        int result = INF;
        for (int i=0; i<N; i++){
            for (int j=i+1; j<N; j++){
                if (num[j] - num[i] >= S){
                    result = Math.min(result, j - i);
                    break;
                }

            }
        }

        if (result != INF)
            System.out.println(result);
        else
            System.out.println(0);


    }
}
