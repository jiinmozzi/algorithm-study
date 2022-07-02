import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class p2841 {
	
	static LinkedList<Integer> l1 = new LinkedList();
	static LinkedList<Integer> l2 = new LinkedList();
	static LinkedList<Integer> l3 = new LinkedList();
	static LinkedList<Integer> l4 = new LinkedList();
	static LinkedList<Integer> l5 = new LinkedList();
	static LinkedList<Integer> l6 = new LinkedList();
	
	static int count=0;
	

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		
		int melN =  Integer.parseInt( data[0] );
		int pN =  Integer.parseInt( data[1] );

		for(int i=0; i<melN; i++)
		{	
			String[] mel = br.readLine().split(" ");
			int line = Integer.parseInt( mel[0] );
			int pret = Integer.parseInt( mel[1] );
			move(line, pret);
		}
		
		System.out.print(count);
	}
	
	public static void move(int line, int pret)
	{
		switch(line)
		{
		case 1:
			//System.out.println( insertOrderly( l1, pret ) );
			count+=insertOrderly( l1, pret );
			break;
		case 2:
			//System.out.println( insertOrderly( l2, pret ) );			
			count+=insertOrderly( l2, pret );
			break;
		case 3:
			//System.out.println( insertOrderly( l3, pret ) );			
			count+=insertOrderly( l3, pret );
			break;
		case 4:
			//System.out.println( insertOrderly( l4, pret ) );			
			count+=insertOrderly( l4, pret );
			break;
		case 5:
			//System.out.println( insertOrderly( l5, pret ) );			
			count+=insertOrderly( l5, pret );
			break;
		case 6:
			//System.out.println( insertOrderly( l6, pret ) );			
			count+=insertOrderly( l6, pret );
			break;
		
		}
		
	}
	
	public static int insertOrderly(LinkedList<Integer> l1, int pret)
	{
		Iterator<Integer> itr = l1.iterator();
		int idx=0;
		
		if( !l1.isEmpty() )
		{
			while(itr.hasNext())
			{
				int p = itr.next();
				
				if( p < pret )
				{
					idx++;
					continue;
				}
				else if( p == pret )
				{
					int result = l1.size()-idx-1;	// pret보다 높은 음의 갯수
					for( int i=0; i<result; i++ )
					{
						l1.removeLast();
					}
					//System.out.println("you came here");
					//System.out.println(l1);
					return result;
				}
				else
				{
					int result = l1.size()-idx;	// pret보다 높은 음의 갯수
					for( int i=0; i<result; i++ )
					{
						l1.removeLast();
					}
					l1.addLast(pret);
					//System.out.println(l1);
					return result+1;
				}
			}
			//pret이 제일 큰 경우 
			l1.addLast(pret);
			//System.out.println(l1);
			return 1;
		}
		else
		{
			l1.add(pret);
			return 1;
		}
		
	}
	
	

}
