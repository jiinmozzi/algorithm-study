import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nayoung7562 {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int l;
    static int[][] graph;
    static int[][] visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            l = Integer.parseInt(br.readLine());
            graph = new int[l][l];
            visited = new int[l][l];
            q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(startX, startY, endX, endY));
        }
    }

    public static int bfs(int startX, int startY, int endX, int endY) {
        q.add(new int[]{startX, startY});
        visited[startX][startY] = 0;
        if (startX == endX && startY == endY) return visited[startX][startY];

        while (!q.isEmpty()) {
            int[] coord = q.poll();
            int x = coord[0];
            int y = coord[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l && visited[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;

                    if (nx == endX && ny == endY) return visited[nx][ny];
                }
            }
        }

        return -1;
    }
}
