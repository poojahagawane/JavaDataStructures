
public class Queue {
	int count;
	int front, back, size;
	int[] arr;
	
	Queue()	{
		this.count = 0;
		this.front = 0;
		this.size = 10;
		this.back = 0;
		arr = new int[this.size];
	}
	
	Queue(int size)	{
		this.count = 0;
		this.front = 0;
		this.size = size;
		this.back = 0;
		arr = new int[size];
	}
	
	public void Enqueue(int value) {
		if (count == size) {
			int[] temp = new int[size * 2];
			int j = 0;
			for(int i = front; i< size; i++) {
				temp[j] = arr[i];
				j++;
			}
			if(front != 0)	{
				for(int i = 0; i<= back; i++)	{
					temp[j] = arr[i];
					j++;
				}
			}
			arr = temp;
			front = 0;
			size = size * 2;
			Enqueue(value);
		}  
		else	{
			back = ( front + count ) % size;
			arr[back] = value;
			count++;
		}
	}
	
	public int Dequeue()	{
		int val = arr[front];
		arr[front] = 0;
		front++;
		count--;
		return val;
	}
	

	private void display() {
		for(int i = 0; i < size; i++) {
			if(arr[i] != 0)	{
				System.out.print(arr[i]);
				if(i+1 != size)	{
					System.out.print(",");
				}
			}
		}
		System.out.println("\n");
	}
	


	public static void main(String args[])	{
		Queue q = new Queue(5);
		q.Enqueue(10);
		q.Enqueue(2);
		q.Enqueue(1);
		q.Enqueue(3);
		q.Enqueue(5);
		q.display();
		q.Dequeue();
		q.Dequeue();
		q.display();
		q.Enqueue(13);
		q.Enqueue(15);
		q.display();
		q.Enqueue(23);
		q.Enqueue(25);
		q.display();
		q.Dequeue();
		q.Dequeue();
		q.display();		
}

}
