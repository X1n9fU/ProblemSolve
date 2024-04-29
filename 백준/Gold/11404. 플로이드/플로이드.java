import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 1000000000;
    static int n, m; //도시의 개수, 버스의 개수
    static int[][] graph; // 그래프

    public static void floyd(int[][] graph, int n) {
        for (int x = 1; x <= n; x++) { //경유
            for (int y = 1; y <= n; y++) { //시작위치
                for (int z = 1; z <= n; z++) { //도착위치
                    if (graph[y][z] > graph[y][x] + graph[x][z]) //더 작은 가중치 넣어주기
                        graph[y][z] = graph[y][x] + graph[x][z];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF){
                    System.out.print('0' + " ");
                }else{
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 도시 개수 입력
        m = Integer.parseInt(br.readLine()); // 버스 개수 입력

        //그래프 초기화
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) graph[i][j] = INF;
            }
        }

        // 시작도시, 도착도시, 비용 입력 후 그래프에 값 넣어주기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //시작도시
            int b = Integer.parseInt(st.nextToken()); //도착도시
            int cost = Integer.parseInt(st.nextToken()); //비용

            graph[a][b] = Math.min(graph[a][b], cost); //a >> b로 가는 비용 cost 넣어주기
        }

        floyd(graph, n); //플로이드 함수 호출
    }
}