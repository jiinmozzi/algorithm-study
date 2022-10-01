import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon1991
{

    public static void preorder(node start)
    {
        System.out.print(start.name);
        if(start.left != null) {
            preorder(start.left);
        }
        if(start.right != null ) {
            preorder(start.right);
        }
    }

    public static void inorder(node start)
    {
        if(start.left != null) {
            inorder(start.left);
        }
        System.out.print(start.name);
        if(start.right != null ) {
            inorder(start.right);
        }
    }

    public static void postorder(node start)
    {
        if(start.left != null) {
            postorder(start.left);
        }
        if(start.right != null ) {
            postorder(start.right);
        }
        System.out.print(start.name);

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static class node
    {
        public String name;
        public node left;
        public node right;

        public node(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }
    }

    static ArrayList<node> nodes = new ArrayList();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        node root=null;
        for (int i = 0; i < n; i++)
        {
            String[] data = br.readLine().split(" ");
            node a;
            //처음
            if(nodes.isEmpty()) {
                a = new node(data[0]);

                if( data[1].compareTo(".")==0 ){
                    a.left=null;
                }
                else{
                    a.left = new node(data[1]);
                }

                if( data[2].compareTo(".")==0 ){
                    a.right=null;
                }
                else{
                    a.right= new node(data[2]);
                }
                nodes.add(a);
                root = a;
            }
            else{
                //이제 받는 노드들은 모두 기존에 있는 노드들이다.
                a=null;

                Iterator<node> itr = nodes.iterator();
                while(itr.hasNext())
                {
                    node aa = itr.next();
                    if(aa!=null && aa.name.compareTo(data[0])==0)
                    {
                        a = aa;
                    }
                }

                if(a==null)
                {
                    System.out.println("Something's Wrong");
                }

                if( data[1].compareTo(".")==0 ){
                    a.left=null;
                }
                else{
                    a.left = new node(data[1]);
                }

                if( data[2].compareTo(".")==0 ){
                    a.right=null;
                }
                else{
                    a.right= new node(data[2]);
                }
            }

            nodes.add(0,a.left);
            nodes.add(0,a.right);

        }

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();

    }


}
