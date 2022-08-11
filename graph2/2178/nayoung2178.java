import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nayoung2178 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static int N, M;
    static int[][] graph;
    static int[][] visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new int[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            char[] arr =  br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(arr[j]));
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        q.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int[] coord = q.poll();
            int x = coord[0];
            int y = coord[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 1 && visited[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;

                    if (nx == N-1 && ny == M-1) return visited[nx][ny];
                }
            }
        }

        return 0;
    }
}