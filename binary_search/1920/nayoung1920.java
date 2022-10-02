import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nayoung1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());
            if (isInArr(A, m)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean isInArr(int[] A, int m) {
        int min = 0, max = A.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (A[mid] == m) return true;
            else if (A[mid] < m) min = mid + 1;
            else max = mid - 1;
        }

        return false;
    }
}
