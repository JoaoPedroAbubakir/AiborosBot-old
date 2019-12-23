package com.abubakir.bot.enums;

public enum ToadAudioPathEnum {

	CHANDELIER("classpath:toad_audio/Toad_Chandelier.mpeg"),
	BOHEMIAN("classpath:toad_audio/Toad_Bohemian.mpeg"),
	CHRISTMAS("classpath:toad_audio/Toad_Christmas.mpeg"),
	LET_IT_GO("classpath:toad_audio/Toad_LetItGo.mpeg"),
	SHALLOW("classpath:toad_audio/Toad_Shallow.mpeg");

	private String path;

	ToadAudioPathEnum(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
