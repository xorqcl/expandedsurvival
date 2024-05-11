package net.steve.expandedsurvival.item;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.steve.expandedsurvival.init.ItemInit;
import org.jetbrains.annotations.Nullable;

public class DartItem extends Item {
    public DartItem(Item.Properties p_43140_) {
        super(p_43140_);
    }

    public InteractionResultHolder<ItemStack> use(Level p_43142_, Player p_43143_, InteractionHand p_43144_) {
        ItemStack itemstack = p_43143_.getItemInHand(p_43144_);
        p_43142_.playSound((Player)null, p_43143_.getX(), p_43143_.getY(), p_43143_.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.NEUTRAL, 0.9F, 0.9F / (p_43142_.getRandom().nextFloat() * 0.7F + 0.9F));
        if (!p_43142_.isClientSide) {
            ThrownDart snowball = new ThrownDart(p_43142_, p_43143_);
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {

        if(Screen.hasShiftDown()) {
            components.add(net.minecraft.network.chat.Component.literal("Throw it at someone but it hurts!").withStyle(ChatFormatting.ITALIC));
        } else {
            components.add(net.minecraft.network.chat.Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.DARK_RED));
        }

        super.appendHoverText(stack, level, components, flag);
    }


}