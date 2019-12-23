package com.abubakir.bot.component.service.processor;

import com.abubakir.bot.component.service.BotIO;
import com.abubakir.bot.exception.InvalidCommandException;
import com.abubakir.bot.handlers.CommandHandler;
import com.abubakir.bot.interfaces.Executor;
import com.pengrad.telegrambot.model.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandProccessor {

	private final BotIO botIO;
	private int currentUpdateId;
	private List<Executor> ExecutorList;

	@Autowired
	public CommandProccessor(List<Executor> ExecutorList, BotIO botIO) {
		this.ExecutorList = ExecutorList;
		this.botIO = botIO;
	}

	public void processUpdate(Update update) {
		this.currentUpdateId = update.updateId();
		CommandHandler commandHandler = CommandHandler.build(update);
		Optional<Executor> executor = ExecutorList.stream().filter(command -> command.shouldExecute(commandHandler)).findFirst();
		if (executor.isPresent()) {
			execute(commandHandler, executor.get());
		} else {
			throw new InvalidCommandException(update.message().chat().id());
		}
	}

	private void execute(CommandHandler commandHandler, Executor executor) {
		botIO.sendRequest(executor.execute(commandHandler));
	}

	public int getNextUpdateId() {
		return currentUpdateId + 1;
	}
}
