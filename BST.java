
public class BST {
	Node root;
	 
	public void insert(int value)	{
		Node newnode = new Node(value);
		
		if(root == null) {
			root = newnode;
		}
		else {
			insertnode(root, newnode);
		}

		
	}
	
	public void insertnode(Node current, Node newnode)	{
		if(newnode.value >= current.value)	{
			if(current.right == null)	{
				current.right = newnode;
			}
			else	{
				insertnode(current.right, newnode);
			}
		} else	{
			if(current.left == null)	{
				current.left = newnode;
			}
			else	{
				insertnode(current.left, newnode);
			}
		}
	}
	
	
	public void delete(int value)	{
		if(search(value))	{
			root = deleteNode(root,value);
		}
	}
	
	public Node deleteNode(Node currentroot, int value)	{
		if(currentroot != null)	{	
			if(currentroot.value > value)	{
					currentroot.left = deleteNode(currentroot.left, value);
			}
			else if(currentroot.value < value)	{
				currentroot.right = deleteNode(currentroot.right, value);
			}
			else
			{
				if(currentroot.left == null && currentroot.right == null) {
					currentroot = null;
				} else if (currentroot.left == null){
					currentroot.value = currentroot.right.value;
					currentroot.right = null;
				} else if(currentroot.right == null) {
					currentroot.value = currentroot.left.value;
					currentroot.left = null;
				} else	{
					currentroot.value = leftMax(currentroot.left).value;
					currentroot.left = deleteNode(currentroot.left,currentroot.value);
				}
			}
		}
		return currentroot;
	}
	
	
	public Node leftMax(Node current)	{
		while(current.right != null) {
			current = current.right;
		}
		return current;
	}
	
	public Node rightMin(Node current)	{
		while(current.value >= current.left.value)	{
			current = current.left;
		}
		return current;
	}
	
	
	
	public int getHeight(Node currentroot) {
		if(currentroot == null)
		{
			return 0;
		}
		else
		{
			return Math.max(getHeight(currentroot.left) + 1, getHeight(currentroot.right) + 1);
		}
	}
	
	public void display()	{

		int height = getHeight(root);
		System.out.print(height+"\n");
		for(int i = 0; i<height;i++)	{
			printlevels(root,i);
			System.out.print("!");
		}

	}
	
	public void preorder() {
		System.out.println("\n");
		preorder(root);
	}
	
	public void inorder()	{
		System.out.println("\n");
		inorder(root);
	}
	
	public void postorder()	{
		System.out.println("\n");  
		postorder(root);
	}
	
	public void preorder(Node current)	{
		if(current != null)	{
			System.out.print(current.value);
			preorder(current.left);
			preorder(current.right);
		}
	}
	
	public void inorder(Node current)	{
		if(current != null)	{
			inorder(current.left);
			System.out.print(current.value);
			inorder(current.right);
		}
	}
	
	public void postorder(Node current)	{
		if(current != null)	{
			postorder(current.left);
			postorder(current.right);
			System.out.print(current.value);
		}
	}
	
	
	public void printlevels(Node root, int level) {
		 
		if(root == null) {
			return;
		}
		
		if(level == 0)	{
			System.out.print(root.value);
		}
		else {
			printlevels(root.left, level-1);
			if(root.left != null && root.right != null)
				System.out.print(",");
			printlevels(root.right,level-1);
			
		}
	}
	
	public boolean search(int value) {
		if(root != null)	{
			return searchnode(root, value);
		}
		return false;
	}
	
	public boolean searchnode(Node root, int value) {
		if(root != null) {
			if(root.value == value)	{
				return true;
			} 
			else 
			{	
				if(root.value > value)	{
					return searchnode(root.left, value);
				}
				else	{
					return searchnode(root.right, value);
				}
			}
		}
		return false;
	}
	
	public BST myclone()	{
		BST newtree = new BST();
		newtree.root = new Node(root.value);
		myclone1(root, newtree.root);
		return newtree;
	}
	
	void myclone1(Node currentroot, Node newcurrentroot)	{
		if(currentroot == null) {
			return;
		}
		if(currentroot.left != null)	{
			newcurrentroot.left = new Node(currentroot.left.value);
			myclone1(currentroot.left, newcurrentroot.left);
		}
		if(currentroot.right != null)	{
			newcurrentroot.right = new Node(currentroot.right.value);
			myclone1(currentroot.right, newcurrentroot.right);
		}
	}
	
	
	
	
	public static void main(String args[])	{
		
		BST tree = new BST();
		tree.insert(4);
		tree.insert(2);
		tree.insert(6);

		tree.insert(7);
		tree.insert(1);
		tree.insert(3);
		tree.insert(5);		
		
		tree.preorder();
		tree.inorder();
		tree.postorder();
		
		
	//	tree.insert(10);
	//	tree.insert(6);
	//	tree.display();
		
//		if(tree.search(1))	{
//			System.out.println("\nFound");
//		}	else	{
//			System.out .println("\nNot found");
//		}
		
	//	tree.delete(4);		
	//	tree.display();
//		
//		BST tree2 = tree.myclone();
//		
//		tree2.display();
//	//	tree.insert(10);
//	//	tree2.insert(11);
//		tree.display();
//		tree2.display();
		
	}
}
