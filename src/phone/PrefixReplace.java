package phone;

public class PrefixReplace {
	public class Node{
		Node[] child;
		boolean isLeaf;
		public Node(){
			this.child=new Node[256];
			this.isLeaf=false;
		}
	}
	public String replace(String s,String[] dic){
		Node root=new Node();
		for(int i=0;i<dic.length;i++){
			buildTrie(root,dic[i]);
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
				int start=i;
				while(i<s.length()&&((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z'))){
					i++;
				}
				sb.append(findReplacement(root,s.substring(start,i)));
				i--;
			}
			else{
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	public String findReplacement(Node root,String s){
		Node curr=root;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(curr.child[ch]==null){
				return s;
			}
			else if(curr.child[ch].isLeaf){
				return s.substring(0,i+1);
			}
			curr=curr.child[ch];
		}
		return s;
	}
	
	public void buildTrie(Node root,String s){
		Node curr=root;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(curr.child[ch]==null){
				curr.child[ch]=new Node();
			}
			curr=curr.child[ch];
		}
		curr.isLeaf=true;
	}
}
