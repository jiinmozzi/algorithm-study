import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nayoung1260 {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

       graph = new int[N+1][N+1];
       visited = new boolean[N+1];
       q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1][n2] = graph[n2][n1] = 1;
        }

        dfs(V);
        System.out.println();

        visited = new boolean[N+1];

        bfs(V);
        System.out.println();
    }

    public static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(vertex + " ");

            for (int i = 1; i <= N; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}