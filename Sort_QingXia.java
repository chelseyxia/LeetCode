import java.util.Random;
import java.util.Arrays;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.sql.*;
import java.util.Calendar;
import java.lang.*;
public class Sort_QingXia{
}
class Sortt{
   private int n;
   private int[] a;
   public Sortt(int n){
      this.n = n;
      a = new int[n];
   }
   
   //heapsort
   /*public void buildheap(int[] a){
      n = a.length;
      for(int i = n/2 - 1; i >= 0; i--){
         maxHeapify(a, n, i);
      }
   }*/
   
   public void heapsort(int[] a){
      //buildheap(a);
      n = a.length;
      for(int i = n/2 - 1; i >= 0; i--){
         maxHeapify(a, n, i);
      }

      for(int i = n-1; i > 0; i--){
         swap(a, 0, i);
         n--;
         maxHeapify(a, i, 0);
      }
   }
   
   private void maxHeapify(int[] a, int n, int i){
      int largest = i;
      int l = 2 * i + 1;
      int r = 2 * i + 2;
      int child = l;
      if(r < n && a[l] < a[r]){
         child++;
      }
      if(child < n && a[child] > a[largest]){
         largest = child;
      }
      /*else{
         largest = i;
      }
      if(r < n && a[r] > a[largest]){
         largest = r;
      }*/

      if(largest != i){
         swap(a, i, largest);
         maxHeapify(a, n, largest);
      }
   }
   public void swap(int[] a, int front, int pos){
      int temp = a[front];
      a[front] = a[pos];
      a[pos] = temp;
   } 
   
   //mergesort
   public void mergesort(int[] a, int[] temp, int left, int right){
      if(left < right){
         int center = (left + right) / 2;
         mergesort(a, temp, left, center);
         mergesort(a, temp, center + 1, right);
         merge(a, temp, left, center + 1, right);
      }
   }
   public void merge(int[] a, int[] temp, int leftpos, int rightpos, int rightend){
      int leftend = rightpos - 1;
      int curr = leftpos;
      int n = rightend - leftpos + 1;   
      while(leftpos <= leftend && rightpos <= rightend){
         if(a[leftpos] <= a[rightpos])
            temp[curr++] = a[leftpos++];
         else
            temp[curr++] = a[rightpos++];
      }
      while(leftpos <= leftend){
         temp[curr++] = a[leftpos++];
      }
      while(rightpos <= rightend){
         temp[curr++] = a[rightpos++];
      }
      for(int i = 0; i < n; i++, rightend--){
         a[rightend] = temp[rightend];
      }
   } 

   //quicksort
   public void quicksort(int[] a, int start, int end){
      if(start >= end)
         return;
      int mid = (start + end) / 2;     
      int pivot = median(a, start, mid, end);
      swap(a, pivot, end);
      /*int tmp = a[end];
      a[end] = a[pivot];
      a[pivot] = tmp;*/
      int k = partition(a, start, end-1, a[end]);//end to pivot
      swap(a, k, end);
      quicksort(a, start, k-1); 
      quicksort(a, k+1, end);
   }
   public int median(int[] a, int i,int j, int k){
      int temp = 0;
      if(a[j] < a[i] && a[i] < a[k])
         temp = i;
      if(a[k] < a[i] && a[i] < a[j])
         temp = i;
      if(a[k] < a[j] && a[j] < a[i])
         temp = j;
      if(a[i] < a[j] && a[j] < a[k])
         temp = j;
      if(a[j] < a[k] && a[k] < a[i])
         temp = k;
      if(a[i] < a[k] && a[k] < a[j])
         temp = k;
      return temp;
   }  
   public int partition(int[] a, int left, int right, int p) {
      while (left <= right) { 
         while (a[left] < p){
            left++;
         }
         while ((right >= left) && (a[right] >= p)){
            right--;
         }
         if (right > left){
            swap(a, left, right);
         } 
      }
      return left;            
   }
}

class Driver{
   public static void main(String[] args){
      Sortt heapSort = new Sortt(49);
      Sortt mergeSort = new Sortt(49);
      Sortt quickSort = new Sortt(49);
      //test 3 sort method whether work 
      int[] E = {3,6,1,87,13,50,100,53,48,59,34,47,90,35,4};
      


      //System.out.println(quickSort.median(E,0,5,10));
      int[] temp = new int[E.length];
      heapSort.heapsort(E);
      System.out.println(Arrays.toString(E));
      mergeSort.mergesort(E, temp, 0, E.length - 1);
      System.out.println(Arrays.toString(E));
      quickSort.quicksort(E, 0, E.length - 1);
      System.out.println(Arrays.toString(E));
   }
}