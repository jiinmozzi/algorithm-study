import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nayoung1991 {
    static int N;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char data = st.nextToken().charAt(0);
            if (nodes[data-'A'] == null) nodes[data-'A'] = new Node(data);

            char left = st.nextToken().charAt(0);
            if (left != '.') {
                if (nodes[left-'A'] == null) nodes[left-'A'] = new Node(left);
                nodes[data-'A'].addLeft(nodes[left-'A']);
            }

            char right = st.nextToken().charAt(0);
            if (right != '.') {
                if (nodes[right-'A'] == null) nodes[right-'A'] = new Node(right);
                nodes[data-'A'].addRight(nodes[right-'A']);
            }
        }

        preorder(nodes[0]);
        System.out.println();
        inorder(nodes[0]);
        System.out.println();
        postorder(nodes[0]);
        System.out.println();
    }

    public static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void addLeft(Node left) {
            this.left = left;
        }

        public void addRight(Node right) {
            this.right = right;
        }
    }

    public static void preorder(Node node) {
      System.out.print(node.data);
      if (node.left != null) preorder(node.left);
      if (node.right != null) preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node.left != null) inorder(node.left);
        System.out.print(node.data);
        if (node.right != null) inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        System.out.print(node.data);
    }
}

