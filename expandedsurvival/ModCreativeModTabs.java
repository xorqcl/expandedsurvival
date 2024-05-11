package net.steve.expandedsurvival;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.steve.expandedsurvival.fluid.ModFluids;
import net.steve.expandedsurvival.init.BlockInit;
import net.steve.expandedsurvival.init.ItemInit;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExpandedSurvival.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("expandedsurvival_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.LIGHTNINGROD.get()))
                    .title(Component.translatable("creativetab.expandedsurvival_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(BlockInit.ALLOY.get());
                        pOutput.accept(BlockInit.LIMESTONE.get());
                        pOutput.accept(BlockInit.ALCHEMYSTAND.get());
                        pOutput.accept(BlockInit.PLATINUMORE.get());
                        pOutput.accept(BlockInit.TINORE.get());
                        pOutput.accept(BlockInit.PLATINUMORED.get());
                        pOutput.accept(BlockInit.TINORED.get());
                        pOutput.accept(BlockInit.CARNATION.get());



                        pOutput.accept(ItemInit.LIGHTNINGROD.get());
                        pOutput.accept(ItemInit.ROCK.get());
                        pOutput.accept(ItemInit.RAWPLATINUM.get());
                        pOutput.accept(ItemInit.PLATINUMINGOT.get());
                        pOutput.accept(ItemInit.BRONZEINGOT.get());
                        pOutput.accept(ItemInit.RAWTIN.get());
                        pOutput.accept(ItemInit.TININGOT.get());
                        pOutput.accept(ItemInit.CARBONSTEELINGOT.get());
                        pOutput.accept(ItemInit.DART.get());
                        pOutput.accept(ItemInit.BLUEBERRY_SEEDS.get());
                        pOutput.accept(ItemInit.LIGHTNINGROD.get());
                        pOutput.accept(ItemInit.BLUEBERRY.get());
                        pOutput.accept(ItemInit.EBALL.get());
                        pOutput.accept(ItemInit.LIGHTNINGROD.get());


                        pOutput.accept(ItemInit.PLATSWORD.get());
                        pOutput.accept(ItemInit.PLATPICK.get());
                        pOutput.accept(ItemInit.PLATSHOVEL.get());
                        pOutput.accept(ItemInit.PLATAXE.get());
                        pOutput.accept(ItemInit.PLATHOE.get());
                        pOutput.accept(ItemInit.PLATHELMET.get());
                        pOutput.accept(ItemInit.PLATCHESTPLATE.get());
                        pOutput.accept(ItemInit.PLATLEGGINGS.get());
                        pOutput.accept(ItemInit.PLATBOOTS.get());


                        pOutput.accept(ModFluids.SHIMMER_FLUID.bucket.get());
                        pOutput.accept(ModFluids.OIL_FLUID.bucket.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}