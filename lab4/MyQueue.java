public class MyQueue{
	private MyLinkedList theQueue;

	public MyQueue(){
		theQueue = new MyLinkedList();
	}

	public boolean enqueue(Double d){
		return theQueue.addLast(d);
	}
	public Double dequeue(){
		return theQueue.removeFirst();
	}
	public Double peek(){
		return theQueue.get(0);
	}
	public int size(){
		return theQueue.size();
	}
	public Strig toString(){
		return theQueue.toString();
	}
	public static void main(String[] args){
		MyQueue testQueue  =new MyQueue();

		testQueue.enqueue(1.0);
		testQueue.enqueue(2.0);
		testQueue.enqueue(3.0);

		System.out.println("The first elem is " + testQueue.peek());
		testQueue.dequeue();
		System.out.print(testQueue);
	}
}