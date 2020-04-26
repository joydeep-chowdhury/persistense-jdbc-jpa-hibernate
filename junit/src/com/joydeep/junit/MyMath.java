package com.joydeep.junit;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MyMath {

	public int sum(int []numbers)
	{
		return Arrays.stream(numbers).reduce(0, Integer::sum);
	}
	
}
