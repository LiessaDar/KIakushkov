package ru.LiessaDar.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelegramBotApplication {
//	TelegramBot bot = new TelegramBot("BOT_TOKEN");
	public static void main(String[] args) {
		SpringApplication.run(TelegramBotApplication.class, args);
	}
}
