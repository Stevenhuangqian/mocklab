package com.steven.mock.test.suitecases;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * 多套测试数据注入
 * @author 黄谦
 *
 */
@RunWith(Parameterized.class)
public class JunitMultiParamArrTest {
	
	/**
	 * 参数作用域private、public都可
	 */
	public int a;
	private int b;
	private String c;

	/**
	 * 通过构造函数注入数据
	 * @param a
	 * @param b
	 * @param c
	 */
	public JunitMultiParamArrTest(int a, int b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	

	/**
	 * 注意方法必须使用static，不然报错
	 * @return
	 */
	@Parameters
	public static Collection getData() {
		return Arrays.asList(new Object[][] { {1,2,"-1"}, {2,3,"-1"}

		});
	}

	@Test
	public void sub() {
		assertTrue((a-b) == Integer.valueOf(c));
	}

}
