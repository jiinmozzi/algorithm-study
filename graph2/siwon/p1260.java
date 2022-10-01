import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.Comparator;

public class p1260 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static vertex[] g;
	
	static class vertex
	{
		public LinkedList<Integer> adj;	
		public boolean visited;
		
		public vertex()
		{
			adj = new LinkedList();
			visited = false;
		}
		
		public String toString()
		{
			return adj.toString();
		}
		
	}
	
	public static class MyComparator implements Comparator<Integer> 
	{
		  @Override
		  public int compare(Integer p1, Integer p2) 
		  {
			  return p1-p2;
		  }
	}

	public static void main(String[] args) throws IOException
	{
		String[] data = br.readLine().split(" ");
		
		int vertices;
		int edges;
		int start;
		
		vertices = Integer.parseInt( data[0] );
		edges = Integer.parseInt( data[1] );
		start = Integer.parseInt( data[2] );
		
		g = new vertex[vertices];
		
		for(int i=0; i<vertices; i++)
		{
			g[i] = new vertex();
		}
		
		int t;
		int a;
		
		for(int i=0; i<edges; i++)
		{
			String[] info = br.readLine().split(" ");
			t=Integer.parseInt( info[0] );
			a=Integer.parseInt( info[1] );
			g[t-1].adj.add(a);
			g[a-1].adj.add(t);
		}
				
		MyComparator c = new MyComparator();
			
		for(int i=0; i<vertices; i++)
		{
			g[i].adj.sort(c);
		}
		
		/*
		for(int i=0; i<vertices; i++)
		{
			System.out.println(	g[i] );	
		}
		*/
		
		DFS(start);
		System.out.println();
		
		for(int i=0; i<g.length; i++)
		{
			g[i].visited = false;
		}
		
		BFS(start);
		
	}
	
	public static void DFS( int start )
	{
		System.out.print( start + " ");
		g[start-1].visited = true;
		LinkedList<Integer> ad = g[start-1].adj;
		Iterator<Integer> adjs = ad.iterator();
		int adjv;
		while( adjs.hasNext() )
		{
			adjv = adjs.next();
			if(	g[adjv-1].visited == false )
				DFS(adjv);
		}	
	}
	
	public static Queue<Integer> bfsq = new LinkedList<Integer>();
	public static void BFS( int start )
	{
		bfsq.add(start);
		System.out.print( start + " " );
		g[start-1].visited = true;
		while(!bfsq.isEmpty())
		{
			int t = bfsq.poll();	
			Iterator<Integer> itr = g[t-1].adj.iterator();
			while(itr.hasNext())
			{
				int adjv = itr.next();
				if(	g[adjv-1].visited==false )
				{
					bfsq.add(adjv);
					System.out.print( adjv + " " );
					g[adjv-1].visited=true;
				}		
			}
		}	
	}
	
	
	
}
