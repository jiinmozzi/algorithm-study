import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon1325 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList[] g;
	static boolean[] visited;
	static int component=0;
	static int[] BFSCount;
	static Queue<Integer> BFSQ;
	
	
	public static void BFS(int t) 
	{		
		for(int i=0; i<visited.length; i++)
		{
			visited[i] = false;
		}
		BFSQ = new LinkedList<Integer>();		
		BFSQ.add(t);
		visited[t]=true;
		
		
		while(!BFSQ.isEmpty())
		{
			int target = BFSQ.poll();
			BFSCount[t] += 1;
			
			for( int i=0; i<g[target].size(); i++ )
			{
				if( visited[ (int)(g[target].get(i)) ] == false )
				{
					BFSQ.add( (int)(g[target].get(i)) );
					visited[ (int)(g[target].get(i)) ] = true;
				}
			}
		}	
		BFSCount[t] -= 1;

	}
	
	public static void main(String[] args) throws IOException
	{
		String[] data = br.readLine().split(" ");
		int vertices = Integer.parseInt(data[0]);
		int edges = Integer.parseInt(data[1]);
		g = new ArrayList[vertices+1];
		BFSCount = new int[vertices+1];
		visited = new boolean[vertices+1];
		
		int adj1,adj2;
		
		for(int i=0; i<vertices+1; i++)
		{
			g[i] = new ArrayList();
			visited[i] = false;
		}
		
		for(int i=0; i<edges; i++)
		{
			data = br.readLine().split(" ");
			adj1 = Integer.parseInt( data[0] );
			adj2 = Integer.parseInt( data[1] );
//			g[adj1].add(adj2);
			g[adj2].add(adj1);
		}
		
//		for(int i=0; i<g.length; i++)
//		{
//			System.out.println(i);
//			System.out.println(g[i]);
//		}
		
		for(int i=1; i<vertices+1; i++)
		{
			BFS(i);
		}
		
		int max = BFSCount[1];
		for(int j=1; j<vertices+1; j++)
		{
			if( max < BFSCount[j] )
			{
				max = BFSCount[j];
			}
		}
		
		ArrayList<Integer> answers = new ArrayList();
		for(int j=1; j<vertices+1; j++)
		{
			if( max == BFSCount[j] )
			{
				answers.add(j);
			}
		}
		
		class ascending implements Comparator<Integer> {
			  @Override
			  public int compare( Integer p1, Integer p2) {
			    return p1-p2;
			  }
		}
		
		ascending a1 = new ascending();
		answers.sort(a1);
		
		Object[] realAnswer = answers.toArray();
		StringBuffer sb = new StringBuffer();
		
		for( int k=0; k<realAnswer.length; k++ )
		{
			sb.append(realAnswer[k]+" ");
		}
		
		System.out.println( sb.toString() ); 
	}

}
