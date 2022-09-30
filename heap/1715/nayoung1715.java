import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class nayoung1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            heap.add(n);
        }

        int sum = 0;

        for (int i = 1; i < N; i++) {
            int min = heap.poll() + heap.poll();
            heap.add(min);
            sum += min;
        }

        System.out.println(sum);
    }
}