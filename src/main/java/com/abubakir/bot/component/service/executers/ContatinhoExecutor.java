package com.abubakir.bot.component.service.executers;

import com.abubakir.bot.enums.CommandEnum;
import com.abubakir.bot.handlers.CommandHandler;
import com.abubakir.bot.interfaces.Executor;
import com.pengrad.telegrambot.request.AbstractSendRequest;
import com.pengrad.telegrambot.request.SendContact;
import org.springframework.stereotype.Service;

@Service
public class ContatinhoExecutor implements Executor {


	@Override
	public boolean shouldExecute(CommandHandler commandHandler) {
		return commandHandler.getCommand().equals(CommandEnum.CONTATINHO);
	}

	@Override
	public AbstractSendRequest<SendContact> execute(CommandHandler commandHandler) {
		return new SendContact(commandHandler.getChatId(), "+55 61982457600", "Bete Pantera");
	}
}
