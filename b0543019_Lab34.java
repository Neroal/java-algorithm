import java.util.*;

public class Lab34 {
	static boolean flag = false;
	//Create a DataSet
	static int[][] data = {{1,3,5},
							{1,3,9},
						     {2,3,8},
						      {2,3,9}};
	
	//Define tree structure node
	public static class treenode 
	{
		int value;
		int count=0;
		int len;
		ArrayList<treenode> child;
		
		treenode(int v,int q,int p)
		{
			value = v;
			count = q;
			len = p;
			child = new ArrayList<treenode>();
		}
	}
	//Define tree structure
	public static class tree
	{
		treenode root;
		tree(int v)
		{
			root = new treenode(v,0,0);
		}
		
		public static void traverse(treenode c)
		{
			if(c.value==-1)
			{
				System.out.println("Level1:root:"+ c.value+" ");
			}
			for(int i=0;i<c.child.size();i++)
			{
				treenode n = c.child.get(i);
				if(n.len==2)System.out.println("");
				System.out.print("Level"+n.len+"["+n.value+":"+n.count+"] ");
				traverse(n);
			}
		}
	}//End class
	public static void main(String[] arg)
	{
		tree x = new tree(-1);
		
		treenode r = x.root;
		
		treenode c = r;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				treenode n = new treenode(data[i][j],1,(j+2));
				
				if(j==0)
				{
					if(r.child.size()==0)
					{
						r.child.add(n);
						c=n;
					}//size==0
					else
					{
						for(int k=0;k<r.child.size();k++)
						{
							if(r.child.get(k).value ==data[i][j])
							{
								r.child.get(k).count++;
								flag = true;
								c = r.child.get(k);
							}//child have same data
						}//End k
						
						if(flag != true)
						{
							r.child.add(n);
							c=n;
						}//Add child
						
						flag = false;
					}//size!=0
				}//j==0	
				else
				{
					if(c.child.size()==0)
					{
						c.child.add(n);
						c=n;
					}//size==0
					else
					{
						for(int k=0;k<c.child.size();k++)
						{
							if(c.child.get(k).value == data[i][j])
							{
								c.child.get(k).count++;
								flag = true;
								c = c.child.get(k);
							}//child have same data
						}//End k
						
						if(flag != true)
						{
							c.child.add(n);
							c=n;
						}//Add child
						
						flag = false;
					}//size!=0				
				}//j!=0
			}//End j
			c = r;
		}//End i
		x.traverse(r);
	}//End main
}
