import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nayoung1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int result = getSum(st.nextToken());

        while (st.hasMoreTokens()) {
            result -= getSum(st.nextToken());
        }

        System.out.println(result);
    }

    public static int getSum(String s) {
        StringTokenizer st = new StringTokenizer(s, "+");

        int sum = 0;

        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        return sum;
    }
}
