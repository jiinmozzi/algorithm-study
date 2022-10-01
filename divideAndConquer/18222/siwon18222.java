import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon18222 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String makeX(String x)
    {
        StringBuilder originalX = new StringBuilder(x);
        StringBuilder xPrime = new StringBuilder("");

        for(int i=0; i<x.length(); i++)
        {
            if( x.charAt(i)=='0' )
            {
                xPrime.append('1');
            }
            else if(    x.charAt(i)=='1' )
            {
                xPrime.append('0');
            }
        }
        return originalX.append(xPrime).toString();
    }

    public static void main(String[] args) throws IOException
    {
        String result = "0";
        int n = Integer.parseInt( (br.readLine().split(" "))[0] );

        while(result.length() <= n)
        {
            result = makeX(result);
        }

        System.out.println(result.charAt(n));
    }


}
