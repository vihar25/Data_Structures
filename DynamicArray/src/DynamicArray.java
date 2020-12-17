
public class DynamicArray<T> {
	private T[] arr;
	private int len = 0; // length user thinks array is
	private int capacity = 0; // Actual array size

	public DynamicArray() {
		this(2);
	}

	public DynamicArray(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}

	public int size()// to check how much array is full
	{
		return len;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T get(int index) {
//		T elem = arr[index];
//		return elem;
		return arr[index];
	}

	public void set(int index, T elem) {
		arr[index] = elem;
	}

	public void clear() {
		for (int i = 0; i < len; i++) {
			arr[i] = null;
			len = 0;
		}
	}

	public void add(T elem) {
		if (len + 1 >= capacity) {
			if (capacity == 0)
				capacity = 1;
			else
				capacity = capacity * 2;

			T[] new_arr = (T[]) new Object[capacity];
			for (int i = 0; i < len; i++) {
				new_arr[i] = arr[i];
			}
			arr = new_arr;
		}
		arr[len] = elem;
		len++;
	}

	public boolean remove(Object obj) {

		int index = indexOf(obj);
		if(index == -1)return false;
		removeAt(index);
		return true;

	}

	public T removeAt(int index)
	{
		if (index >= len || index < 0) throw new IndexOutOfBoundsException();
		T data = get(index);
		for(int i = 0, j =0;i<len;i++)
		{
			if(i == index)
			{
				arr[i] = arr[j+1];
				j++;
			}else
				arr[i] = arr[j];
				j++;
		}
		len--;
		return data;
	}

	public int indexOf(Object obj) {
		for (int i = 0; i < len; i++) {
			if (obj == null) {
				if (arr[i] == null)
					return i;
			}
			else
				{ if (obj.equals(arr[i]))
					return i;
				}
		}
		return -1;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;// this will return the index number which is not -1 as -1 is for out of index
	}
	public void  print()
	{
		for(int i = 0;i<len;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		DynamicArray a = new DynamicArray();
		a.add("A");
		a.add(2);
		a.add('c');
		a.print();
		System.out.println(a.indexOf('c'));
		System.out.println(a.get(2));
		a.set(1, 5);
		a.print();
		System.out.println(a.contains(2));
		a.add("Vihar");
		a.add(10);
		a.print();
		a.remove("A");
		a.print();
		a.removeAt(2);
		a.print();
		
	}
}
