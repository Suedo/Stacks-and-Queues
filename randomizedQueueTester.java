import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;


public class randomizedQueueTester {
	
	public static void main(String[] args) throws IOException{
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		
		System.out.print("enter line: ");
		String line = is.readLine();
		String[] parsed = line.split("[ ]+");
		
		System.out.println("\n\nprinting constructed queue: ");
		for(String i : parsed){
			rq.enqueue(i);
		}
		for(String i : rq){
			System.out.print(" " + i);
		}
		System.out.println("\n\n size : " + rq.size());
		
		Iterator<String> it = rq.iterator();
		for(int i = 0; i < 20 ; i++){
			System.out.print(it.next());
		}
		
		System.out.println("enter number of dequeues to perform: ");
		int num = Integer.parseInt(is.readLine());
		
		for(int i =0 ; i < num; i++){
			System.out.println("dequeuing: " + rq.dequeue());
		}
		System.out.println("\n\nprinting queue: ");
		for(String i : rq){
			System.out.print(" " + i);
		}
		
		System.out.println("\n\n enter string to enqueues : ");
		line = is.readLine();
		String[] enq = line.split("[ ]+");
		for(int i =0 ; i < enq.length; i++){
			System.out.println("enqueuing: " + enq[i]);
			rq.enqueue(enq[i]);
		}
		
		System.out.println("\n\nprinting queue: ");
		for(String i : rq){
			System.out.print(" " + i);
		}
		
	}

}
