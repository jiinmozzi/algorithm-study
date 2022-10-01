import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.ArrayList;

public class siwon11286
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int abs(int a)
    {
        if(a>=0)
        {
            return a;
        }
        else
            return -a;
    }

    public static void percolateUp(int i)
    {
        if(i>0) {
            //부모가 본인보다 작을 때 -> 가만히 있는다
            //부모가 본인 보다 클 때 -> 부모와 자리 교체
            // 부모의 자리 : (i-1)/2
            if( abs(arr[(i-1)/2]) > abs(arr[i] )) {
                int tmp = arr[i];
                arr[i] = arr[(i - 1) / 2];
                arr[(i - 1) / 2] = tmp;
                percolateUp((i - 1) / 2);
            }
            else if(abs(arr[(i-1)/2]) == abs(arr[i] ))
            {
                if(arr[(i-1)/2] > arr[i])
                {
                    int tmp = arr[i];
                    arr[i] = arr[(i - 1) / 2];
                    arr[(i - 1) / 2] = tmp;
                    percolateUp((i - 1) / 2);
                }
            }
        }
    }

    public static void percolateDown(int i)
    {
        if(i>=0) {
            //자식 정하기
            int child;

            if( (i*2)+1 < lastIdx+1 )  // 자식 있을 때
            {
                if( ((i*2)+2) < lastIdx+1  )   //오른 자식 있을 때
                {
                    if(  abs(arr[(2*i)+1]) > abs(arr[(2*i)+2]) )// 오른 자식이 작을 때
                    {
                        child = (2*i)+2;
                    }
                    else if(abs(arr[(2*i)+1]) == abs(arr[(2*i)+2]))
                    {
                        if( arr[(2*i)+1] < arr[(2*i)+2])
                            child = (2*i)+1;
                        else
                            child = (2*i)+2;
                    }
                    else    // 왼 자식이 작을 때
                    {
                        child = (2*i)+1;
                    }
                }
                else //오른 자식 없을 때
                {
                    child = (2*i)+1;
                }
            }
            else // 자식 없을 때
            {
                return;
            }

            //자식이 본인보다 클 때 -> 가만히 있는다

            //자식이 본인보다 작을 때 -> 부모와 자리 교체
            if( abs(arr[child]) < abs(arr[i] )) {
                int tmp = arr[i];
                arr[i] = arr[child];
                arr[child] = tmp;
                percolateDown(child);
            }
            else if( abs(arr[child]) == abs(arr[i] )) {
                if(arr[i] > arr[child]) {
                    int tmp = arr[i];
                    arr[i] = arr[child];
                    arr[child] = tmp;
                    percolateDown(child);
                }
            }
        }
    }

    public static void buildHeap()
    {
        //마지막 부모부터 percolateDown
        //마지막 부모의 index : last - 1 / 2
        int last = lastIdx;
        int motherOfLast = (last-1)/2;

        for( int i = motherOfLast; i>=0; i-- )
        {
            percolateDown(i);
        }
    }

    public static int pop()
    {
        if(lastIdx==-1)
            return 0;
        else {
            int tmp = arr[0];
            arr[0] = arr[lastIdx];
            arr[lastIdx] = 0;
            lastIdx--;
            percolateDown(0);
            return tmp;
        }
    }

    public static void putHeapElement(int a)
    {
        arr[++lastIdx] = a;
    }

    public static void heapAction(int a)
    {
        if(a==0)
        {
            // 가장 작은 값 출력
            // 비어있는 경우엔 0 출력
            System.out.println(pop());
        }
        else
        {
            putHeapElement(a);
            percolateUp(lastIdx);
        }
    }

    //배열 전역변수로 선언
    public static int[] arr;
    public static int lastIdx=-1;

    public static void main(String[] args) throws IOException
    {
        int l = Integer.parseInt(br.readLine());
        arr = new int[l];

        int newdata;

        for(int i=0; i<l; i++)
        {
            newdata = Integer.parseInt( br.readLine() );
            heapAction(newdata);
        }
    }
}
