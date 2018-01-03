package struktur_data;
/*Stack.java


Below is the syntax highlighted version of Stack.java from §4.3 Stacks and Queues.

*/
/******************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *  Data files:   https://introcs.cs.princeton.edu/43stack/tobe.txt
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type Item.
 *  
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.io.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *  The {@code Stack} class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, getting the number of
 *  items in the stack, and iterating over the items in LIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a nested class for
 *  linked-list nodes.
 *  The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://introcs.cs.princeton.edu/43stack">Section 4.3</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne. 
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <Item> the generic type of an item in this stack
 */
 
 
 
 class KarungBeras25KG {
	int no ;
	String merek;
	static DateFormat df = new SimpleDateFormat(" HH:mm:ss");
	Date mydate=null;
	KarungBeras25KG(int no,String merek){
		this.no=no;
		this.merek=merek;
		mydate=new Date();
	}
	 
	public  String toString(){
		return (this.no+"\t"+this.merek+"\t\t\t"+df.format(mydate));
	}
 }

 
public class Stack<Item> implements Iterable<Item> {
    private int n;          // size of the stack
    private Node first;     // top of stack

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

   /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
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
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<Item> iterator()  { return new ListIterator();  }

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
     * Unit tests the {@code Stack} data type.
     */
    /*public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
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
		if(label==null)label="Masukkan String/Kalimat";
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
	
	static int TOTAL_KARUNG=0;
	static final int EXIT=9,C_PRINT_Q=1,C_ADD_Q=2,C_DEQUEUE=3;
	
	static final void print_main_menu(int last_menu, Stack st){
		String str_menu= "\n\n PILIH MENU \n"+
					 "1. LIHAT STACK/TUMPUKAN\n"+
					 "2. TUMPUK KARUNG (PUSH)\n";
				if(st.size()>0)str_menu+=
					 "3.  ANGKAT KARUNG (POP) \n" ;
				str_menu+=	 "9.  EXIT PROGRAM \n" ;
					 
		System.out.println(str_menu);
	 }
	
	static void print_header(){
		System.out.println("No \tMerek\t\t\t\tJam Tumpuk");
		System.out.println("=====================================================");
		
	}

	static void print_push_menu(Stack st) throws IOException{
		String merek=input_keyboard_string("Ketikkan Merek Beras");
		TOTAL_KARUNG++;
		KarungBeras25KG krng=new KarungBeras25KG(TOTAL_KARUNG,merek);
		st.push(krng);
		print_header();
		System.out.println(krng+ "  <== DiTumpuk/Stacked/Pushed" );
	 }
	 
	 static void print_pop_menu(Stack st) throws IOException{
		KarungBeras25KG krng=(KarungBeras25KG)st.peek();
		st.pop();
		print_header();
		System.out.println(krng+ "  <== Diangkat (Popped)" );
	 }
	 
	 static void print_stack(Stack st){
		 
		System.out.println("\nTumpukan  Beras 25Kg: "+st.size() +" Karung");
		Iterator<KarungBeras25KG> it=st.iterator();
		print_header();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		  
	 }
	
	public static void main(String[] args) throws IOException {
		Stack<KarungBeras25KG> st = new Stack<KarungBeras25KG>();
		
		int choice=0;
		while (choice!=EXIT){
			
			switch (choice){
				case C_PRINT_Q:
					print_stack(st);
					break ;
				case C_ADD_Q :
					print_push_menu(st);
					break;
				case C_DEQUEUE :
					if(st.size()<1)break;
					print_pop_menu(st);
					break;
				default : break ;
			}
			print_main_menu(choice,st);
			choice=input_keyboard_integer("Pilih menu:");
			
		}
        
    }
}

/*
Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
Last updated: Fri Oct 20 14:12:12 EDT 2017.
Modified by : dzulqarnaenhatala@gmail.com
*/