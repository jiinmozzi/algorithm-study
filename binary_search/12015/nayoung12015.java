import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 풀이 참고 : https://st-lab.tistory.com/285

public class nayoung12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[N];
        LIS[0] = A[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {
            if (LIS[lengthOfLIS - 1] < A[i]) {
                LIS[lengthOfLIS] = A[i];
                lengthOfLIS++;
            } else {
                int lo = 0;
                int hi = lengthOfLIS;

                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (LIS[mid] <= A[i]) lo = mid + 1;
                    else hi = mid;
                }

                LIS[lo] = A[i];
            }
        }

        System.out.println(lengthOfLIS);
    }
}
