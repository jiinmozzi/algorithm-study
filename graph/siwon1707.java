import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class p1707 {
	
	
	public static class MyComparator implements Comparator<Integer> 
	{
		  @Override
		  public int compare(Integer p1, Integer p2) 
		  {
			  return p1-p2;
		  }
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList[] g;
	public static int[] side;
	public static int[] BFSvisited;
	
	public static void main(String[] args) throws IOException
	{
		int times = Integer.parseInt( br.readLine()	);
		
		for(int i=0; i<times; i++)
		{
			boolean biparite = true;
			
			int vertices;
			int edges;
			
			String[] data = br.readLine().split(" ");
			
			vertices =  Integer.parseInt( data[0] );
			edges = Integer.parseInt( data[1] );
			g = new ArrayList[vertices];
			side = new int[vertices];
			BFSvisited = new int[vertices];
			
			for( int w=0; w<vertices; w++)
			{
				side[w]=0;
			}
			
			for(int q=0; q<vertices; q++)
			{
				g[q] = new ArrayList();
			}			
					
			int target, adjv;
			
			for(int j=0; j<edges; j++)
			{
				data = br.readLine().split(" ");
				target = Integer.parseInt( data[0] );
				adjv = Integer.parseInt(  data[1] );
				g[target-1].add(adjv);
				g[adjv-1].add(target);
			}	
			//연결 정보 입력 완료	
			
			if( judgeBiparite() )
				System.out.println("YES");
			else
				System.out.println("NO");
		}		
	}
	
	public static boolean judgeBiparite()
	{
		int result;
		while( undefinedInG() != -1 )
		{
			//System.out.println( undefinedInG() );
			result = BFS( undefinedInG()+1 );
			//System.out.println(result);
			if( result == -1 )	
				return false;
		}
		//System.out.println( undefinedInG() );
		return true;
	}
	
	public static int undefinedInG()
	{
		for(int i=0; i< BFSvisited.length ; i++)
		{
			if( BFSvisited[i]==0)
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int adjCheck(int target)
	{
		if( g[target-1] != null )
		{
			Iterator itr = g[target-1].iterator();
			while( itr.hasNext() )
			{
				int s = side[ (int)itr.next()-1 ]; 
				if(s!=0)
				{
					return s;
				}
			}
			return 0;
		}
		return 0;
	}
	
	public static int BFS( int start )	// biparite가 안되는 경우 -1 반환, 그 외 1 반환
	{
		Queue<Integer> bfsq = new LinkedList<Integer>();
		/*
		if( side[start-1]==0 && (g[start-1].size()!=0) )
			side[start-1]=-1;
		*/
		
		//본인의 진영 정하기
		if( adjCheck(start)==0  )
			side[start-1]=-1;
		else
			side[start-1]=-adjCheck(start);
		//System.out.println( "start is "+ start+" "+side[start-1] );
		bfsq.add(start);
		
		while(!bfsq.isEmpty())
		{
			int t = bfsq.poll();
					
			BFSvisited[t-1]=1;
			//System.out.println("now searching "+t);
			
			int motherside = side[t-1]; // 확실히 0이 아닙니다!
			
			Iterator<Integer> itr = g[t-1].iterator();	// 얘네들의 진영은 반대여야 한다
			while(itr.hasNext())
			{
				int adjv = itr.next();
				//System.out.println( "adjv "+ adjv + " adjvSide " + side[adjv-1] );
				if(	side[adjv-1]==0 )	// 인접 정점의 side가 정해지지 않았을 때
				{
					bfsq.add(adjv);
					side[adjv-1]=-motherside;
				}		
				else // 인접 정점의 side가 정해졌을 때 motherside와 같은지 확인
				{
					if( side[adjv-1] == motherside )
					{
						//System.out.println("mother and children "+ t +" "+ adjv ); // 삭제하기!
						//System.out.println("motherside and adjside "+ side[t-1] +" "+ side[adjv-1] );
						return -1;
					}
					else
					{
						bfsq.add(adjv);
						//System.out.print(adjv);
						//System.out.println("here??"); // 삭제하기!
					}
				}
			}
			g[t-1]=new ArrayList();
		}
		
		return 1;
	}
	
	public static boolean allVisited()
	{
		for(int i=0; i<BFSvisited.length; i++)
		{
			if( BFSvisited[i]==0 )
				return false;
		}
		return true;
	}
	
	
	
	
	/*
	public static boolean LorR(int a, int b)
	{
		if(	!left.contains(a) && !right.contains(a) )
		{
			if( right.contains(b) )
			{
				left.add(a);
			}
			else if( left.contains(b) )
			{
				right.add(a);
			}
			else
			{
				left.add(a);
				right.add(b);
			}			
			return true;
		}
		else if( left.contains(a) )
		{
			if(	left.contains(b) )
				return false;
			else
			{
				if(	!right.contains(b) )
					right.add(b);
				return true;
			}
		}
		else	//( right.contains(a) )
		{
			if(	right.contains(b) )
				return false;
			else
			{
				if(	!left.contains(b) )
					left.add(b);
				return true;
			}
		}
	}
	*/

}
