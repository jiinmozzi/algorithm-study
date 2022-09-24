import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon1780 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] numbers;


    public static int[] cutPaper(int x1, int y1, int x2, int y2)   //result[0]은 -1의 갯수 ...
    {
        int[] result = new int[3];
        int length = x2-x1+1;
        boolean isAllSame = true;

        int standard = numbers[x1][y1];

        if(x1==x2 && y1==y2)
        {
            result[standard+1]=1;
//            System.out.println("가장 작은 단위입니다.");
//            System.out.println(x1+" "+y1+" "+x2+" "+y2 );
            return result;
        }

        for(int i=x1; i<x1+length; i++)
        {
                for(int j=y1; j<y1+length; j++)
                {
                    if(numbers[i][j]!=standard)
                    {
                        isAllSame = false;
                    }
                }
        }

        if(isAllSame)
        {
            result[standard+1]=1;
            return result;
        }
        else
        {
            int unit = length/3;

            int[] d1 = cutPaper(x1,y1,x1+unit-1,y1+unit-1);
            int[] d2 = cutPaper(x1+unit,y1,x1+(unit*2)-1,y1+unit-1);
            int[] d3 = cutPaper(x1+(unit*2),y1,x1+(unit*3)-1,y1+unit-1);

            int[] d4 = cutPaper(x1,y1+unit,x1+unit-1,y1+(unit*2)-1);
            int[] d5 = cutPaper(x1+unit,y1+unit,x1+(unit*2)-1,y1+(unit*2)-1);
            int[] d6 = cutPaper(x1+(unit*2),y1+unit,x1+(unit*3)-1,y1+(unit*2)-1);

            int[] d7 = cutPaper(x1,y1+(unit*2),x1+unit-1,y1+(unit*3)-1);
            int[] d8 = cutPaper(x1+unit,y1+(unit*2),x1+(unit*2)-1,y1+(unit*3)-1);
            int[] d9 = cutPaper(x1+(unit*2),y1+(unit*2),x1+(unit*3)-1,y1+(unit*3)-1);

            result[0] = d1[0] + d2[0] + d3[0] +d4[0] +d5[0] +d6[0] +d7[0] +d8[0] +d9[0];
            result[1] = d1[1] + d2[1] + d3[1] +d4[1] +d5[1] +d6[1] +d7[1] +d8[1] +d9[1];
            result[2] = d1[2] + d2[2] + d3[2] +d4[2] +d5[2] +d6[2] +d7[2] +d8[2] +d9[2];

            return result;

        }


    }

    public static void main(String[] args) throws IOException
    {
        int n = Integer.parseInt( br.readLine() );
        numbers = new int [n][n];

        for(int i=0; i<n; i++)
        {
            String[] data = br.readLine().split(" ");
            for(int j=0; j<n; j++)
            {
                numbers[i][j] = Integer.parseInt(data[j]);
            }
        }

        int[] result = cutPaper(0,0,n-1,n-1);

        System.out.println( result[0] );
        System.out.println( result[1] );
        System.out.println( result[2] );

    }
}
