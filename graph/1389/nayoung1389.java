import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nayoung1389 {
    static int N, M;
    static int[][] graph;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];

        q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        int minValue = Integer.MAX_VALUE;
        int minPerson = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int result = bfs(i);

            if (result < minValue) {
                minValue = result;
                minPerson = i;
            }
        }

        System.out.println(minPerson);
    }

    static int bfs(int start) {
        int[] visited = new int[N+1];

        q.add(new int[]{start, 0});
        visited[start] = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[node[0]][i] == 1 && visited[i] == 0) {
                    q.add(new int[]{i, node[1] + 1});
                    visited[i] = node[1] + 1;
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (i != start) {
                result += visited[i];
            }
        }

        return result;
    }
}
