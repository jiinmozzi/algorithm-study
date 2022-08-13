
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;


public class siwon2178 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] g;
	static int[][] BFSCount;
	static boolean[][] visited;
	static Queue<tuple> BFSQ;
	static int M,N;
	
	public static class tuple
	{
		int a;
		int b;
		
		public tuple(int x, int y)
		{
			a=x;
			b=y;
		}
	}
	
	public static LinkedList<tuple> getAdj(tuple target)
	{
		tuple left = new tuple(target.a-1, target.b);
		tuple right = new tuple(target.a+1, target.b);
		tuple up = new tuple(target.a, target.b+1);
		tuple down = new tuple(target.a, target.b-1);
		
		LinkedList<tuple> result = new LinkedList();
		
		if( (left.a>=0) && (left.a<M) && (left.b>=0) && (left.b<N) && g[left.a][left.b]==1 && visited[left.a][left.b]==false )
			result.add(left);
		if( (right.a>=0) && (right.a<M) && (right.b>=0) && (right.b<N) && g[right.a][right.b]==1 && visited[right.a][right.b]==false )
			result.add(right);
		if( (up.a>=0) && (up.a<M) && (up.b>=0) && (up.b<N) && g[up.a][up.b]==1 && visited[up.a][up.b]==false )
			result.add(up);
		if( (down.a>=0) && (down.a<M) && (down.b>=0) && (down.b<N) && g[down.a][down.b]==1 && visited[down.a][down.b]==false )
			result.add(down);
		
		return result;
	}
	
	public static int BFS(tuple start) 
	{		
		BFSQ = new LinkedList<tuple>();		
		BFSQ.add(start);
		visited[start.a][start.b]=true;
			
		while(!BFSQ.isEmpty())
		{
			tuple target = BFSQ.poll();
			visited[target.a][target.b]=true;
			
			if( (target.a==M-1) && (target.b==N-1) )
			{
				return BFSCount[target.a][target.b]+1;
			}
			
			LinkedList<tuple> adjs = getAdj(target);
			
			Iterator<tuple> itr = adjs.iterator();
			
			while(  itr.hasNext() )
			{
				tuple adj = itr.next();
				if( BFSCount[adj.a][adj.b]==0 )
				{
					BFSCount[adj.a][adj.b]=BFSCount[target.a][target.b]+1;
				}
				BFSQ.add(adj);
			}			
		}	
		
		return 100;
	}
	
	
	
	
	public static void main(String[] args) throws IOException
	{
		String[] data = br.readLine().split(" ");
		M = Integer.parseInt(data[0]);
		N = Integer.parseInt(data[1]);
		g = new int[M][N];
		BFSCount=new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++)
		{
			for(int j=0; j<N; j++)
			{
				visited[i][j]=false;
			}
		}
		
		for(int i=0; i<M; i++)
		{
			String line = br.readLine();
			for(int j=0; j<N; j++)
			{
				g[i][j]=Integer.parseInt( Character.toString( (line.charAt(j)) ) );
			}
		}
		
//		for(int i=0; i<M; i++)
//		{
//			for(int j=0; j<N; j++)
//			{
//				System.out.print(g[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.print( BFS(new tuple(0,0)) );
		
	}

}
