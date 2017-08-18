package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ConstantTimeDS;

public class ConstantTimeDSTester {

	@Test
	public void test() {
		ConstantTimeDS<String> ctds=new ConstantTimeDS<String>();
		ctds.put("Nan");
		ctds.put("X");
		ctds.put("Who");
		System.out.println(ctds.getRandom());
		ctds.delete("Who");
		System.out.println(ctds.getRandom());
	}

}
