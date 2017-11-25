package com.young.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class DateFormatUtilsTest {

	@Test
	public void testToyyyyMMddHHmmss() {
		System.out.println(DateFormatUtils.toyyyyMMddHHmmss(new Date()));
	}

	@Test
	public void testToyyyyMMdd() {
		System.out.println(DateFormatUtils.toyyyyMMdd(new Date()));
	}

}
