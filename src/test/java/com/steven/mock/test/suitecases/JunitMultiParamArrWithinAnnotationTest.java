package com.steven.mock.test.suitecases;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * 通过注解代替构造函数实现参数注入
 * @see JunitMultiParamArrTest 多套测试数据注入测试
 * @author qianhuang
 *
 */
@RunWith(Parameterized.class)
public class JunitMultiParamArrWithinAnnotationTest {

	/**
	 * 参数作用域不可用private
	 */
	@Parameter
	public int a;
	@Parameter(1)
	public int b;
	@Parameter(2)
	public String c;

	/**
	 * 通过构造函数注入数据
	 * @param a
	 * @param b
	 * @param c
	
	
	public JunitMultiParamArrWithinAnnotationTest(int a, int b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
	} */

	

	/**
	 * 注意方法必须使用static，不然报错
	 * @return
	 */
	@Parameters
	public static Collection getData() {
		return Arrays.asList(new Object[][] { {2,1,"1"}, {4,3,"1"}

		});
	}

	@Test
	public void sub() {
		System.out.println(c+"");
		
		assertTrue((a-b)==Integer.valueOf(c));
	}
}
