import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nayoung1707 {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            visited = new int[V+1];
            q = new LinkedList<>();

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int e = 1; e <= E; e++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            bfs(V);
        }
    }

    public static void bfs(int numOfVertices) {
        for (int i = 1; i <= numOfVertices; i++) {
            if (visited[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }

            while (!q.isEmpty()) {
                int vertex = q.poll();

                for (int j = 0; j < graph[vertex].size(); j++) {
                    int vertexToVisit = graph[vertex].get(j);

                    if (visited[vertexToVisit] == 0) {
                        q.add(vertexToVisit);

                        if (visited[vertex] == 1) {
                            visited[vertexToVisit] = 2;
                        } else {
                            visited[vertexToVisit] = 1;
                        }
                    } else if (visited[vertexToVisit] == visited[vertex]) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        System.out.println("YES");
    }
}
