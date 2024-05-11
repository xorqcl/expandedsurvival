package net.steve.expandedsurvival.init;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.steve.expandedsurvival.ExpandedSurvival;
import net.steve.expandedsurvival.block.entity.AlchemyStandBlockEntity;
import net.steve.expandedsurvival.block.entity.AlloyBlockEntity;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExpandedSurvival.MODID);

    public static final RegistryObject<BlockEntityType<AlloyBlockEntity>> ALLOY =
            BLOCK_ENTITIES.register("alloy", () ->
                    BlockEntityType.Builder.of(AlloyBlockEntity::new,
                            BlockInit.ALLOY.get()).build(null));

    public static final RegistryObject<BlockEntityType<AlchemyStandBlockEntity>> ALCHEMYSTAND =
            BLOCK_ENTITIES.register("alchemystand", () ->
                    BlockEntityType.Builder.of(AlchemyStandBlockEntity::new,
                            BlockInit.ALCHEMYSTAND.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}