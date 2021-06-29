package com.poly.test_Junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ loginTestJunit.class, userTestJunit.class, productTestJunit.class })
public class testRunWith {

	public static void main(String[] args) throws Exception {
		JUnitCore runner = new JUnitCore();
		Result result = runner.run(userTestJunit.class, productTestJunit.class);
		System.out.println("run tests:" + result.getRunCount());
		System.out.println("fail test:" + result.getFailureCount());
		System.out.println("ignored tests:" + result.getIgnoreCount());
		System.out.println("success:" + result.wasSuccessful());
	}
}
