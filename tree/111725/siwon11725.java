import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parentInfo;
    static ArrayList[] g;
    static Queue<Integer> bfsq = new LinkedList();

    public static void BFS(int start)
    {
        bfsq.add(start);
        parentInfo[start]=0;

        while( !bfsq.isEmpty() )
        {
            int parent = bfsq.poll();
            Iterator itr = g[parent].iterator();

            while( itr.hasNext() )
            {
                int adj = (int)itr.next();
                if( parentInfo[adj]==-1 )
                {
                    parentInfo[adj] = parent;
                    bfsq.add( adj );
                }
            }
        }
    }


    public static void main(String[] args) throws IOException
    {
        int n = Integer.parseInt( br.readLine() );
        parentInfo = new int[n+1];
        g = new ArrayList[n+1];

        for( int j=0; j<n+1; j++)
        {
            g[j] = new ArrayList<Integer>();
        }

        for( int j=0; j<n+1; j++)
        {
            parentInfo[j] = -1;
        }


        for(int i=1; i<n; i++)
        {
            String[] data = br.readLine().split(" ");
            g[ Integer.parseInt(data[0]) ].add( Integer.parseInt(data[1]) );
            g[ Integer.parseInt(data[1]) ].add( Integer.parseInt(data[0]) );
        }


        BFS(1);

        for(int i=2; i<n+1; i++)
        {
            System.out.println( parentInfo[i] );
        }

    }

}
