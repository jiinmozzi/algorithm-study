import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nayoung17070 {
    static int N;
    static int[][] graph;
    static Queue<int[]> q;
    static int result;

    final static int HORIZOTAL = 0;
    final static int DIAGONAL = 1;
    final static int VERTICAL = 2;

    final static int[] dx = { 0, 1, 1 };
    final static int[] dy = { 1, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        q = new LinkedList<>();
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (graph[N-1][N-1] != 1) bfs();

        System.out.println(result);
    }

    public static void bfs() {
        q.add(new int[]{0, 1, HORIZOTAL});

        while (!q.isEmpty()) {
            int[] coord = q.poll();
            int x = coord[0];
            int y = coord[1];
            int direction = coord[2];

            if (x == N-1 && y == N-1) {
                result++;
                continue;
            }

            if (direction == HORIZOTAL || direction == VERTICAL) {
                // direction
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (nx < N && ny < N && graph[nx][ny] == 0) {
                    q.add(new int[]{nx, ny, direction});
                }

                // DIAGONAL
                ny = y + dy[DIAGONAL];
                nx = x + dx[DIAGONAL];

                if (nx < N && ny < N && graph[nx][ny] == 0 && graph[nx-1][ny] == 0 && graph[nx][ny-1] == 0) {
                    q.add(new int[]{nx, ny, DIAGONAL});
                }
            } else {    // DIAGONAL
                // HORIZONTAL
                int nx = x + dx[HORIZOTAL];
                int ny = y + dy[HORIZOTAL];

                if (nx < N && ny < N && graph[nx][ny] == 0) {
                    q.add(new int[]{nx, ny, HORIZOTAL});
                }

                // DIAGONAL
                nx = x + dx[DIAGONAL];
                ny = y + dy[DIAGONAL];

                if (nx < N && ny < N && graph[nx][ny] == 0 && graph[nx-1][ny] == 0 && graph[nx][ny-1] == 0) {
                    q.add(new int[]{nx, ny, DIAGONAL});
                }

                // VERTICAL
                nx = x + dx[VERTICAL];
                ny = y + dy[VERTICAL];

                if (nx < N && ny < N && graph[nx][ny] == 0) {
                    q.add(new int[]{nx, ny, VERTICAL});
                }
            }
        }
    }
}
