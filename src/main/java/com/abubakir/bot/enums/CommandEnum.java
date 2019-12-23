package com.abubakir.bot.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CommandEnum {

	INVALID_COMMAND(""),
	ROLL("/roll"),
	TOAD("/toad"),
	PAU("/pau"),
	TESTE("/test");

	private String commandString;

	CommandEnum(String commandString) {
		this.commandString = commandString;
	}

	public static CommandEnum getCommandByString(String commandString) {
		Optional<CommandEnum> commandEnumOptional = Arrays.stream(CommandEnum.values()).filter(commandEnum ->
				commandEnum.getCommandString().equals(commandString)).findFirst();
		return commandEnumOptional.orElse(INVALID_COMMAND);
	}

	public String getCommandString() {
		return commandString;
	}
}
