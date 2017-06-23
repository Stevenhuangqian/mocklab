package com.steven.mock.test.suitecases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 多个测试用例集合的套件测试
 * 适用于复杂的流程测试，类似包括创单跟回调、发币的整个储值流程
 * @author qianhuang
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JunitMultiParamArrTest.class,JunitTest.class,JunitMultiParamArrWithinAnnotationTest.class})
public class JunitTestCombine{
	
	
	
	
}