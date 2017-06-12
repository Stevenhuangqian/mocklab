package com.steven.mock.test;

import org.junit.Test;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;

/**
 * 
 * State-based
 * @author qianhuang
 *
 */
class SimpleTool {
	 public String fun1(String str) {
	        return "real: public String fun1(" + str + ")";
	    }

	    private String fun2(String str) {
	        return "real: private String fun2(" + str + ")";
	    }

	    public String fun3(String str) {
	        return "real: public String fun3(" + str + ")";
	    }

	    public String fun4(String str) {
	        return fun2(str);
	    }
}


class UseSimpleTool {
    public String fun1(String name) {
    	SimpleTool simpleTool = new SimpleTool();
        return simpleTool.fun1(name);
    }
}

public class MockTest{
	
	
	@Mocked
	SimpleTool simpleTool;

	@Test
	public void testExpectation() {

	    //未mock函数返回null
	    new Expectations() {
	        {
	            simpleTool.fun1(anyString);
	            result = "MOCK";
	        }
	    };

	    System.out.println(simpleTool.fun1("param"));
	    System.out.println(simpleTool.fun3("param"));
	    System.out.println(new UseSimpleTool().fun1("param"));

	    new Verifications() {
	       {
	           simpleTool.fun1(anyString);
	           times = 2;
	       }
	    };
	}
	
	@Test
	public void testExpectation2() {

	    //未mock函数返回null
	    new Expectations() {
	        {
	            simpleTool.fun1(anyString);
	            result = "MOCK";
	        }
	    };

	    System.out.println(simpleTool.fun1("param"));
	    System.out.println(simpleTool.fun3("param"));
	    System.out.println(new UseSimpleTool().fun1("param"));

	    new Verifications() {
	        {
	            simpleTool.fun1(anyString);
	            times = 1;
	        }
	    };
	}
	
	@Test
	public void testExpectation3() {

	    new Expectations() {
	        {
	            simpleTool.fun1(anyString);
	            result = new Delegate<String>() {
	                public String aDelegateMethod(String str) {
	                    return str.equals("param0") ? "MOCK0" : "MOCK1";
	                }
	            };
	        }
	    };

	    System.out.println(simpleTool.fun1("param0"));
	    System.out.println(simpleTool.fun3("param"));
	    System.out.println(new UseSimpleTool().fun1("param1"));

	    new Verifications() {
	        {
	            simpleTool.fun1(anyString);
	            times = 2;
	        }
	    };
	}
}