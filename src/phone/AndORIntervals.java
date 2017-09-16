package phone;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * 给两组排好序的non-intersected的intervals，比如 [0, 0], [2, 2], [5, 10]
 *跟LC的interval的区别是这里intervals是离散的，类似[0, 0], [1, 2]这样的是invalid，因为可以写成[0, 2]
 *让写出对两组intervals的AND操作以及OR操作，输入输出，数据结构都可以自己定义
 */
public class AndORIntervals {
	public class Interval implements Comparable<Interval>{
		int start;
		int end;
		public Interval(int s,int e){
			this.start=s;
			this.end=e;
		}
		@Override
		public int compareTo(Interval i2){
			if(this.start<i2.start){
				return -1;
			}
			else if(this.start==i2.start){
				return 1;
			}
			return 1;
		}
	}
	public List<Interval> andIntervals(List<Interval> l1,List<Interval> l2){
		List<Interval> res=new ArrayList<Interval>();
		Collections.sort(l1);
		Collections.sort(l2);
		int i1=0;
		int i2=0;
		while(i1<l1.size()&&i2<l2.size()){
			Interval int1=l1.get(i1);
			Interval int2=l2.get(i2);
			if(int1.end>=int2.start&&int1.start<=int2.end){
				res.add(new Interval(Math.max(int1.start,int2.start),Math.min(int1.end, int2.end)));
			}
			if(int1.end==int2.end){
				i1++;
				i2++;
			}
			else if(int1.end<int2.end){
				i1++;
			}
			else{
				i2++;
			}
		}
		return res;
	}
	public List<Interval> orIntervals(List<Interval> l1,List<Interval> l2){
		if(l1.isEmpty()){
			return l2;
		}
		if(l2.isEmpty()){
			return l1;
		}
		List<Interval> res=new ArrayList<Interval>();
		Collections.sort(l1);
		Collections.sort(l2);
		int i1=0;
		int i2=0;
		while(i1<l1.size()||i2<l2.size()){
			if(i1==l1.size()){
				res.add(l2.get(i2));
				i2++;
			}
			else if(i2==l2.size()){
				res.add(l1.get(i1));
				i1++;
			}
			else{
				Interval int1=l1.get(i1);
				Interval int2=l2.get(i2);
				int currStart=Math.min(int1.start, int2.start);
				int currEnd=Math.min(int1.end, int2.end);
				while((i1<l1.size()&&l1.get(i1).start<=currEnd+1)||(i2<l2.size()&&l2.get(i2).start<=currEnd+1)){
					if(i1<l1.size()&&l1.get(i1).start<=currEnd+1){
						currEnd=Math.max(currEnd, l1.get(i1).end);
						i1++;
					}
					else{
						currEnd=Math.max(currEnd, l2.get(i2).end);
						i2++;
					}
				}
				res.add(new Interval(currStart,currEnd));
			}
		}
		return res;
	}
	
	public void displayList(List<Interval> res){
		for(Interval i:res){
			System.out.print("["+i.start+","+i.end+"] ");
		}
		System.out.println();
	}
}
