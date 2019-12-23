# AiborosBot
This is a simple telegram bot.

It's usage and construction are quite simple.

I'm using it to learn and test ou new coding patterns.

To run this bot, simply set an Environment Variable called API_KEY and set
the value to your bot API Key.

The Bot is not set on webhook, instead it pulls updates every 10 seconds. You can change this
on the UpdatePollingScheduler class.

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

<h3>Command List</h3>
<table>
<thead>
</thead>
<tbody>
<tr>
<td>/roll</td>
<td>"Rolls" a die or dice. Basically it picks a random under the given input<br>
The syntax is as follows: <br>
/roll d10 --Rolls a single ten-sided die.<br>
/roll 2d10 --Rolls 2 ten-sided dice.<br>
/roll 2d10 3d6 2d2 --Rolls 2 ten-sided dice, 3 six-sided dice, 2 two-sided dice<br>
You can add as many as you want</td>
</tr>
<tr>
<td>/toad</td>
<td>
Mandatory shitposting command.<br>
This picks a random song sang by toad out of youtube (I have some files downloaded, you can find them under the resources folder)<br>
And seds them as an audio message. You can also use this as example to send your audio files.</td>
</tr>
<tr>
<td>/pau</td>
<td>
This is a joke with the word that this translates to. It can be translated into "cock". All this does is to send a random
<br>picture of a cock. (of course, we are talking about the "male chicken")
</td>
</tr>
<tr>
<td>/test</td>
<td>
Used for general testing purposes</td>
</tr>
</tbody>
</table>