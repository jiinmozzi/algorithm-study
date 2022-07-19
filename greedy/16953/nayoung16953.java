import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nayoung16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(calcalate(A, B));
    }

    public static int calcalate(int A, int B) {
        int tmp = B;
        int cnt = 1;

        while (A < tmp) {
            if (tmp % 10 == 1) {
                tmp /= 10;
            } else if (tmp % 2 == 0) {
                tmp /= 2;
            } else {
                return -1;
            }

            cnt++;
        }

        if (tmp < A) {
            return -1;
        } else {
            return cnt;
        }
    }
}
