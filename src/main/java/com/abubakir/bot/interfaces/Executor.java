package com.abubakir.bot.interfaces;

import com.abubakir.bot.handlers.CommandHandler;
import com.pengrad.telegrambot.request.AbstractSendRequest;

public interface Executor {

	boolean shouldExecute(CommandHandler commandHandler);

	AbstractSendRequest<?> execute(CommandHandler commandHandler);
}
