
public class Test {
	public class Node{
		int val;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public void tester() {
		Node obj1 = new Node(5);
		Node obj2 = obj1;
		obj2.val = 6;
		
		obj2 = null;
		
		System.out.println(obj1.val);
	}
}
