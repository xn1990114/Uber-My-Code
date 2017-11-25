package onsite;

import java.util.*;

/*
 * 问的问题是encode and decode tree，也就是tree2string, string2tree。
 * leetcode上貌似有原题，但是不同的地方在于，leetcode上是binary tree，
 * 面试的时候我问了能不能假设tree是binary tree，他说不可以。。。
 */
public class EncodeTree {
	public class TreeNode {
		int val;
		public List<TreeNode> child;

		public TreeNode(int val) {
			this.val = val;
			this.child = new ArrayList<TreeNode>();
		}
	}

	public String encode(TreeNode root) {
		if (root == null) {
			return "null";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.offer(root);
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int i = 0; i < size; i++) {
				TreeNode top = qu.poll();
				if (top.child.isEmpty()) {
					sb.append(':');
					sb.append("Empty");
				} else {
					for (int j = 0; j < top.child.size(); j++) {
						TreeNode c = top.child.get(j);
						sb.append(j == 0 ? ':' : ',');
						sb.append(c.val);
						qu.offer(c);
					}
				}
			}
		}
		return sb.toString();
	}

	public TreeNode decode(String s){
		if(s.equals("null")){
			return null;
		}
		String[] strs=s.split(":");
		TreeNode root=new TreeNode(Integer.parseInt(strs[0]));
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		qu.offer(root);
		int index=1;
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int i=0;i<size;i++){
				TreeNode top=qu.poll();
				if(!strs[index].equals("Empty")){
					String[] curr=strs[index].split(",");
					for(int j=0;j<curr.length;j++){
						TreeNode toadd=new TreeNode(Integer.parseInt(curr[j]));
						top.child.add(toadd);
						qu.offer(toadd);
					}
				}
				index++;
			}
		}
		return root;
	}
	public boolean sameTree(TreeNode n1,TreeNode n2){
		if(n1==null&&n2==null){
			return true;
		}
		if(n1==null||n2==null){
			return false;
		}
		if(n1.val!=n2.val||n1.child.size()!=n2.child.size()){
			return false;
		}
		for(int i=0;i<n1.child.size();i++){
			if(!sameTree(n1.child.get(i),n2.child.get(i))){
				return false;
			}
		}
		return true;
	}
}
