package com.abubakir.bot.exception;

public class InvalidCommandException extends BaseBotException {
	public InvalidCommandException(Long chatId) {
		super("Erro ao processar comando", chatId);
	}
}
