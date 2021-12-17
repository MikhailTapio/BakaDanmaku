package com.github.tartaricacid.bakadanmaku.event.post;


import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class SendDanmakuEvent extends Event {
    private final String message;

    public SendDanmakuEvent(String message) {
        this.message = message;
    }

    @SubscribeEvent
    public static void onSendDanmaku(SendDanmakuEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        if (player != null) {
            player.sendMessage(new TextComponent(event.getMessage()), player.getUUID());
        }
    }

    public String getMessage() {
        return message;
    }
}
