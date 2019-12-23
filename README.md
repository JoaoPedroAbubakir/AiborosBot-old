# AiborosBot
This is a simple telegram bot.

It's usage and construction are quite simple.

I'm using it to learn and test ou new coding patterns.

To run this bot, simply set an Environment Variable called API_KEY and set
the value to your bot API Key.

If you are working behind a proxy with/without authentication
You need to set these to you JVM args

-Dhttps.proxyHost="" -Dhttps.proxyPort="" -Dhttps.proxyUser="" -Dhttps.proxyPassword=""


All messaging is managed by the class BotIO, and messages are build on RequestFactory

To add a new command basically add the command string to the CommandEnum and
make a new class under the "executers" package, implement com.abubakir.bot.interfaces.Executor
And you are set. Place the validation if the message is equals to the command enum you defined
on "shouldExecute" and place the rest on the "execute" method.

This bot was made for Portuguese-BR live usage, I've tried to make the whole code
in english but some things might have escaped me. Ignore most of the strings tho

