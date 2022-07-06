import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.io.*;
import java.util.Queue;

public class siwon1021 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<Integer> q;
	static int count = 0;
	
	static void moveLeft()
	{
		count++;
		if(!q.isEmpty())
		{
			int tmp = q.poll();
			q.addLast(tmp);
		}
	}
	
	static void moveRight()
	{
		count++;
		if(!q.isEmpty())
		{
			int tmp = q.pollLast();
			q.addFirst(tmp);
		}
	}
	
	static boolean goLeft(int target)
	{
		int idx = q.indexOf(target) + 1;
		
		if(	q.size()%2==1 )
		{
			if( idx <= q.size()/2 + 1 )
				return true;
			else
				return false;
		}
		else
		{
			if( idx <= q.size()/2 )
				return true;
			else
				return false;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		String[] data = br.readLine().split(" ");
		int size = Integer.parseInt( data[0] );
		int times = Integer.parseInt( data[1] );
		int[] targets = new int[times];
		q = new LinkedList<Integer>();
		for( int p=1; p<=size; p++ )
		{
			q.add(p);
		}
		String[] targetinfo = br.readLine().split(" ");
		for( int i=0; i<times; i++	)
		{
			targets[i] = Integer.parseInt( targetinfo[i] );
		}
		for( int i=0; i<times; i++	)
		{
			if( q.peek()!=targets[i] )
			{
				if( goLeft( targets[i] ) )
				{
					while( q.peek()!= targets[i])
						moveLeft();
				}
				else
				{
					while( q.peek()!= targets[i])
						moveRight();
				}
			}
			//System.out.println(count);
			q.poll();
		}
		System.out.print(count);	
	}

}
