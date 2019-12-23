package com.abubakir.bot.handlers;

import com.abubakir.bot.enums.CommandEnum;
import com.abubakir.bot.exception.CommandParsingException;
import com.abubakir.bot.exception.InvalidArgsException;
import com.abubakir.bot.util.DateTimeParser;
import com.abubakir.bot.util.MessageParser;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;

import java.time.LocalDateTime;

public class CommandHandler {

	private Integer updateId;
	private CommandEnum command;
	private String[] args;
	private LocalDateTime dtMensagem;
	private Message message;

	private CommandHandler(Update update) {
		this.updateId = update.updateId();
		this.message = update.message();
		parseMessageForArgs();
		parseDate();
	}

	private void parseMessageForArgs() {
		try {
			MessageParser mp = new MessageParser(this.message.text());
			this.command = CommandEnum.getCommandByString(mp.getCommand());
			this.args = mp.getArgs();
		} catch (CommandParsingException e) {
			throw new InvalidArgsException(this.getChatId());
		}
	}

	private void parseDate() {
		this.dtMensagem = DateTimeParser.parseDateFromEpoch(this.message.date());
	}

	public Long getChatId() {
		return this.message.chat().id();
	}

	public static CommandHandler build(Update update) {
		return new CommandHandler(update);
	}

	public Integer getUpdateId() {
		return updateId;
	}

	public CommandEnum getCommand() {
		return command;
	}

	public String[] getArgs() {
		return args;
	}

	public String getUserName() {
		return this.message.from().username();
	}

	public LocalDateTime getDtMensagem() {
		return dtMensagem;
	}

	public Message getMessage() {
		return message;
	}
}
