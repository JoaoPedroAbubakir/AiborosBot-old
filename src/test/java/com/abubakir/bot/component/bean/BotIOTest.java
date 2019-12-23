package com.abubakir.bot.component.bean;

import com.abubakir.bot.component.service.BotIO;
import com.pengrad.telegrambot.request.GetUpdates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
		BotIO.class,
		GetUpdates.class
})
class BotIOTest {

	@Autowired
	private BotIO botIO;

	@Test
	public void testBotCreation() {
		Assertions.assertNotNull(botIO);
	}

}