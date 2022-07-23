import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class p2164 {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++)
		{
			q.add(i);
		}
		
		while(q.size()!=1)
		{
			q.poll();
			if( q.size() != 1 )
			{
				int tmp = q.poll();
				q.add(tmp);
			}
		}
		
		System.out.println( q.peek() );
	
	}

}
