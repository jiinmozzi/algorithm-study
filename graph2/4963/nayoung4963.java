import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nayoung4963 {
    static int w, h;
    static int[][] graph;
    static boolean[][] visited;

    static final int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static final int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            graph = new int[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        result++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(result);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < w && ny < h && graph[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
