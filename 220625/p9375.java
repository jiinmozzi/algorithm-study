import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;

public class p9375 {
	
	static LinkedList<cartegory> cartegories;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int times =  Integer.parseInt( br.readLine() );
		for(int i=0; i<times; i++)
		{
			int costumeN =  Integer.parseInt( br.readLine() );
			String item;
			String cart;
			cartegories = new LinkedList();
			for(int j=0; j<costumeN; j++)
			{
				String[] data = br.readLine().split(" ");
				item = data[0];
				cart = data[1];
				// 코스튬 삽입 ( br.readLine() )
				inputCostume(item , cart);
			}
			
			/*
			Iterator<cartegory> itrr = cartegories.iterator();
			
			while(itrr.hasNext())
			{	
				System.out.println(itrr.next());
			}*/
			
			// 가짓수 출력
			System.out.println( calculate() );
		}
	}
	
	static cartegory c;
	
	public static void inputCostume(String item, String cart)
	{
		//카테고리 있는지 확인
		Iterator<cartegory> itr = cartegories.iterator();
		boolean cartegorieExists=false;
		while(itr.hasNext())
		{	
			c = itr.next();
			if( cart.compareTo(c.name)==0 )
			{
				//있으면 카테고리에 추가
				cartegorieExists=true;
				c.addItem();	
			}
		}
		if(!cartegorieExists)
		{
			//없으면 새로운 카테고리 만들기
			cartegory nc = new cartegory(cart);
			cartegories.add(nc);
		}	
	}
	
	public static int calculate()
	{
		if(cartegories.isEmpty())
		{
			return 0;
		}
		else if(cartegories.size()==1)
		{
			return cartegories.getFirst().num;
		}
		else
		{
			int result=1;
			Iterator<cartegory> itr = cartegories.iterator();
			while(itr.hasNext())
			{
				result *= ( (itr.next().num) + 1 );
			}
			return result-1;
		}
	}
	
	static class cartegory
	{
		public String name;
		public int num; 
		
		cartegory(String name)
		{
			this.name = name;
			this.num = 1;
		}
		
		public void addItem()
		{
			this.num++;
		}
		
		public String toString()
		{
			return name +" "+ num;
		}
	
	}
	
	

}
