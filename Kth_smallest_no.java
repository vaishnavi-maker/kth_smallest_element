
package kth_smallest_no;
import java.util.Random;
import java.util.Scanner;
 
public class Kth_smallest_no 
{
    public static int N = 20;
    public static int[] A = new int[N];
 
    public static void sort(int ele1, int ele2) 
    {
        int temp = A[ele1];
        A[ele1] = A[ele2];
        A[ele2] = temp;
    }
 
    public static int partition(int start, int end) 
    {
        int i = start + 1;
        int j = i;
        int pivot = start;
        for (; i < end; i++) 
        {
            if (A[i] < A[pivot]) 
            {
                sort(i, j);
                j++;
            }
        }
        if (j <= end)
            sort(pivot, (j - 1));
 
        return j - 1;
    }
 
    public static void find(int start, int end, int K) {
        int len;
        if (start < end) 
        {
            len = partition(start, end);
            if (len == K - 1)
                System.out.println("kth smallest element : " + A[len]);
            if (len > K - 1)
                find(start, len, K);
            else
                find(len + 1, end, K);
        }
        return;
    }
 
    public static void main(String args[]) 
    {
        Random random = new Random();
        int l[]=new int[20];
        for (int i = 0; i < N; i++)
            A[i] = random.nextInt(1000); 
        System.out.println("......................................................................................");
        System.out.println("The original sequence is:  ");
        for (int i = 0; i < N; i++)
            System.out.print(A[i] + " ");
        Scanner sc = new Scanner(System.in);
        System.out.println("\n......................................................................................");
        System.out.println("Enter the Kth smallest you want to find: ");
        int k = sc.nextInt();
        find(0, N, k);
        sc.close();
        System.out.println("......................................................................................");
    }
}