package week15;
import java.util.LinkedList;
import java.util.ArrayList;

public class Lab44 {
	static LinkedList<treenode> Queue = new LinkedList<treenode>();
	public static void BFS(treenode root)
	{	
		sop("traverse node:"+root.value+"\n");
		sop("Queue:");
		for(int i=0;i<root.child.size();i++)
		{
			treenode c = root.child.get(i);
			Queue.add(c);
		}		
		Queue.removeFirst();
		for(int i=0;i<Queue.size();i++)sop(Queue.get(i).value+" ");
		
		if(Queue.size()!=0)
		{
			sop("\n");
			BFS(Queue.get(0));
		}
		else sop("Empty!");
	}

	public static void main(String[] arg)
	{
		tree x = new tree(1);	
		treenode r = x.root;
		treenode c2 = new treenode(2);
		treenode c3 = new treenode(3);
		treenode c4 = new treenode(4);
		treenode c5 = new treenode(5);
		treenode c6 = new treenode(6);
		treenode c7 = new treenode(7);
		treenode c8 = new treenode(8);
		treenode c9 = new treenode(9);
		treenode c10 = new treenode(10);
		treenode c11 = new treenode(11);
		treenode c12 = new treenode(12);
		treenode c13 = new treenode(13);
		treenode c14 = new treenode(14);
		treenode c15 = new treenode(15);
		treenode c16 = new treenode(16);
		
		r.child.add(c2);
		r.child.add(c3);
		r.child.add(c4);
		c2.child.add(c5);
		c2.child.add(c6);
		c2.child.add(c7);
		c3.child.add(c8);
		c3.child.add(c9);
		c4.child.add(c10);
		c4.child.add(c11);
		c4.child.add(c12);
		c6.child.add(c13);
		c6.child.add(c14);
		c11.child.add(c15);
		c11.child.add(c16);
		
		Queue.add(r);
		BFS(r);
		//tree.traverse(r);
	}
	
	public static class treenode
	{
		int value;
		ArrayList<treenode> child;
		
		treenode(int v)
		{
			value = v;
			child = new ArrayList<treenode>();
		}	
	}
	
	public static class tree
	{
		treenode root;
		
		tree(int v)
		{
			root = new treenode(v);
		}
		
		public static void traverse(treenode c)
		{
			for(int i=0;i<c.child.size();i++)
			{
				treenode n = c.child.get(i);
				sop(n.value+" ");
				traverse(n);
			}
			//sop("\n");
		}
	}
	
	public static void sop(Object object)
	{
		System.out.print(object);
	}
}