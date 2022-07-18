import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon2644 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList[] g;
	static boolean[] visited;
	static int[] depth;
	
	static Queue<Integer> bfsq = new LinkedList();
	
	public static int BFS(int start, int end)
	{
		if(start == end)
		{
			return 0;
		}
		
		depth[start]=0;
		bfsq.add(start);
		
		while( !bfsq.isEmpty() )
		{
			int parent = bfsq.poll();
			visited[parent] = true;
			Iterator itr = g[parent].iterator();
			
			while( itr.hasNext() )
			{
				int adj = (int)itr.next();
				if( visited[adj]==false )
				{
					depth[adj]=depth[parent]+1;
					if( adj == end  )
					{
						return depth[adj];
					}
					bfsq.add( adj );
				}
			}
			
		}
		
		return -1;
		
	}
	

	public static void main(String[] args) throws IOException
	{
		int vertices = Integer.parseInt( br.readLine() );
		String[] targetData = br.readLine().split(" ");
		int from = Integer.parseInt( targetData[0] );
		int to = Integer.parseInt( targetData[1] );
		int edges = Integer.parseInt( br.readLine() );
		
		g = new ArrayList[vertices+1];
		visited = new boolean[vertices+1];
		visited[0]=true;
		depth = new int[vertices+1];
		
		for(int j=1; j<=vertices; j++)
		{
			g[j] = new ArrayList();
			visited[j] = false;
		}
		
		for(int i=0; i<edges; i++)
		{
			String[] data = br.readLine().split(" ");
			int target = Integer.parseInt( data[0] );
			int adj = Integer.parseInt( data[1] );
			g[target].add(adj);
			g[adj].add(target);
		}
		
		System.out.println( BFS( from,to ) );
		
	}

}
