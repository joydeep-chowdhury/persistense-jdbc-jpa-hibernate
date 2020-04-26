package com.joydeep.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssertTest {

	@Test
	void test() {
		assertEquals(3, 3);
		assertEquals(3, 3);
		assertTrue("New".equals("New"));
	}

}
