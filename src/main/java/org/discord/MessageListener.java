package org.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!hallo")) {
            event.getChannel().sendMessage("Hallo " + event.getAuthor().getName() + "!").queue();
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("!witz")) {
            event.getChannel().sendMessage("Mein Bot ist so intelligent, er antwort auf Fragen, " +
                    "die ich noch gar nicht gestellt habe.").queue();
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("!wer")) {
            event.getChannel().sendMessage("Wer gefragt hat?").queue();
        } else if (args[0].equalsIgnoreCase("!löschen")) {
            int amount = Integer.parseInt(args[1]);
            event.getChannel().getIterableHistory()
                    .takeAsync(amount)
                    .thenAccept(messages -> event.getChannel().purgeMessages(messages));
            
        }
    }
}
