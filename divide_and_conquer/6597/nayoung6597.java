import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nayoung6597 {
    public static char[] preorder;
    public static char[] inorder;
    public static char[] postorder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();

        while (input != null) {
            st = new StringTokenizer(input);

            preorder = st.nextToken().toCharArray();
            inorder = st.nextToken().toCharArray();
            postorder = new char[preorder.length];

            getPostorder(0, preorder.length - 1, 0, preorder.length - 1, 0, preorder.length - 1);

            System.out.println(new String(postorder));

            input = br.readLine();
        }

        br.close();
    }

    public static void getPostorder(int startPre, int endPre, int startIn, int endIn, int startPost, int endPost) {
        if (startPre > endPre || startIn > endIn) return;

        char root = preorder[startPre];
        postorder[endPost] = root;

        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == root) {
                int leftSize = i - startIn;
                getPostorder(startPre+1, startPre+leftSize, startIn, i-1, startPost, startPost+leftSize-1);
                getPostorder(startPre+leftSize+1, endPre, i+1, endIn, startPost+leftSize, endPost-1);
                break;
            }
        }
    }
}
