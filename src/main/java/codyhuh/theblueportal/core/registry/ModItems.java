package codyhuh.theblueportal.core.registry;

import codyhuh.theblueportal.core.TheBluePortal;
import codyhuh.theblueportal.core.common.items.TBPBucketItem;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheBluePortal.MOD_ID);

    // LEAF EEL
    public static final RegistryObject<Item> LEAF_EEL_SPAWN_EGG = ITEMS.register("leaf_eel_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.LEAF_EEL, 0x3a623e, 0xb7d4a4, new Item.Properties()));
    public static final RegistryObject<Item> LEAF_EEL_BUCKET = ITEMS.register("leaf_eel_bucket", () -> new TBPBucketItem(ModEntities.LEAF_EEL, true));
    public static final RegistryObject<Item> LEAF_EEL = ITEMS.register("leaf_eel", () -> new Item(new Item.Properties().food(Foods.COD)));
    public static final RegistryObject<Item> COOKED_LEAF_EEL = ITEMS.register("cooked_leaf_eel", () -> new Item(new Item.Properties().food(Foods.COOKED_COD)));
}

