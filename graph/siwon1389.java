import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;


public class siwon1389 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList[] g;
	static boolean[] visited;
	static int[] depth;
	static int KBN=0;
	
	static Queue<Integer> bfsq = new LinkedList();
	
	static void init()
	{
		KBN=0;
		for( int i=1; i<visited.length; i++ )
		{
			visited[i]=false;
			depth[i]=0;	
		}
	}
	
	static int BFS(int start)
	{
		visited[start]=true;
		depth[start]=0;
		bfsq.add(start);
		
		while( !bfsq.isEmpty() )
		{
			int parent = bfsq.poll();
			
			Iterator itr = g[parent].iterator();			
			while( itr.hasNext() )
			{
				int adj = (int)itr.next();
				if( visited[adj]==false )
				{
					visited[adj] = true;
					//System.out.println("now searching "+adj);
					depth[adj]=depth[parent]+1;
					KBN += depth[adj];
					//System.out.println(KBN); //erase!!
					bfsq.add( adj );
				}
			}			
		}
		
		return KBN;
	}
	
	static int findKBN( int start )
	{
		init();
		return BFS( start );
	}

	public static void main(String[] args) throws IOException
	{
		String[] data = br.readLine().split(" ");
		int vertices = Integer.parseInt( data[0] );
		int edges = Integer.parseInt( data[1] );
		
		g = new ArrayList[vertices+1];
		visited = new boolean[vertices+1];
		depth = new int[vertices+1];
		
		visited[0]=true;
		for(int j=1; j<=vertices; j++)
		{
			g[j] = new ArrayList();
			visited[j] = false;
			depth[j]=0;
		}
		
		for( int i=0; i<edges; i++ )
		{
			data = br.readLine().split(" ");
			int target = Integer.parseInt( data[0] );
			int adj = Integer.parseInt( data[1] );
			g[target].add( (int)adj );
			g[adj].add( (int)target );			
		}
		
		int[] KBNS = new int[vertices+1];
		
		for( int k=1; k<=vertices; k++ )
		{
			KBNS[k] = findKBN(k);
		}
		
		int min = KBNS[1];
		
		for( int l=1; l<=vertices; l++ )
		{
			if( min > KBNS[l] )
			{
				min = KBNS[l];
			}
		}
		
		for( int m=1; m<=vertices; m++ )
		{
			if( KBNS[m] == min )
			{
				System.out.println(m);
				break;
			}
		}
		
	}

}
