package net.steve.expandedsurvival.fluid;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.steve.expandedsurvival.ExpandedSurvival;
import net.steve.expandedsurvival.base.FluidRegistryContainer;


public class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ExpandedSurvival.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ExpandedSurvival.MODID);

    public static final FluidRegistryContainer SHIMMER_FLUID = new FluidRegistryContainer(
            "shimmer_fluid",
            FluidType.Properties.create().viscosity(5).canSwim(true).canDrown(true).canPushEntity(true).supportsBoating(true),
            () -> FluidRegistryContainer.createExtension(
                    new FluidRegistryContainer.ClientExtensions(
                            ExpandedSurvival.MODID,
                            "shimmer_fluid"
                    ).tint(0xD303FC)
                            .fogColor(0.82f, 0.011f, 0.988f)
            ),
            BlockBehaviour.Properties.copy(Blocks.LAVA),
            new Item.Properties()
                    .stacksTo(1).rarity(Rarity.RARE)
    );

    public static final FluidRegistryContainer OIL_FLUID = new FluidRegistryContainer(
            "oil_fluid",
            FluidType.Properties.create().viscosity(1).canSwim(false).canDrown(true).canPushEntity(true).supportsBoating(false),
            () -> FluidRegistryContainer.createExtension(
                    new FluidRegistryContainer.ClientExtensions(
                            ExpandedSurvival.MODID,
                            "oil_fluid"
                    ).tint(0x111212)
                            .fogColor(0.0667f, 0.0705f, 0.0705f)
            ),
            BlockBehaviour.Properties.copy(Blocks.WATER),
            new Item.Properties()
                    .stacksTo(1).rarity(Rarity.EPIC)
    );
}