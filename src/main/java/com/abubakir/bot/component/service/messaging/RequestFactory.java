package com.abubakir.bot.component.service.messaging;

import com.abubakir.bot.exception.BaseBotException;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendAudio;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;

import java.io.File;

public final class RequestFactory {

	private RequestFactory() {

	}

	public static SendMessage buildExceptionMessage(BaseBotException exception) {
		return buildTextMessage(exception.getChatId(), exception.getMessage());
	}

	public static SendMessage buildTextMessage(Long chatId, String message) {
		return new SendMessage(chatId, message);
	}

	public static SendAudio buildAudioMessage(Long chatId, File file) {
		return new SendAudio(chatId, file);
	}

	public static SendPhoto buildPhotoMessage(Long chatId, File file) {
		return new SendPhoto(chatId, file);
	}

	public static GetFile getFile(String fileId) {
		return new GetFile(fileId);
	}
}
