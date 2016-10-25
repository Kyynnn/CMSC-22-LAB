public class TestStack {
	public static void main (String[] args) {
		StringStack stack = new StringStack();
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		stack.push("6");
		stack.push("7");
		stack.push("8");
		stack.push("9");
		stack.push("10");
		stack.push("11");
		
		System.out.println(stack); // show stack
		System.out.println(stack.size()); // show size of stack
		
		String item = stack.pop(3); // test popping n times
		System.out.println(item); // show last item popped
		
		System.out.println(stack); // show updated stack
		System.out.println(stack.size()); // show updated size
		
		stack.push("D");
		stack.push("E");
		stack.push("F");
		
		System.out.println(stack);
		System.out.println(stack.size());
		
		String item2 = stack.pop(); // test default pop
		System.out.println(item2); // show popped item
		
		System.out.println(stack);
		System.out.println(stack.size());
	}
}
