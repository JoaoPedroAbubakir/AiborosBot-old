package com.abubakir.bot.handlers;

public class RollHandler {

	private int timesToRoll;
	private int maxValue;

	private RollHandler(int timesToRoll, int maxValue) {
		this.timesToRoll = timesToRoll;
		this.maxValue = maxValue;
	}

	private RollHandler(int maxValue) {
		this.timesToRoll = 1;
		this.maxValue = maxValue;
	}

	public static RollHandler parseStringIntoHandler(String arg) {
		String[] parsedString = arg.split("d");
		if (parsedString[0].equals("")) {
			return new RollHandler(Integer.parseInt(parsedString[1]));
		} else {
			return new RollHandler(Integer.parseInt(parsedString[0]), Integer.parseInt(parsedString[1]));
		}
	}

	public int getTimesToRoll() {
		return timesToRoll;
	}

	public int getMaxValue() {
		return maxValue;
	}

}
