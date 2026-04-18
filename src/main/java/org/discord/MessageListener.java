package org.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        if (event.getMessage().getContentRaw().equalsIgnoreCase("!hallo")) {
            event.getChannel().sendMessage("Hallo " + event.getAuthor().getName() + "!").queue();
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("!witz")) {
            event.getChannel().sendMessage("So I was on discord and this guy tells me: \nI have an 11 kill streak. \n" +
                    "So i asked on wich game? \nHe said, no I don't play games, I'm a police officer.").queue();
        }
    }
}
