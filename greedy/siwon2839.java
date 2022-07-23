import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon2839 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException
	{
		
		int sugar = Integer.parseInt( br.readLine() );
		int result=-1;

		for(int i=0; i<= sugar/5; i++)
		{
			if(	 ( sugar-(5*i) )%3==0		)
				result = ( sugar-(5*i) )/3 + i;
		}
		
		System.out.println(result);
	}

}
