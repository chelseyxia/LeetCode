import java.util.Random;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.sql.*;
import java.util.Calendar;
public class BinaryHeap_QingXia{
}
class BinaryMinHeap{
   private int[] heap;
   private int size;
   private int N;
   //constructor  
   public BinaryMinHeap(int maxsize){
      this.N = 0;
      this.size = maxsize;
      heap = new int[maxsize];
   }  
   public int length(){
      return N;
   }  
   public int parent(int i){
      if(i <= 0)
         return -1;
      return (i-1)/2;
   }
   public int left_child(int i){
      if(i >= N/2)
         return -1;
      return i * 2 + 1;
   }
   public int right_child(int i){
      if(i >= (N-1)/2)
         return -1;
      return 2 * i + 2;
   }  
   public int min(){
      return heap[0];
   }
   public boolean isLeaf(int i){
      return (i < N) && (i >= N/2);
   }
   public void insert(int key){
      if(N == size){
         System.out.println("Binary min heap is full.");
         return;
      }
      int current = N++;
      heap[current] = key;
      while(current != 0 && heap[current] < heap[parent(current)]){
         swap(current, parent(current));
         current = parent(current);
      }
   }
   public void printHeap(){
      for (int i = 0; i < N; i++){
         System.out.print(heap[i] + " " );  
      }
      System.out.println();
   }
   private void swap(int front, int pos){
      int temp = heap[front];
      heap[front] = heap[pos];
      heap[pos] = temp;
   }  
   public void siftDown(int pos){
      if((pos < 0) || (pos >= N)){
         return;
      }
      while(!isLeaf(pos)){
         int j = left_child(pos);
         if((j < (N-1)) && heap[j] > heap[j+1]){
            j++;
         }
         if(heap[pos] <= heap[j]){
            return;
         }
         swap(pos,j);
         pos = j;
      }
   }   
   public void deletemin(){  
      if(N == 0)
         return;
      else{
         swap(0, N-1);
         N--;
         siftDown(0);
      }
   }
}

class Driver{
   public static void main(String[] args){
      BinaryMinHeap Heap_1 = new BinaryMinHeap(5000);
      Random rand = new Random(); 
      int[] A = new int[5000];
      for(int i = 0; i < A.length; i++){//array from 0 - 4999
         A[i] = i;
      }
      for(int j = 0; j < A.length; j++){// shuffle the array 
         int Rand = rand.nextInt(A.length);
         int temp = A[Rand];
         A[Rand] = A[j];
         A[j] = temp; 
      }
      for(int j = 0; j < A.length; j++){
         Heap_1.insert(A[j]);
      } 
         
      BinaryMinHeap Heap_2 = new BinaryMinHeap(5000); 

      long start = System.currentTimeMillis();
      Timestamp stamp1 = new Timestamp(start);
 
      while(true){
         if(Heap_1.length() != 0){
            int min = Heap_1.min();         
            Heap_1.deletemin();
            System.out.printf("The process with a priority of %d is now scheduled to run!", min);
            System.out.println();
            
            Heap_2.insert(A[min]);
            System.out.printf("The process with a priority of %d has run out of its timeslice!", min);
            System.out.println();       
         }
         else{            
            long end = System.currentTimeMillis();
            Timestamp stamp2 = new Timestamp(end);
            long diff = stamp2.getTime() - stamp1.getTime();
            System.out.println("It took " + diff + " msecs for all processes to run out their timeslice. \nPlease press \"Enter\"to start the next round!");
            start = System.currentTimeMillis();//renew time 
            stamp1 = new Timestamp(start);  
            
            Scanner kb = new Scanner(System.in);
            kb.nextLine(); 
            BinaryMinHeap temp = new BinaryMinHeap(5000);

            temp = Heap_1;
            Heap_1 = Heap_2;
            Heap_2 = temp;   
            System.out.println();  
         } 
      }
   }
} 