package net.steve.expandedsurvival.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.steve.expandedsurvival.ExpandedSurvival;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(ExpandedSurvival.MODID, "overworld"), 5));
    }
}