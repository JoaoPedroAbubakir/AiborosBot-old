package com.abubakir.bot.component.service.executers;

import com.abubakir.bot.component.service.messaging.RequestFactory;
import com.abubakir.bot.enums.CommandEnum;
import com.abubakir.bot.enums.ToadAudioPathEnum;
import com.abubakir.bot.exception.BaseBotException;
import com.abubakir.bot.handlers.CommandHandler;
import com.abubakir.bot.interfaces.Executor;
import com.abubakir.bot.util.RandomGenerator;
import com.pengrad.telegrambot.request.AbstractSendRequest;
import com.pengrad.telegrambot.request.SendAudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Service
public class ToadExecutor implements Executor {


	private final ResourceLoader resourceLoader;

	private final RandomGenerator randomGenerator;

	@Autowired
	public ToadExecutor(RandomGenerator randomGenerator, ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		this.randomGenerator = randomGenerator;
	}

	@Override
	public boolean shouldExecute(CommandHandler commandHandler) {
		return commandHandler.getCommand().equals(CommandEnum.TOAD);
	}

	@Override
	public AbstractSendRequest<SendAudio> execute(CommandHandler commandHandler) {
		File file;
		try {
			file = retrieveRandomToadFile();
		} catch (IOException e) {
			throw new BaseBotException("Erro ao recuperar arquivos de audio", commandHandler.getChatId());
		}
		return RequestFactory.buildAudioMessage(commandHandler.getChatId(), file);
	}

	private File retrieveRandomToadFile() throws IOException {
		return resourceLoader.getResource(Arrays.asList(ToadAudioPathEnum.values()).get(
				randomGenerator.getRandom().nextInt(ToadAudioPathEnum.values().length)).getPath()).getFile();
	}


}
