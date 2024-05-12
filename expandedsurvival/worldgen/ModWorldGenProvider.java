package net.steve.expandedsurvival.worldgen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.steve.expandedsurvival.ExpandedSurvival;
import net.steve.expandedsurvival.worldgen.biome.BiomeInit;
import net.steve.expandedsurvival.worldgen.dimension.DimensionInit;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, DimensionInit::bootstrapType)


            .add(Registries.BIOME, BiomeInit::boostrap)

            .add(Registries.LEVEL_STEM, DimensionInit::bootstrapStem);


    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ExpandedSurvival.MODID));
    }
}