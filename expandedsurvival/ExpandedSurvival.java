package net.steve.expandedsurvival;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.steve.expandedsurvival.fluid.ModFluidTypes;
import net.steve.expandedsurvival.fluid.ModFluids;
import net.steve.expandedsurvival.init.BlockEntityInit;
import net.steve.expandedsurvival.init.BlockInit;
import net.steve.expandedsurvival.init.ItemInit;
import net.steve.expandedsurvival.init.PaintingInit;
import net.steve.expandedsurvival.networking.ModMessages;
import net.steve.expandedsurvival.recipe.ModRecipes;
import net.steve.expandedsurvival.screen.ModMenuTypes;
import net.steve.expandedsurvival.screen.renderer.FluidTankRenderer;
import net.steve.expandedsurvival.villager.ModVillagers;
import net.steve.expandedsurvival.worldgen.biome.ModTerrablender;
import net.steve.expandedsurvival.worldgen.biome.surface.ModSurfaceRules;
import org.jetbrains.annotations.NotNull;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExpandedSurvival.MODID)
public class ExpandedSurvival {
    public static final String MODID = "expandedsurvival";

    public ExpandedSurvival() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        PaintingInit.PAINTINGS.register(bus);
        BlockEntityInit.BLOCK_ENTITIES.register(bus);
        ModMenuTypes.MENUS.register(bus);
        ModRecipes.SERIALIZERS.register(bus);
        ModMessages.register();
        ModFluids.FLUIDS.register(bus);
        ModFluids.FLUID_TYPES.register(bus);
        ModVillagers.register(bus);
        ModCreativeModTabs.register(bus);

        ModTerrablender.registerBiomes();


        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::commonSetup);

        System.out.println("Who are you looking at?");

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemInit.PLATAXE);
        }
    }

     @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockInit.CARNATION.getId(), BlockInit.CARNATION_FLOWER_POT);

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeRules());
        });

        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }


}

