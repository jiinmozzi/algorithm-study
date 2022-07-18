import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon11724 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList[] g;
	static boolean[] visited;
	static int component=0;
	
	public static void DFS( int start )
	{
		if( visited[start]==false )
		{
			visited[start]=true;
		
			Iterator itr = g[start].iterator();			
			
			while( itr.hasNext() )
			{
				int adjv = (int)itr.next();
				if( visited[adjv]==false )
					DFS(adjv);
			}
		}	
	}
	
	public static int isAllVisited()
	{
		for( int i=0; i<visited.length; i++)
		{
			if( visited[i]==false )
				return i;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException
	{
		String[] info = br.readLine().split(" ");
		int vertices = Integer.parseInt( info[0] );
		int edges = Integer.parseInt( info[1] );
		
		g = new ArrayList[vertices + 1];
		visited = new boolean[vertices+1];
		visited[0]=true;
		
		for( int j=1; j<=vertices; j++ )
		{
			g[j] = new ArrayList();
			visited[j]=false;
		}
		
		for( int i=0; i<edges; i++)
		{
			String[] data = br.readLine().split(" ");
			int target = Integer.parseInt( data[0] );
			int adj = Integer.parseInt( data[1] );
			g[target].add( adj );
			g[adj].add(target);
		}
		
		while( isAllVisited() != 0 )	
		{
			DFS( isAllVisited() );
			component++;
		}
		
		System.out.print(component);

	}

}
