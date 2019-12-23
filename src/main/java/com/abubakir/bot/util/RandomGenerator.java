package com.abubakir.bot.util;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomGenerator {

	private Random random;

	public RandomGenerator() {
		this.random = new Random();
	}

	public Random getRandom() {
		return random;
	}
}
