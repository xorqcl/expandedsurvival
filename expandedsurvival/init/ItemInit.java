package net.steve.expandedsurvival.init;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.steve.expandedsurvival.ExpandedSurvival;
import net.steve.expandedsurvival.base.ModArmorMaterial;
import net.steve.expandedsurvival.item.DartItem;
import net.steve.expandedsurvival.item.EBallItem;
import net.steve.expandedsurvival.item.LightningRodItem;

public class ItemInit {



    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExpandedSurvival.MODID);

    public static final RegistryObject<Item> ROCK = ITEMS.register("rock", () -> new SnowballItem((new Item.Properties()).stacksTo(16)));

    public static final RegistryObject<Item> RAWPLATINUM = ITEMS.register("rawplatinum", () -> new Item((new Item.Properties())));


    public static final RegistryObject<Item> PLATINUMINGOT = ITEMS.register("platinumingot", () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> BRONZEINGOT = ITEMS.register("bronzeingot", () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> RAWTIN = ITEMS.register("rawtin", () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> TININGOT = ITEMS.register("tiningot", () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> CARBONSTEELINGOT = ITEMS.register("carbonsteelingot", () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> DART = ITEMS.register("dart", () -> new DartItem((new Item.Properties()).stacksTo(8)));


    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds", () -> new ItemNameBlockItem(BlockInit.BLUEBERRY_CROP.get(),
            new Item.Properties()));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", () -> new Item((new Item.Properties()).food(new FoodProperties.Builder().nutrition(2).saturationMod(2).build())));


    public static final RegistryObject<Item> LIGHTNINGROD = ITEMS.register("lightningrod", () -> new LightningRodItem((new Item.Properties()).rarity(Rarity.UNCOMMON).stacksTo(16)));

    public static final RegistryObject<Item> EBALL = ITEMS.register("eball", () -> new EBallItem((new Item.Properties()).rarity(Rarity.RARE).stacksTo(16)));




    //public static final RegistryObject<Item> SHIMMER_BUCKET = ITEMS.register("shimmer_bucket",
            //() -> new BucketItem(ModFluids.SOURCE_SHIMMER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    //public static final RegistryObject<BlockItem> LIMESTONE_ITEM = ITEMS.register("limestone", () -> new BlockItem(BlockInit.LIMESTONE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    /**
    public static final RegistryObject<Item> BUCKETOFOIL = ITEMS.register("bucketofoil", () -> new Item(props().stacksTo(1)) {
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 2400;
        }
    });

     **/


    private static Item.Properties props() {
        return new Item.Properties();

    }

    public static final RegistryObject<SwordItem> PLATSWORD = ITEMS.register("platsword",
            () -> new SwordItem(ToolTiers.PLAT, 5, 3.5f, props()));
    public static final RegistryObject<PickaxeItem> PLATPICK = ITEMS.register("platpick",
            () -> new PickaxeItem(ToolTiers.PLAT, 4, 3.5f, props()));
    public static final RegistryObject<ShovelItem> PLATSHOVEL = ITEMS.register("platshovel",
            () -> new ShovelItem(ToolTiers.PLAT, 3, 3.5f, props()));
    public static final RegistryObject<AxeItem> PLATAXE = ITEMS.register("plataxe",
            () -> new AxeItem(ToolTiers.PLAT, 7, 3.5f, props()));
    public static final RegistryObject<HoeItem> PLATHOE = ITEMS.register("plathoe",
            () -> new HoeItem(ToolTiers.PLAT, 1, 3.5f, props()));

    public static final RegistryObject<ArmorItem> PLATHELMET = ITEMS.register("platinumhelmet",
            () -> new ArmorItem(ArmorTiers.PLAT, ArmorItem.Type.HELMET, props()));
    public static final RegistryObject<ArmorItem> PLATCHESTPLATE = ITEMS.register("platinumchestplate",
            () -> new ArmorItem(ArmorTiers.PLAT, ArmorItem.Type.CHESTPLATE, props()));
    public static final RegistryObject<ArmorItem> PLATLEGGINGS = ITEMS.register("platinumleggings",
            () -> new ArmorItem(ArmorTiers.PLAT, ArmorItem.Type.LEGGINGS, props()));
    public static final RegistryObject<ArmorItem> PLATBOOTS = ITEMS.register("platinumboots",
            () -> new ArmorItem(ArmorTiers.PLAT, ArmorItem.Type.BOOTS, props()));


    public static class ToolTiers {
        public static final Tier PLAT = new ForgeTier(
                3,
                900,
                1.4f,
                3,
                400,
                BlockInit.Tags.NEEDS_PLATINUM_TOOL,
                () -> Ingredient.of(ItemInit.PLATINUMINGOT.get()));
    }


    public static class ArmorTiers {
        public static final ArmorMaterial PLAT = new ModArmorMaterial(
                "platinum",
                500,
                new int[] { 3, 7, 8, 4 },
                250,
                SoundEvents.CHAIN_PLACE,
                2.5f,
                0.05f,
                () -> Ingredient.of(ItemInit.PLATINUMINGOT.get()));
    }


}

