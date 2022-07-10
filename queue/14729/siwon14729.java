import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.io.*;
import java.util.Queue;
import java.util.Iterator;

public class siwon14729 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<Double> seven = new LinkedList();	
	static double maxOfSeven;
	
	public static class MyComparator implements Comparator<Double> 
	{
		  @Override
		  public int compare(Double p1, Double p2) 
		  {
			  if( p1-p2 > 0 )
				  return 1;
			  else if( p1-p2 == 0 )
				  return 0;
			  else
				  return -1;
		  }
	}
	
	static void sevencheck( double score )
	{
		if( seven.isEmpty() )
		{
			seven.add( score );
			maxOfSeven = score;
		}
		else if( seven.size()<7	)
		{
			seven.add(score);
			if( score > maxOfSeven )
				maxOfSeven = score;
		}
		else if( score < maxOfSeven	)	//seven 꽉 차있음
		{
			//제일 큰 놈 제거
			seven.remove( maxOfSeven );			
			//score 삽입
			seven.add(score);
			//제일 큰 놈 다시 뽑기
			maxOfSeven = seven.getFirst();
			Iterator<Double> itr = seven.iterator();
			while(itr.hasNext())
			{
				double s = itr.next();
				if(	s > maxOfSeven	)
					maxOfSeven = s;
			}		
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		int students = Integer.parseInt( br.readLine() );
		
		for( int i=0; i<students; i++ )
		{
			double score = Double.parseDouble( br.readLine() );
			sevencheck(score);
		}		
		
		MyComparator c = new MyComparator();
		seven.sort(c);
		
		Iterator<Double> itr = seven.iterator();
		while( itr.hasNext() )
		{
			System.out.printf( "%.3f%n" , itr.next());
		}

	}

}
