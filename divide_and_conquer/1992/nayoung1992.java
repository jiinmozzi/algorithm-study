import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nayoung1992 {
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                graph[i][j] = input[j];
            }
        }


        System.out.println(quadtree(0, 0, N));
    }

    public static String quadtree(int x, int y, int size) {
        char value = graph[x][y];

        if (size == 1) return Character.toString(value);

        String result = "(";

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (graph[i][j] != value) {
                    result += quadtree(x, y, size / 2);
                    result += quadtree(x, y+size/2, size / 2);
                    result += quadtree(x+size/2, y, size / 2);
                    result += quadtree(x+size/2, y+size/2, size / 2);

                    return result + ")";
                }
            }
        }

        return Character.toString(value);
    }
}
