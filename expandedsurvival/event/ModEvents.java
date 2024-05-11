package net.steve.expandedsurvival.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.steve.expandedsurvival.ExpandedSurvival;
import net.steve.expandedsurvival.fluid.ModFluids;
import net.steve.expandedsurvival.init.BlockInit;
import net.steve.expandedsurvival.init.ItemInit;
import net.steve.expandedsurvival.villager.ModVillagers;

import java.util.List;

public class ModEvents {



    @Mod.EventBusSubscriber(modid = ExpandedSurvival.MODID)
    public class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            if (event.getType() == ModVillagers.ALCHEMIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.EXPERIENCE_BOTTLE, 1);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3),
                        stack, 12, 12, 0.02F));
            }

            if (event.getType() == ModVillagers.ALCHEMIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.BUCKET, 1

                );
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        stack, 15, 5, 0.02F));
            }

            if (event.getType() == ModVillagers.ALCHEMIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ItemInit.BLUEBERRY_SEEDS.get(), 1);
                int villagerLevel = 2;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 2),
                        stack, 20, 2, 0.02F));
            }

            if (event.getType() == ModVillagers.ALCHEMIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModFluids.SHIMMER_FLUID.bucket.get(), 1);
                int villagerLevel = 2;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 12),
                        stack, 10, 15, 0.02F));
            }

            if (event.getType() == ModVillagers.ALCHEMIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ItemInit.LIGHTNINGROD.get(), 1);
                int villagerLevel = 4;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 2),
                        stack, 35, 7, 0.02F));
            }

            if (event.getType() == ModVillagers.ALCHEMIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.DRAGON_BREATH, 2);
                int villagerLevel = 3;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        stack, 25, 5, 0.02F));
            }

            if (event.getType() == ModVillagers.ALCHEMIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.DRAGON_HEAD, 1);
                int villagerLevel = 3;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 15),
                        stack, 4, 9, 0.02F));
            }
            if (event.getType() == ModVillagers.ALCHEMIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(BlockInit.ALCHEMYSTAND.get(), 1);
                int villagerLevel = 4;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.DIAMOND, 12),
                        stack, 3, 20, 0.03F));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = ExpandedSurvival.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventsBusEvents {

    }
}