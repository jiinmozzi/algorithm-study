import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nayoung7569 {
    static int[][][] graph;
    static int M, N, H, days;
    static Queue<int[]> q;

    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[M+1][N+1][H+1];
        q = new LinkedList<>();
        LinkedList<int[]> ripeTomatoes = new LinkedList<>();

        for (int k = 1; k <= H; k++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int i = 1; i <= M; i++) {
                    int value = Integer.parseInt(st.nextToken());
                    graph[i][j][k] = value;

                    if (value == 1) {
                        ripeTomatoes.add(new int[]{i, j, k});
                    }
                }
            }
        }

        q.addAll(ripeTomatoes);

        days = 0;

        bfs();

        if (isEverythingRipe()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int qSize = q.size();
            boolean becomeRipe = false;

            for (int cnt = 0; cnt < qSize; cnt++) {
                int[] tomato = q.poll();

                for (int i = 0; i < 6; i++) {
                    int nx = tomato[0] + dx[i];
                    int ny = tomato[1] + dy[i];
                    int nz = tomato[2] + dz[i];

                    if (nx > 0 && nx <= M && ny > 0 && ny <= N && nz > 0 && nz <= H && graph[nx][ny][nz] == 0) {
                        graph[nx][ny][nz] = 1;
                        q.add(new int[]{nx, ny, nz});
                        becomeRipe = true;
                    }
                }
            }

            if (becomeRipe) {
                days++;
            }
        }
    }

    static boolean isEverythingRipe() {
        for (int k = 1; k <= H; k++) {
            for (int j = 1; j <= N; j++) {
                for (int i = 1; i <= M; i++) {
                    if (graph[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
