import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class nayoung11725 {
    static int N;
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new LinkedList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        visited = new boolean[N+1];
        result = new int[N+1];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            int node = graph[start].get(i);

            if (!visited[node]) {
                result[node] = start;
                dfs(node);
            }
        }
    }
}
