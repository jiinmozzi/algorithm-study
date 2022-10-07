import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 풀이 참고 : https://st-lab.tistory.com/281

public class nayoung1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long low = 1;
        long high = k;

        while (low < high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int i  = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (k <= count) high = mid;
            else low = mid + 1;
        }

        System.out.println(low);
    }
}
