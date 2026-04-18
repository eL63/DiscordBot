package org.discord;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Main {
    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault(Config.getToken());
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        builder.addEventListeners(new MessageListener());
        builder.build();
    }
}
