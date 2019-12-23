package com.abubakir.bot.component.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AbstractSendRequest;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetFileResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotIO extends TelegramBot {

	Logger logger = LoggerFactory.getLogger(BotIO.class);
	private GetUpdates botUpdater;

	@Autowired
	public BotIO(@Value("${API_KEY}") String apiKey, GetUpdates botUpdater) {
		super(apiKey);
		this.botUpdater = botUpdater;
	}

	public List<Update> fetchUpdates(Integer offset) {
		botUpdater.offset(offset);
		GetUpdatesResponse updatesResponse = this.execute(this.botUpdater);
		return updatesResponse.updates();
	}

	public void sendRequest(AbstractSendRequest<?> request) {
		SendResponse sendResponse = execute(request);
		logger.info(String.valueOf(sendResponse.isOk()));
	}

	public BaseResponse sendRequestWithResponse(BaseRequest<GetFile, GetFileResponse> request) {
		return execute(request);
	}

}
