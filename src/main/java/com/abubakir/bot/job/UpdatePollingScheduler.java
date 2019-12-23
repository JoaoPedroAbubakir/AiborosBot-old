package com.abubakir.bot.job;

import com.abubakir.bot.component.service.BotIO;
import com.abubakir.bot.component.service.messaging.RequestFactory;
import com.abubakir.bot.component.service.processor.CommandProccessor;
import com.abubakir.bot.exception.BaseBotException;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UpdatePollingScheduler {

	private final BotIO botIO;
	private final CommandProccessor commandProccessor;
	private Integer offset = 0;

	@Autowired
	public UpdatePollingScheduler(BotIO botIO, CommandProccessor commandProccessor) {
		this.botIO = botIO;
		this.commandProccessor = commandProccessor;
	}


	@Scheduled(fixedRate = 10000)
	public void initializePolling() {
		try {
			this.botIO.fetchUpdates(offset).forEach(commandProccessor::processUpdate);
		} catch (BaseBotException e) {
			SendMessage request = RequestFactory.buildExceptionMessage(e);
			this.botIO.sendRequest(request);
		} finally {
			updateOffset();
		}
	}

	private void updateOffset() {
		this.offset = commandProccessor.getNextUpdateId();
	}
}
