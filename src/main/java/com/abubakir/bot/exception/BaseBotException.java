package com.abubakir.bot.exception;

public class BaseBotException extends RuntimeException {

	private Long chatId;

	public BaseBotException(String message, Long chatId) {
		super(message);
		this.chatId = chatId;
	}

	public BaseBotException(String message) {
		super(message);
	}


	public Long getChatId() {
		return chatId;
	}
}
