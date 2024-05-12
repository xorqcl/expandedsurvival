package net.steve.expandedsurvival.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.steve.expandedsurvival.ExpandedSurvival;
import net.steve.expandedsurvival.block.AlchemyStandBlock;
import net.steve.expandedsurvival.block.AlloyBlock;
import net.steve.expandedsurvival.block.BlueberryCropBlock;
import net.steve.expandedsurvival.block.SkylandsPortalBlock;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;
import static net.minecraft.world.level.block.Blocks.DIAMOND_ORE;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExpandedSurvival.MODID);

    //public static final RegistryObject<Block> LIMESTONE = BLOCKS.register("limestone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_GRAY)));

    public static final RegistryObject<Block> LIMESTONE = register("limestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(0.8F)),
                  new Item.Properties());

    public static final RegistryObject<Block> ALLOY = register("alloy",
            () -> new AlloyBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_GRAY).noOcclusion().requiresCorrectToolForDrops().strength(0.8F)),
            new Item.Properties().stacksTo(1));

    public static final RegistryObject<Block> ALCHEMYSTAND = register("alchemystand",
            () -> new AlchemyStandBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_GRAY).noOcclusion().requiresCorrectToolForDrops().strength(0.8F)),
            new Item.Properties().stacksTo(1));

    public static final RegistryObject<Block> PLATINUMORE = register("platinumore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F, 3.0F)),
                  new Item.Properties());

    public static final RegistryObject<Block> PLATINUMORED = register("platinumored",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.DEEPSLATE).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)),
                  new Item.Properties());

    public static final RegistryObject<Block> TINORE = register("tinore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F, 3.0F)),
            new Item.Properties());

    public static final RegistryObject<Block> TINORED = register("tinored",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.DEEPSLATE).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)),
            new Item.Properties());

    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop",
            () -> new BlueberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).mapColor(MapColor.COLOR_BLUE)));


    public static final RegistryObject<FlowerBlock> CARNATION = register("carnation",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 300, BlockBehaviour.Properties.copy(Blocks.DANDELION)),
                  new Item.Properties());

    public static final RegistryObject<FlowerPotBlock> CARNATION_FLOWER_POT = BLOCKS.register("carnation_flower_pot",
        () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BlockInit.CARNATION, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));



    public static final RegistryObject<Block> SKYLANDSPORTALBLOCK = registerBlock("skylandsportalblock",
            () -> new SkylandsPortalBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().noLootTable()));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
       return block;
    }

    public static class Tags {
        public static final TagKey<Block> NEEDS_PLATINUM_TOOL = create("mineable/needs_platinum_tool");

        private static TagKey<Block> create(String location) {
            return BlockTags.create(new ResourceLocation(ExpandedSurvival.MODID, location));
        }
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

}
