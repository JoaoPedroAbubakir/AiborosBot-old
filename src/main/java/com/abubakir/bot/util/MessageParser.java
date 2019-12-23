package com.abubakir.bot.util;

import com.abubakir.bot.exception.CommandParsingException;

import java.util.Arrays;

public class MessageParser {

	String command;
	String[] args;

	public MessageParser(String message) {
		parseMessageForArgs(message);
	}

	private void parseMessageForArgs(String commandMessage) {
		if (commandMessage.contains(",")) {
			throw new CommandParsingException();
		}
		String[] splicedMessage = commandMessage.split(" ");
		this.command = splicedMessage[0].contains("@") ? parseCommandIfMention(splicedMessage[0]) : splicedMessage[0];
		this.args = Arrays.copyOfRange(splicedMessage, 1, splicedMessage.length);
	}

	private String parseCommandIfMention(String splicedMessage) {
		return splicedMessage.split("@")[0];
	}

	public String getCommand() {
		return command;
	}

	public String[] getArgs() {
		return args;
	}
}
