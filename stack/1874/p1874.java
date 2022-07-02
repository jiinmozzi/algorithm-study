import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


public class p1874 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num =  Integer.parseInt( br.readLine() );
		int[] goal = new int[num];
		
		for(int i=0; i<num; i++)
		{
			goal[i] = Integer.parseInt( br.readLine() );
		}
		
		Queue<Integer> wait = new LinkedList();
		int count = 0;
		
		for(int i=1; i<=num; i++)
		{
			wait.add(i); 
		}
		
		Stack<Integer> s = new Stack();
		int[] result = new int[num];
		StringBuffer process = new StringBuffer();

		for(int i=0; i<num; i++)
		{
			int target = goal[i];
			
			if( !s.isEmpty() && s.peek()==target )	//스택 직전
			{
				result[i] = s.pop();
				process.append("-");
				process.append("\n");
			}
			else if( count < target )	//wait에 남아있는지
			{
				while( !wait.isEmpty() && wait.peek()!=target  )
				{
					s.push( wait.poll() );
					count++;
					process.append("+");
					process.append("\n");
				}
				
				s.push( wait.poll() );
				count++;
				process.append("+");
				process.append("\n");
				
				result[i] = s.pop();
				process.append("-");
				process.append("\n");
				
			}
			else	//불가
			{
				System.out.print("NO");
				return;
			}		
		}
		
		System.out.print( process.toString() );
		
	}

}
