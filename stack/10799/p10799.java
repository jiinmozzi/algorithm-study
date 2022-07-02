import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Stack;

public class p10799 {

	static String data;
	static Stack<Integer> sticks = new Stack();	
	static int result=0;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = br.readLine();
		for(int i=0; i<data.length(); i++)
		{
			command(i);			
		}
		System.out.print(result);
	}
	
	public static void laser()
	{
		result+=sticks.size();
		/*
		//stack의 모든 원소 +1
		if(sticks.size()==0)
			return;
		
		Object[] tmp = sticks.toArray();
		int[] tmpp =  new int[tmp.length];
		
		for(int i=0; i<tmp.length; i++)
		{
			tmpp[i]=(int)(tmp[i]);
		}
		
		sticks = new Stack();
		
		for(int i=0; i<tmp.length; i++)
		{
			sticks.push(tmpp[i]+1);
		}
		*/
		
		/*
		if(sticks.size()==0)
			return;
		else if(sticks.size()==1)
		{
			int t = sticks.pop()+1;
			sticks.push(t);
		}
		else
		{
			Stack<Integer> tmp = new Stack();
			
			for(int i=0; i<sticks.size()-1; i++)
			{
				tmp.push( sticks.pop()+1 );
			}
			sticks.set( 0, sticks.get(0)+1);
			for(int i=0; i<tmp.size()-1; i++)
			{
				sticks.push( tmp.pop() );
			}
			sticks.push( tmp.peek()+1 );
		}
		*/
	}
	
	public static void addStick()
	{
		sticks.push(1);
	}
	
	public static void removeStick()
	{
		result+=sticks.pop();
	}

	
	public static void command(int i)
	{
		switch(	data.charAt(i) )
		{
		case '(':
			if(data.charAt(i+1)==')')
				laser();
			else
				addStick();
			break;
		case ')':
			if(data.charAt(i-1)!='(')	//레이저가 아님
				removeStick();
			break;
		}
		
	}
}
