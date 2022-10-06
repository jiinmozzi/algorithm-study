import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class nayoung19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            items.add(new Item(name, value));
        }

        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());

            int low = 0;
            int high = N-1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (power <= items.get(mid).value) high = mid - 1;
                else low = mid + 1;
            }

            sb.append(items.get(high+1).name).append('\n');
        }

        System.out.println(sb);

    }

    static class Item {
        String name;
        int value;

        public Item(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
}
