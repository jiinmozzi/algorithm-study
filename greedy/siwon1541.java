import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon1541 {

	static BufferedReader br;
	static ArrayList<Integer> nums = new ArrayList();
	static ArrayList<Character> ops = new ArrayList();	
	static int[] num;
	static char[] op;

	static int minIdx;
	static int nextMinIdx;
	static int tmp=0;
	
	public static void main(String[] args) throws IOException
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		String rawData = br.readLine();
		
		for(int i=0; i<rawData.length(); i++)
		{
			char c = rawData.charAt(i);
			if( c=='+' || c=='-' )
				ops.add(c);
		}
		
		String[] data = rawData.split("\\+|-");
		
		for(int i=0; i<data.length ; i++)
		{
			nums.add( Integer.parseInt( data[i] )  );
		}
		
		op = new char[ops.size()];
		for(int i=0; i<ops.size() ; i++)
		{
			op[i] = ops.get(i);
		}
		
		num = new int[nums.size()];
		for(int i=0; i<nums.size() ; i++)
		{
			num[i] = nums.get(i);
		}
		
		
		
		while( findMin() )
		{
			merge();
		}
		
		int result=0;
		
		for( int i=0; i<num.length; i++ )
		{
			result+=num[i];
		}
		result+=tmp;
		
		System.out.print( result );
		
	}
	
	static boolean findMin()
	{
		boolean found = false;
		for(int i=0; i<op.length; i++)
		{
			if( op[i]=='-' )
			{
				found = true;
				minIdx=i;
				op[i]='+';
				
				if( i==op.length-1 )
				{
					nextMinIdx=i;
					break;
				}
				
				for(int j=i+1; j<op.length; j++)
				{
					if(	op[j]=='-' )
					{
						nextMinIdx=j-1;
						//op[j]='+';
						break;
					}
					else if( j==op.length-1 )
					{
						nextMinIdx=op.length-1;
						//op[j]='+';
					}
				}
							
				break;
			}
		}
		return found;
	}
	
	static void merge()
	{
		
		for( int i=minIdx+1; i<=nextMinIdx+1; i++ )
		{
			tmp -= num[i];
			num[i]=0;
		}
		
		//System.out.println("tmp is"+tmp);
	}

}
