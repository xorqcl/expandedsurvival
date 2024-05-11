package net.steve.expandedsurvival.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.steve.expandedsurvival.ExpandedSurvival;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ExpandedSurvival.MODID);

    public static final RegistryObject<RecipeSerializer<AlloyRecipe>> ALLOY_SERIALIZER =
            SERIALIZERS.register("alloying", () -> AlloyRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<AlchemyRecipe>> ALCHEMY_SERIALIZER =
            SERIALIZERS.register("alchemy", () -> AlchemyRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
