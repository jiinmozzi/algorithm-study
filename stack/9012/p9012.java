import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
public class p9012 {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		int standard = 0;
		for( int i=0; i<n; i++ )
		{
			standard=0;
			String data = br.readLine();
			for( int j=0; j<data.length(); j++ )
			{
				if( data.charAt(j) == '(' )
				{
					standard++;
				}
				else
				{
					standard--;
					if(standard<0) 
					{
						//System.out.println("you came here");
						System.out.println("NO");
						break;
					}
				}
			}
			
			if(standard < 0)
				continue;
			else if(standard == 0)
				System.out.println("YES");
			else
			{
				//System.out.print(standard);
				//System.out.println("you came here");
				System.out.println("NO");
			}
		}
		
	}

}
