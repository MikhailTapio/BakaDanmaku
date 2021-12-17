package com.github.tartaricacid.bakadanmaku.input;

import com.github.tartaricacid.bakadanmaku.utils.OpenCloseDanmaku;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;


@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ConfigKey {
    public static final KeyMapping CONFIG_KEY = new KeyMapping("key.bakadanmaku.config",
            KeyConflictContext.IN_GAME,
            KeyModifier.ALT,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_B,
            "key.category.bakadanmaku");

    @SubscribeEvent
    public static void onKeyboardInput(InputEvent.KeyInputEvent event) {
        if (CONFIG_KEY.isDown()) {
            OpenCloseDanmaku.closeDanmaku();
            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.sendMessage(new TranslatableComponent("message.bakadanmaku.config.reload"), Minecraft.getInstance().player.getUUID());
            }
            OpenCloseDanmaku.openDanmaku();
        }
    }
}
