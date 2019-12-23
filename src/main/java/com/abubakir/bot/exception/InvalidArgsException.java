package com.abubakir.bot.exception;

public class InvalidArgsException extends BaseBotException {

	public InvalidArgsException(Long chatId) {
		super("Erro ao processar parâmetros do comando", chatId);
	}
}
