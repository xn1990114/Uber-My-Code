package phoneTester;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import phone.AndORIntervals;
import phone.AndORIntervals.Interval;

public class AndORIntervalsTester {
	@Test
	public void test() {
		List<Interval> l1=new ArrayList<Interval>();
		List<Interval> l2=new ArrayList<Interval>();
		int[][] input1={
				{0,0},
				{2,2},
				{5,10},
				{20,Integer.MAX_VALUE}
		};
		int[][] input2={
				{Integer.MIN_VALUE,0},
				{2,6},
				{8,8},
				{10,Integer.MAX_VALUE}
		};
		AndORIntervals tester=new AndORIntervals();
		for(int i=0;i<4;i++){
			l1.add(tester.new Interval(input1[i][0],input1[i][1]));
			l2.add(tester.new Interval(input2[i][0],input2[i][1]));
		}
		List<Interval> andRes=tester.andIntervals(l1, l2);
		tester.displayList(andRes);
		List<Interval> orRes1=tester.orIntervals(l1, l2);
		tester.displayList(orRes1);
		int[][] input3={
				{0,0},
				{2,2},
				{5,9},
				{11,1000},
				{1201,1205}
		};
		int[][] input4={
				{-50,-10},
				{2,6},
				{8,8},
				{20,1200},
				{1205,1210}
		};
		l1.clear();
		l2.clear();
		for(int i=0;i<5;i++){
			l1.add(tester.new Interval(input3[i][0],input3[i][1]));
			l2.add(tester.new Interval(input4[i][0],input4[i][1]));
		}
		List<Interval> orRes2=tester.orIntervals(l1, l2);
		tester.displayList(orRes2);
	}

}
