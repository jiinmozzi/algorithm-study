import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nayoung2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(calculate(N));

    }

    public static int calculate(int N) {
        int num5 = N / 5;
        int num3 = (N - num5 * 5) / 3;
        int remainder = N - num5 * 5 - num3 * 3;

        if (remainder == 0) {
            return num5 + num3;
        }

        if (remainder == 1 && num5 > 0) {
            return (num5 - 1) + (num3 + 2);
        }

        if (remainder == 2 && num5 > 1) {
            return (num5 - 2) + (num3 + 4);
        }

        return -1;
    }
}
