package struktur_data ;
/******************************************************************************
 *  https://introcs.cs.princeton.edu/java/43stack/Queue.java.html
 *  Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
 *  Last updated: Fri Oct 20 14:12:12 EDT 2017. 

 *  Modified by : dzulqarnaenhatala@gmail.com

 *  Compilation:    $pwd
					/home/polnam/st_xxx/java
					$javac -d class_dir struktur_data/Queue.java
 *  Execution:      $pwd
					/home/polnam/st_xxx/java
					$java -cp class_dir Queue 
					
 
 
 *  A generic queue, implemented using a linked list.
 *
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.io.*;
/**
 *  The {@code Queue} class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the top item,
 *  testing if the queue is empty, getting the number of items in the
 *  queue, and iterating over the items in FIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a nested class for
 *  linked-list nodes.
 *  The <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://introcs.cs.princeton.edu/43stack">Section 4.3</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <Item> the generic type of an item in this queue
 */
 
	class AntrianDokter {
		 int no ;
		 String nama;
		 static DateFormat df = new SimpleDateFormat(" HH:mm:ss");
		 Date mydate=null;
		 AntrianDokter(int no,String nama){
			 this.no=no;
			 this.nama=nama;
			 mydate=new Date();
		 }
		 
		 public  String toString(){
			return (this.no+"\t"+this.nama+"\t\t\t"+df.format(mydate));
		}
	 }

 
public class Queue<Item> implements Iterable<Item> {
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;     
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int length() {
        return n;     
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

   /**
     * Add the item to the queue.
     */
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }
	

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 
 

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


    /**
     * Unit tests the {@code Queue} data type.
     */
    /*public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }*/
	
	public static int input_keyboard_integer(String label)  throws IOException{
  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ret = -1; //variable declaration
		
		boolean readCompleted=false; //error indicator
		String line =null;
		if(label==null)label="Enter an integer ";
		while(!readCompleted){
			System.out.print(label +  "(CTRL+C to Exit ): ");
			try{
				line=br.readLine();
				ret=Integer.parseInt(line);
			}catch (NumberFormatException ex){
				
				System.out.println(line + " is not a valid Integer  \n");
				continue;
			}
			readCompleted=true;
		}
		
		return ret;
	}
	
	
	public static String input_keyboard_string(String label)  throws IOException{
  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String ret = ""; //variable declaration
		
		boolean readCompleted=false; //error indicator
		String line =null;
		if(label==null)label="Masukkan nama pasien";
		while(!readCompleted){
			System.out.print(label +  "(CTRL+C to Exit ): ");
				line=br.readLine();
				//ret=Integer.parseInt(line);
				ret=line;
				if(ret==null)continue;
				if(ret.length()==0)continue;
				
			readCompleted=true;
		}
		
		return ret;
	}
	
	static int TOTAL_PATIENT=0;
	static final int EXIT=9,C_PRINT_Q=1,C_ADD_Q=2,C_DEQUEUE=3;
	static final void print_main_menu(int last_menu, Queue q){
		String str_menu= "\n\n PILIH MENU \n"+
					 "1. LIHAT QUEUE/ANTRIAN\n"+
					 "2. TAMBAH ANTRI (ENQUEUE)\n";
				if(q.size()>0)str_menu+=
					 "3.  SELESAI (DEQUEUE) \n" ;
				str_menu+=	 "9.  EXIT PROGRAM \n" ;
					 
		System.out.println(str_menu);
	 }
	 
	static void print_enqueue_menu(Queue q) throws IOException{
		String p_name=input_keyboard_string("Ketikkan Nama Pasien");
		TOTAL_PATIENT++;
		AntrianDokter ad=new AntrianDokter(TOTAL_PATIENT,p_name);
		q.enqueue(ad);
		print_header();
		System.out.println(ad+ "  <== Mendaftar" );
	 }
	
	static void print_dequeue_menu(Queue q) throws IOException{
		AntrianDokter p=(AntrianDokter)q.peek();
		q.dequeue();
		print_header();
		System.out.println(p+ "  <== Selesai diperiksa" );
	 }
		
	 static void print_header(){
		System.out.println("No \tNama\t\t\t\tJam Daftar");
		System.out.println("=====================================================");
		
	 }
	 static void print_queue(Queue q){
		 
		System.out.println("\nANTRIAN_DOKTER: "+q.size() +" orang");
		Iterator<AntrianDokter> it=q.iterator();
		print_header();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		  
	 }
	 
	 public static void main(String[] args) throws IOException{
		
		
		
		Queue<AntrianDokter> queue = new Queue<AntrianDokter>();
		
		int choice=0;
		while (choice!=EXIT){
			
			switch (choice){
				case C_PRINT_Q:
					print_queue(queue);
					break ;
				case C_ADD_Q :
					print_enqueue_menu(queue);
					break;
				case C_DEQUEUE :
					if(queue.size()<1)break;
					print_dequeue_menu(queue);
					break;
				default : break ;
			}
			print_main_menu(choice,queue);
			choice=input_keyboard_integer("Pilih menu:");
			
		}
		
    }

}
/**
* Modified by : dzulqarnaenhatala@gmail.com
*/