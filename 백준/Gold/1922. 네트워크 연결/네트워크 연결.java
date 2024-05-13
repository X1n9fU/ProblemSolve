import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Edge implements Comparable<Edge>{

    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}

public class Main {
    static int [] parent;
    static ArrayList<Edge> edgeList;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        edgeList = new ArrayList<>();

        for (int i=0; i<M; i++){ //간선의 개수로 삽입
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(s,e,w));
        }

        Collections.sort(edgeList);

        parent = new int[N+1]; //노드
        for (int i=1; i<N+1; i++){
            parent[i] = i;
        }

        int ans = 0;
        for (int i=0; i<edgeList.size(); i++){
            Edge e = edgeList.get(i);

            if (find(e.start) != find(e.end)){
                ans += e.weight;
                union(e.start, e.end);
            }
        }

        System.out.println(ans);
    }

    public static int find(int x){
        if (x == parent[x]){
            return x;
        }

        return find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y){
            parent[y] = x;
        }
    }
}