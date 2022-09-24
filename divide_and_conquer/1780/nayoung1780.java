import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nayoung1780 {
    static int N;
    static int[][] graph;

    static int result1 = 0;
    static int result2 = 0;
    static int result3 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, N);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static void divideAndConquer(int x, int y, int size) {
        int value = graph[x][y];

        if (size == 1) {
            if (value == -1) result1++;
            else if (value == 0) result2++;
            else result3++;

            return;
        }


        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != graph[i][j]) {
                    divideAndConquer(x, y, size/3);
                    divideAndConquer(x + size/3, y, size/3);
                    divideAndConquer(x + 2 * size/3, y, size/3);
                    divideAndConquer(x, y + size/3, size/3);
                    divideAndConquer(x + size/3, y + size/3, size/3);
                    divideAndConquer(x + 2 * size/3, y + size/3, size/3);
                    divideAndConquer(x, y + 2 * size/3, size/3);
                    divideAndConquer(x + size/3, y + 2 * size/3, size/3);
                    divideAndConquer(x + 2 * size/3, y + 2 * size/3, size/3);
                    return;
                }
            }
        }

        if (value == -1) result1++;
        else if (value == 0) result2++;
        else result3++;
    }
}
