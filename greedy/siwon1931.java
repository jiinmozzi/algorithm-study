import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon1931 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static class meeting implements Comparable<meeting>
	{
		public int start;
		public int end;
		
		public meeting(int x, int y)
		{
			start = x;
			end =y;
		}
		
		public int compareTo( meeting m )
		{
			return this.end - m.end;
		}
		
		public String toString()
		{
			return Integer.toString(start)+" "+Integer.toString(end);
		}
	}
	
	static class MyComparator implements Comparator<meeting> {
		  @Override
		  public int compare(meeting p1, meeting p2) {
			  return p1.compareTo(p2);
		  }	
	}
	
	static class MyComparator1 implements Comparator<meeting> {
		  @Override
		  public int compare(meeting p1, meeting p2) {
			  return p1.start - p2.start;
		  }	
	}
	
	public static void main(String[] args) throws IOException
	{
		int n = Integer.parseInt( br.readLine() );
		String[] data;
		int start, end;
		ArrayList<meeting> meetings = new ArrayList();
		
		for( int i=0; i<n; i++ )
		{
			data = br.readLine().split(" ");
			start = Integer.parseInt( data[0] );
			end = Integer.parseInt( data[1] );
			meetings.add( new meeting(start,end) );
		}
		
		MyComparator1 c1 = new MyComparator1();
		MyComparator c = new MyComparator();
		
		meetings.sort(c1);
		meetings.sort(c);
		
		int idx = 0;
		int prevEnd = meetings.get(idx).start ;
		int result = 0;
		
		while( idx < meetings.size() )
		{
			if(	meetings.get(idx).start>=prevEnd	)
			{
				result++;
				prevEnd = meetings.get(idx).end;
				idx++;
				continue;
			}
			else
			{
				idx++;
				continue;
			}	
		}
		
		System.out.println(result);
		
		
	}

}
