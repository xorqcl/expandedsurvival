package net.steve.expandedsurvival.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EBallItem extends Item {
    public EBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Right click for some words of wisdom!").withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    private void outputRandomNumber(Player player) {

        if(getRandomNumber() == 0) {
            player.sendSystemMessage(Component.literal("You have power over your mind – not outside events. Realize this, and you will find strength."));
        }
        if(getRandomNumber() == 1) {
            player.sendSystemMessage(Component.literal("If it is not right, do not do it, if it is not true, do not say it."));
        }
        if(getRandomNumber() == 2) {
            player.sendSystemMessage(Component.literal("If a man knows not which port he sails, no wind is favorable."));
        }
        if(getRandomNumber() == 3) {
            player.sendSystemMessage(Component.literal("He who fears death will never do anything worthy of a man who is alive."));
        }
        if(getRandomNumber() == 4) {
            player.sendSystemMessage(Component.literal("Opinion is the medium between knowledge and ignorance."));
        }
        if(getRandomNumber() == 5) {
            player.sendSystemMessage(Component.literal("Knowing yourself is the beginning of all wisdom."));
        }
        if(getRandomNumber() == 6) {
            player.sendSystemMessage(Component.literal("Hope is a waking dream."));
        }
        if(getRandomNumber() == 7) {
            player.sendSystemMessage(Component.literal("Your time is limited, so don't waste it living someone else's life."));
        }
        if(getRandomNumber() == 8) {
            player.sendSystemMessage(Component.literal("The unexamined life is not worth living."));
        }
        if(getRandomNumber() == 9) {
            player.sendSystemMessage(Component.literal("Entities should not be multiplied unnecessarily."));
        }

    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}