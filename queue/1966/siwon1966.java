import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class siwon1966 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Queue<document> q;

	public static void main(String[] args) throws IOException
	{
		int n = Integer.parseInt( br.readLine() );
		for(int i=0; i<n; i++)
		{
			int target = printer();
			System.out.println( printout( target ) );
		}
	}
	
	static int printer() throws IOException
	{
		q = new LinkedList<document>();
		
		String[] data = br.readLine().split(" ");
		int documentN = Integer.parseInt( data[0] );
		int target = Integer.parseInt( data[1] );
		
		String[] importance = br.readLine().split(" ");
		
		for( int i=0; i < importance.length; i++ )
		{
			q.add( new document( i, Integer.parseInt( importance[i] ) ));
		}
		
		return target;		
	}
	
	static int printout(int target)
	{
		int count = 0;
		while( !q.isEmpty() )
		{
			//find top priority
			int priority = findPriority();
			//skip elements
			while( q.peek().importance != priority )
			{
				document tmp = q.poll();
				q.add(tmp);
			}
			//poll
			count++;
			if( q.poll().id == target )
				return count;
		}
		return -1;
	}
	
	static int findPriority()
	{
		if( !q.isEmpty() )
		{
			Iterator<document> itr = q.iterator();
			int max = 0;
			while( itr.hasNext() )
			{
				int importance = itr.next().importance;
				if( importance > max )
					max = importance; 
			}
			return max;
		}
		else
			return -1;
	}
	
	static class document
	{
		public int id;
		public int importance;
		
		public document(int id, int importance)
		{
			this.id = id;
			this.importance = importance;
		}
		
	}
	

}
