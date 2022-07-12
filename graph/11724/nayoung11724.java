import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nayoung11724 {
    static int N;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
