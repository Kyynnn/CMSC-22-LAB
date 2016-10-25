public class StringStack {
	private int count;
	public static final int DEFAULT_SIZE = 10;
	private String[] elements;

	public void push(String item) {
		if (count == elements.length) {
			String[] temp = new String[elements.length * 2];
			for (int i = 0; i < elements.length; i++) {
				temp[i] = elements[i];
			}
			temp[count++] = item;
			elements = temp;
		} else {
			elements[count++] = item;	
		}
	}

	public String pop() {
		if (count == 0) {
			throw new NullPointerException("Error!");
		}
		return elements[--count];
	}

	public String pop(int n) {
		if (n > count) {
			throw new IllegalArgumentException("Error!");
		}
		for (int i = n; i > 0; i--) {
			count--;
		}	
		return elements[count];
	}

	public int size() {
		return count;
	}

	public StringStack() {
		elements = new String[DEFAULT_SIZE];
	}

	public StringStack(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Error!");
		}
		elements = new String[size];
	}

	public String peek() {
		return elements[count - 1];
	}

	public String toString() {
		String result = "";
		if (count == 0) {
			return "EMPTY";
		}
		for (int i = 0; i < count - 1; i++) {
			result += elements[i] + ", ";
		}
		return result + elements[count - 1];
	}
}
