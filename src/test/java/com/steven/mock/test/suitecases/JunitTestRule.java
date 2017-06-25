package com.steven.mock.test.suitecases;

import org.junit.Rule;

/**
 * @rule注解说明demo
 * @author Administrator
 *
 */
public class JunitTestRule {
	@Rule
	public MyRule rule =new MyRule();
}

class MyRule {
	
	
}