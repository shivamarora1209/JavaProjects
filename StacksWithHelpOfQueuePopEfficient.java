import java.util.LinkedList;
import java.util.Queue;

public class StacksWithHelpOfQueuePopEfficient {
	
	Queue<Integer> PrimaryQueue ;
	Queue<Integer> SecondaryQueue ;
	
	public StacksWithHelpOfQueuePopEfficient(){
		this.PrimaryQueue = new LinkedList<>();
		this.SecondaryQueue = new LinkedList<>();
	}
	
	public boolean isEmpty() {
		return this.PrimaryQueue.size() == 0 ;
	}
	
	public void push(int item) {
		this.SecondaryQueue.add(item);
		while(!PrimaryQueue.isEmpty()) {
			this.SecondaryQueue.add(this.PrimaryQueue.poll());
		}
		Queue<Integer> TempQueue = new LinkedList<>();
		TempQueue = this.PrimaryQueue ;
		this.PrimaryQueue = this.SecondaryQueue ;
		this.SecondaryQueue = TempQueue ;
	}
	
	public int pop() {
		return this.PrimaryQueue.poll();
	}
	
	public int top() {
		return this.PrimaryQueue.peek();
	}
}
