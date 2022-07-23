import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;


public class siwon16953 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int a;
	static int b;
	static int count = 0;
	static boolean end = false;
	
	public static void main(String[] args) throws IOException
	{
		String[] data = br.readLine().split(" ");
		b=Integer.parseInt(data[1]);
		a=Integer.parseInt(data[0]);

		while(	b>a	)
		{
			b=conduct(b);
			if(b==-1)
			{
				System.out.println(-1);
				break;
			}
		}
		
		if(  b == a )
			System.out.println( count+1 );
		else if(  b < a && b != -1 )
			System.out.println( -1 );
		
		
	}
	
	public static int conduct( int x )
	{
		count++;
		
		if(x==a)
		{
			return x;
		}
		else if( x%10 == 1 )
		{
			return (x-1)/10;
		}
		else if( x%2 == 0 )
		{
			return x/2;
		}
		else
		{
			return -1;
		}

	}

}
