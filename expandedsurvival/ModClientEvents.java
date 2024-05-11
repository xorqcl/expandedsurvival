package net.steve.expandedsurvival;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import net.steve.expandedsurvival.init.BlockEntityInit;
import net.steve.expandedsurvival.init.BlockInit;
import net.steve.expandedsurvival.init.ItemInit;
import net.steve.expandedsurvival.screen.AlchemyStandMenu;
import net.steve.expandedsurvival.screen.AlchemyStandScreen;
import net.steve.expandedsurvival.screen.AlloyScreen;
import net.steve.expandedsurvival.screen.ModMenuTypes;
import net.steve.expandedsurvival.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = ExpandedSurvival.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
     //   ItemBlockRenderTypes.setRenderLayer(BlockInit.CARNATION.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.ALLOY_MENU.get(), AlloyScreen::new);
        MenuScreens.register(ModMenuTypes.ALCHEMYSTAND_MENU.get(), AlchemyStandScreen::new);

    }



}
