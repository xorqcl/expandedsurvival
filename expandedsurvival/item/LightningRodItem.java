package net.steve.expandedsurvival.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

import static java.awt.Component.*;

public class LightningRodItem extends Item {
    public LightningRodItem(Item.Properties p_43140_) {
        super(p_43140_);
    }

    public InteractionResultHolder<ItemStack> use(Level p_43142_, Player p_43143_, InteractionHand p_43144_) {
        ItemStack itemstack = p_43143_.getItemInHand(p_43144_);
        p_43142_.playSound((Player)null, p_43143_.getX(), p_43143_.getY(), p_43143_.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 0.9F, 0.9F / (p_43142_.getRandom().nextFloat() * 0.7F + 0.9F));
        if (!p_43142_.isClientSide) {
            ThrownLightningRod snowball = new ThrownLightningRod(p_43142_, p_43143_);
            snowball.setItem(itemstack);
            snowball.shootFromRotation(p_43143_, p_43143_.getXRot(), p_43143_.getYRot(), 0.0F, 1.5F, 1.0F);
            p_43142_.addFreshEntity(snowball);
        }

        p_43143_.awardStat(Stats.ITEM_USED.get(this));
        if (!p_43143_.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, p_43142_.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<net.minecraft.network.chat.Component> components, TooltipFlag flag) {

        if(Screen.hasShiftDown()) {
            components.add(net.minecraft.network.chat.Component.literal("Lightning rod crafted from the power of Zeus").withStyle(ChatFormatting.BOLD));
        } else {
            components.add(net.minecraft.network.chat.Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.GOLD));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    
}