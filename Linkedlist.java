
public class Linkedlist {
	Node Head;
	Node Tail;
	
	public void Insert(int value)	{
		Node NewNode = new Node(value);
		
		if(Head == null) {
			Head = NewNode;
			Tail = NewNode;
		}
		else	
		{
			Tail.Next = NewNode;
			Tail = NewNode;
		}
			
	}
	
	public int getValue()	{
		
		if(Head == null)	{
			System.out.println("Blank Linked List..!!");
			return 0;
		}
		else	{
			Node current = Head;
			if(current != null)	{
				return current.value;
			}
	
		}
		return 0;
	}
	
	public void PrintLL(Node Head) {
		if(Head == null)	{
			System.out.println("Blank Linked List..!!");
		}
		else	{
			Node current = Head;
			while(current != null)	{
				System.out.print(current.value);
				if(current.Next != null)	{
					System.out.print("->");
				}
				current = current.Next;
			}
			System.out.println("\n");
		}
	}
	
	public void PrintLL() {
		if(Head == null)	{
			System.out.println("Blank Linked List..!!");
		}
		else	{
			Node current = Head;
			while(current != null)	{
				System.out.print(current.value);
				if(current.Next != null)	{
					System.out.print("->");
				}
				current = current.Next;
			}
			System.out.println("\n");
		}
	}
	
	public Linkedlist clone()	{
		
		Linkedlist newll = new Linkedlist();
		
		if(Head != null)	{
			newll.Head = new Node(Head.value);
			Node current = Head.Next;
			Node newcurrent = newll.Head;
			while(current != null)	{
				newcurrent.Next = new Node(current.value);
				newcurrent = newcurrent.Next;
				current = current.Next;
			}
			newll.Tail = newcurrent;
		}
		return newll;
	}
	
	public boolean ReverseLL()	{
		if(Head == null)
		{	
			return false;
		}
		else	{
			Node current = Head;
			Node temp = null;
			Node prev = null;
			
			while(current != null)	{
				temp = current.Next;
				current.Next = prev;
				prev = current;
				current = temp;
			}
		Head = prev;
		}
		return true;
	}
	
	public Node getHead()	{
		return Head;
	}
	
	public boolean ReverseLLmton(int m, int n)	{
		if(Head == null)
		{	
			return false;
		}
		else	{
			
			int count = 1;

			Node prev = Head;
			Node current = Head;
			Node end = Head;
			
			while(count < m) {
				prev = prev.Next;
				current = current.Next;
				count++;
			}
			
			while(count <  n)	{
				end = end.Next;
				count++;
			}
			
			current = current.Next;
			Node temp = current;
			
			while(current != end)	{
				temp = current.Next;
				current.Next = prev;
				prev = current;
				current = temp;
			}
		}
		return true;
	}
		
	
	public static void main(String args[])	{
		Linkedlist ll = new Linkedlist();

		ll.Insert(8);
		ll.Insert(1);
		ll.Insert(0);
		ll.Insert(3);
	//	ll2.Insert(34);
		ll.Insert(10);
		ll.Insert(11);
		ll.Insert(12);
		ll.Insert(13);
		
		Linkedlist ll2 = ll.clone(); 		


		ll.Insert(1);
		ll2.Insert(0);
		ll2.Insert(3);
		
		ll.PrintLL();
		ll2.PrintLL();		
	/*	if (!ll.ReverseLL())	{
			System.out.println("Blank Linked List..!!");
		} else 	{
			ll.PrintLL();
		} 
		if (!ll.ReverseLLmton(2,3))	{
			System.out.println("Blank Linked List..!!");
		} else 	{
			ll.PrintLL();
		}  */
		
		
		
	}
	
}
