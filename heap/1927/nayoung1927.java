import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nayoung1927 {
    static class Heap {
        private int[] arr;
        private int size;

        public Heap(int N) {
            arr = new int[N+1];
            size = 0;
        }

        public void add(int item) {
            arr[++size] = item;

            for (int i = size; i > 1; i /= 2) {
                if (arr[i/2] > arr[i]) swap(i/2, i);
                else break;
            }
        }

        public int remove() {
            if (size == 0) return 0;

            int root = arr[1];
            arr[1] = arr[size--];

            for (int i = 1; i * 2 <= size; ) {
                if (arr[i] < arr[i*2] && arr[i] < arr[i*2+1]) {
                    break;
                } else if (arr[i*2] < arr[i*2+1]) {
                    swap(i, i*2);
                    i = i*2;
                } else {
                    swap(i, i*2+1);
                    i = i*2+1;
                }
            }

            return root;
        }

        public void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) {
                heap.add(x);
            } else {
                System.out.println(heap.remove());
            }
        }
    }
}