package org.revision;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({JunitRevision.class,JunitAssert.class})



public class JunitSuite {
	
	
	public  void tc() {
		
		
		
		Result r = JUnitCore.runClasses(JunitAssert.class,JunitRevision.class);
		System.out.println("\n Run Count" +r.getRunCount());
		System.out.println("\n Ignore Count" +r.getIgnoreCount());
		System.out.println("\n Run Time:" +r.getRunTime());
		 

	}
	
	
	
	

}
