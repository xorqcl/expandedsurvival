package net.steve.expandedsurvival.init;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.steve.expandedsurvival.ExpandedSurvival;

public class PaintingInit {

    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, ExpandedSurvival.MODID);

    public static final RegistryObject<PaintingVariant> DARKSOULS = PAINTINGS.register("darksouls", () -> new PaintingVariant(32, 32));

    public static final RegistryObject<PaintingVariant> JACOB = PAINTINGS.register("jacob", () -> new PaintingVariant(64, 48));

}
