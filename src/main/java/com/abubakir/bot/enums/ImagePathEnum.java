package com.abubakir.bot.enums;

public enum ImagePathEnum {

	PINTINHO("classpath:images/pintinho.jpg"),
	GALO1("classpath:images/galo1.jpg"),
	GALO2("classpath:images/galo2.jpg");

	private String path;

	ImagePathEnum(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
