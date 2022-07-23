import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nayoung2644 {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static Queue<int[]> q;
    static int target1;
    static int target2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        q = new LinkedList<>();

        bfs(target1);
    }

    public static void bfs(int start) {
        int depth = 0;
        q.add(new int[]{start, depth});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int i = 1; i <= n; i++) {
                if (graph[node[0]][i] == 1 && !visited[i]) {
                    if (i == target2) {
                        System.out.println(node[1]+1);
                        return;
                    }
                    q.add(new int[]{i, node[1]+1});
                    visited[i] = true;
                }
            }
        }

        System.out.println(-1);
        return;
    }
}
