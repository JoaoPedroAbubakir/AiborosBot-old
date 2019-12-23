package com.abubakir.bot.config;

import com.pengrad.telegrambot.request.GetUpdates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class Config {

	@Bean
	public GetUpdates createUpdatesBean() {
		return new GetUpdates().limit(100).offset(0).timeout(0);
	}

}
