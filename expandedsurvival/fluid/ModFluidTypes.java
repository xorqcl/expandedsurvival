package net.steve.expandedsurvival.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.steve.expandedsurvival.ExpandedSurvival;

public class ModFluidTypes {

    /**
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
        public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
        public static final ResourceLocation SHIMMER_OVERLAY_RL = new ResourceLocation(ExpandedSurvival.MODID, "misc/in_shimmer");

        public static final DeferredRegister<FluidType> FLUID_TYPES =
                DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ExpandedSurvival.MODID);


        public static final RegistryObject<FluidType> SHIMMER_FLUID_TYPE = register("shimmer_fluid",
                FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                        SoundEvents.HONEY_DRINK));



        private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
            return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, SHIMMER_OVERLAY_RL,
                    0xE2A8EA, new Vector3f(226f / 255f, 168f / 255f, 234f / 255f), properties));
        }

        public static void register(IEventBus eventBus) {
            FLUID_TYPES.register(eventBus);
        }
        **/
    }



