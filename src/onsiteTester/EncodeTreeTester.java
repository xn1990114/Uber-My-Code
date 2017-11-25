package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.EncodeTree;
import onsite.EncodeTree.TreeNode;
/*
 * 								1
 * 				2		   3	     4	   5	  6 |
 * 			7 8|           9| 10 11 12|    |      13|
 * 		14   | | 15 16 17 18|   |  |  |    |   19 20|  
 */			
public class EncodeTreeTester {

	@Test
	public void test() {
		EncodeTree tester=new EncodeTree();
		TreeNode n1=tester.new TreeNode(1);TreeNode n2=tester.new TreeNode(2);
		TreeNode n3=tester.new TreeNode(3);TreeNode n4=tester.new TreeNode(4);
		TreeNode n5=tester.new TreeNode(5);TreeNode n6=tester.new TreeNode(6);
		TreeNode n7=tester.new TreeNode(7);TreeNode n8=tester.new TreeNode(8);
		TreeNode n9=tester.new TreeNode(9);TreeNode n10=tester.new TreeNode(10);
		TreeNode n11=tester.new TreeNode(11);TreeNode n12=tester.new TreeNode(12);
		TreeNode n13=tester.new TreeNode(13);TreeNode n14=tester.new TreeNode(14);
		TreeNode n15=tester.new TreeNode(15);TreeNode n16=tester.new TreeNode(16);
		TreeNode n17=tester.new TreeNode(17);TreeNode n18=tester.new TreeNode(18);
		TreeNode n19=tester.new TreeNode(19);TreeNode n20=tester.new TreeNode(20);
		n1.child.add(n2);n1.child.add(n3);n1.child.add(n4);n1.child.add(n5);n1.child.add(n6);
		n2.child.add(n7);n2.child.add(n8);n3.child.add(n9);n4.child.add(n10);n4.child.add(n11);
		n4.child.add(n12);n6.child.add(n13);n7.child.add(n14);n9.child.add(n15);n9.child.add(n16);
		n9.child.add(n17);n9.child.add(n18);n13.child.add(n19);n13.child.add(n20);
		assertTrue(tester.encode(null).equals("null"));
		assertTrue(tester.sameTree(null, tester.decode("null")));
		String r1=tester.encode(n1);
		System.out.println(r1);
		TreeNode resRoot=tester.decode(r1);
		assertTrue(tester.sameTree(n1, resRoot));
	}

}
