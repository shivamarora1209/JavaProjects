import java.util.Stack;

public class QueueWithHelpOfStacksDequeueEfficient {
	
	Stack<Integer> PrimaryStack ;
	Stack<Integer> SecondaryStack ;
	
	public QueueWithHelpOfStacksDequeueEfficient() {
		PrimaryStack = new Stack<>() ;
		SecondaryStack = new Stack<>();
	}
	
	public boolean isEmpty() {
		return this.PrimaryStack.size() == 0 ;
	}

	public void enqueue(int value) {
		ReverseStack(PrimaryStack, SecondaryStack, 0);
		
		this.SecondaryStack.push(value); 
		while(!PrimaryStack.isEmpty()) {
			this.SecondaryStack.push(this.PrimaryStack.pop());
		}
		
		Stack<Integer> TempStack = new Stack<>();
		TempStack = this.PrimaryStack ;
		this.PrimaryStack = this.SecondaryStack ;
		this.SecondaryStack = TempStack ;
		
	}
	
	public int dequeue() {
		return this.PrimaryStack.pop();
	}
	
	public int front() {
		return this.PrimaryStack.peek();
	}
	
	public static void ReverseStack(Stack<Integer>PrimaryStack , Stack<Integer> SecondaryStack , int index) {
		if(PrimaryStack.isEmpty()) {
			return ;
		}
		
		int value = PrimaryStack.pop();
		ReverseStack(PrimaryStack, SecondaryStack, index + 1);
		SecondaryStack.push(value);
		
		if(index == 0) {
			while(!SecondaryStack.isEmpty()) {
				PrimaryStack.push(SecondaryStack.pop());
			}
		}
	}
}
