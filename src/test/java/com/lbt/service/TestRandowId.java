package com.lbt.service;

import java.util.UUID;

import org.junit.Test;

public class TestRandowId {

	@Test
	public void test() {
		String id = UUID.randomUUID().toString();
		System.out.println(id);
	}

}
