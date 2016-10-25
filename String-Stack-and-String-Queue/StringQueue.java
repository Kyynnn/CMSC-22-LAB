public class StringQueue {
	private String[] elements;
	private int count;

	public StringQueue() {
		elements = new String[10];
	}

	public void enqueue(String item) {
		if (count == elements.length) {
			String[] temp = new String[elements.length + 1];
			for (int i = 0; i < count; i++) {
				temp[i] = elements[i];
			}
			temp[count++] = item;
			elements = temp;
		} else {
			elements[count++] = item;
		}		
	}


	public String dequeue() {
		String old = elements[0];
		if (count == 0) {
			throw new NullPointerException("Error!");
		}
		--count;
		for (int i = 0; i < count; i++) {
			elements[i] = elements[i + 1];
		}
		return old;
	}

	public String dequeue(int n) {
		String old = elements[n - 1];
		if (count == 0) {
			throw new NullPointerException("Error!");
		}
		for (int i = n, j = 0; i < elements.length - n; i++, j++) {
			elements[j] = elements[i];
		}
		count -= n;
		return old;
	}

	public String peek() {
		return elements[0];
	}

	public void singit(String element, int index) {
		String sub;		
		String prev = elements[index];
		if (count == elements.length) {
			String[] temp = new String[elements.length + 1]; 
			for (int i = 0; i < count; i++) {
				temp[i] = elements[i];
			}
			temp[count++] = element;
			elements = temp;
		} else {
			for (int i = index + 1; i < elements.length; i++){
        		sub = elements[i];
        		elements[i] = prev;         	
        		prev = sub;
    		}
			elements[index] = element;
			count++;
		}
	}

	public int size() {
		return count;
	}


	public String toString() {
		String result = "";
		for (int i = 0; i < count - 1; i++) {
			result += elements[i] + ", ";
		}
		return result + elements[count - 1];
		
	}

}
