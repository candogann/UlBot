package com.github.candogann09.anniversarybot.Listeners;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {

    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        // @TODO: Private Mesajlarla normal mesajları ayır
    }
}
