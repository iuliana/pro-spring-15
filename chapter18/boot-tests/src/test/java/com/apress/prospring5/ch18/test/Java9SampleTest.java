package com.apress.prospring5.ch18.test;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by iuliana.cosmina on 8/9/17.
 */
public class Java9SampleTest {

	@Test
	public void collections(){
		// problem is.... nothing seems to be done with it
		Map<String,Integer> immutableMap = Map.of("red", 2, "blue", 1);

		List<String> immutableList = List.of("2", "3", "4");
		Set<String> set = immutableList.stream().collect(Collectors.toSet());
	}

}
