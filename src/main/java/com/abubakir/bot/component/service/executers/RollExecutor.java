package com.abubakir.bot.component.service.executers;

import com.abubakir.bot.component.service.messaging.RequestFactory;
import com.abubakir.bot.enums.CommandEnum;
import com.abubakir.bot.exception.InvalidArgsException;
import com.abubakir.bot.handlers.CommandHandler;
import com.abubakir.bot.handlers.RollHandler;
import com.abubakir.bot.interfaces.Executor;
import com.abubakir.bot.util.RandomGenerator;
import com.pengrad.telegrambot.request.AbstractSendRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RollExecutor implements Executor {

	private final RandomGenerator randomGenerator;
	private List<RollHandler> rollHandlerList;

	@Autowired
	public RollExecutor(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
	}

	@Override
	public boolean shouldExecute(CommandHandler commandHandler) {
		return commandHandler.getCommand().equals(CommandEnum.ROLL);
	}

	@Override
	public AbstractSendRequest<SendMessage> execute(CommandHandler commandHandler) {
		try {
			if (commandHandler.getArgs().length > 0) {
				buildRollHandlers(commandHandler.getArgs());
				String result = buildResultString();
				return RequestFactory.buildTextMessage(commandHandler.getChatId(), result);
			} else {
				throw new InvalidArgsException(commandHandler.getChatId());
			}
		} catch (NumberFormatException e) {
			throw new InvalidArgsException(commandHandler.getChatId());
		}
	}

	private void buildRollHandlers(String[] args) {
		this.rollHandlerList = Arrays.stream(args).map(RollHandler::parseStringIntoHandler).collect(Collectors.toList());
	}

	private String buildResultString() {
		return rollHandlerList.stream().map(this::buildRollResult).collect(Collectors.joining());
	}

	private String buildRollResult(RollHandler rollHandler) {
		StringBuilder sb = new StringBuilder("\nRolling " + rollHandler.getTimesToRoll() + "d" + rollHandler.getMaxValue() + ":\n");
		for (int i = 0; i < rollHandler.getTimesToRoll(); i = i + 1) {
			if (i == 0) {
				sb.append(roll(rollHandler.getMaxValue()));
			} else {
				sb.append(", ").append(roll(rollHandler.getMaxValue()));
			}
		}
		sb.append("\n========");
		return sb.toString();
	}

	private int roll(int maxValue) {
		return this.randomGenerator.getRandom().nextInt(maxValue) + 1;
	}
}
