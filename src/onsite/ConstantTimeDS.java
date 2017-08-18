package onsite;

import java.util.*;

public class ConstantTimeDS <T> {
	ArrayList<T> list;
	HashMap<T,Integer> map;
	public ConstantTimeDS(){
		this.list=new ArrayList<T>();
		this.map=new HashMap<T,Integer>();
	}
	public void put(T t){
		list.add(t);
		map.put(t, list.size()-1);
	}
	public T getRandom(){
		int index=(int)(Math.random()*list.size());
		return list.get(index);
	}
	public void delete(T t){
		int index=map.get(t);
		T last=list.get(list.size()-1);
		list.set(index, last);
		map.put(last, index);
		list.remove(list.size()-1);
		map.remove(t);
	}
}
