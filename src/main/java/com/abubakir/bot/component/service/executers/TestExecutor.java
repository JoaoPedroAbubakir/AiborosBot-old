package com.abubakir.bot.component.service.executers;

import com.abubakir.bot.component.service.messaging.RequestFactory;
import com.abubakir.bot.enums.CommandEnum;
import com.abubakir.bot.handlers.CommandHandler;
import com.abubakir.bot.interfaces.Executor;
import com.google.gson.Gson;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.AbstractSendRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;


@Service
public class TestExecutor implements Executor {

	@Override
	public boolean shouldExecute(CommandHandler commandHandler) {
		return commandHandler.getCommand().equals(CommandEnum.TESTE);
	}

	@Override
	public AbstractSendRequest<SendMessage> execute(CommandHandler commandHandler) {
		Message message = commandHandler.getMessage();
		Gson gson = new Gson();
		return RequestFactory.buildTextMessage(commandHandler.getChatId(), gson.toJson(message));
	}
}
