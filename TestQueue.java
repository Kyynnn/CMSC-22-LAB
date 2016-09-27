public class TestQueue {
	public static void main (String[] args) {
		StringQueue q = new StringQueue();

		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		q.enqueue("E");
		q.enqueue("F");
		q.enqueue("G");
		q.enqueue("H");
		q.enqueue("I");
		q.enqueue("J");
		System.out.println(q); // show queue

		q.enqueue("K"); // extend the queue maximum size by enqueueing another element
		System.out.println(q); // show queue

		q.singit("F", 1); // apply singit method
		System.out.println(q); // show updated queue with singit

		System.out.println(q.peek()); // show first queued element

		q.dequeue(); // apply dequeue method
		System.out.println(q); // show updated queue

		q.dequeue(2); // apply dequeue overloaded method 
		System.out.println(q); // show updated queue
	}
}