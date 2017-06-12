package com.steven.mock.test;

import org.junit.Test;

import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;

/**
 * Behavior-based
 * @author qianhuang
 *
 */
public class ServiceMock {
	@Test
	public void testMockUp() {
	    //影响该类所有实例
	    new MockUp<SimpleTool>(){
	        //未mock函数不受影响
	        @Mock
	        public String fun1(String str) {
	            return "(MOCK)";
	        }
	    };

	    SimpleTool simpleTool = new SimpleTool();
	    System.out.println(simpleTool.fun1("param"));
	    System.out.println(simpleTool.fun3("param"));
	    UseSimpleTool useSimpleTool = new UseSimpleTool();
	    System.out.println(useSimpleTool.fun1("param"));
	}
	
	@Test
	public void testMockUp2() {
	    new MockUp<SimpleTool>(){
	        //未mock函数不受影响
	        @Mock
	        public String fun2(String str) {
	            return "(MOCK)";
	        }
	    };

	    SimpleTool simpleTool = new SimpleTool();
	    System.out.println(simpleTool.fun1("param"));
	    System.out.println(simpleTool.fun3("param"));
	    System.out.println(simpleTool.fun4("param"));
	}
	
	
	//此处使用Injectable和Mocked为一样的效果
	@Injectable
	SimpleInterface simpleInterface;

	@Test
	public void testUpper() throws Exception {
	    SimpleInterface mockInstance =  new MockUp<SimpleInterface>() {
	        @Mock
	        public String getCityName() {
	            return "BEIJING(MOCK)";
	        }

	        @Mock
	        public String getAreaName() {
	            return "HUABEI(MOCK)";
	        }

	    }.getMockInstance();

	    System.out.println(mockInstance.getCityName());
	    System.out.println(mockInstance.getAreaName());
	    System.out.println(simpleInterface.getCityName());
	    System.out.println(simpleInterface.getAreaName());
	    SimpleInterfaceImpl simpleInterfaceImpl = new SimpleInterfaceImpl();
	    System.out.println(simpleInterfaceImpl.getCityName());
	    System.out.println(simpleInterfaceImpl.getAreaName());
	}
}

interface SimpleInterface {
    String getCityName();
    String getAreaName();
}

class SimpleInterfaceImpl implements SimpleInterface {
    public String getCityName() {
        return "default city";
    }
    public String getAreaName() {
        return "default area";
    }
}
