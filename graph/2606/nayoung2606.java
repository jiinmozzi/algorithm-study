import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nayoung2606 {
    static int numOfComputers;
    static int numOfPairs;
    static int[][] graph;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        numOfComputers = Integer.parseInt(bf.readLine());
        numOfPairs = Integer.parseInt(bf.readLine());

        graph = new int[numOfComputers+1][numOfComputers+1];
        visited = new boolean[numOfComputers+1];

        result = 0;

        for (int i = 0; i < numOfPairs; i++) {
            String[] nodes = bf.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);
            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        dfs(1);

        System.out.println(result);
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= numOfComputers; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i);
                result++;
            }
        }
    }
}