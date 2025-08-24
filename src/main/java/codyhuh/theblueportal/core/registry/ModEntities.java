package codyhuh.theblueportal.core.registry;

import codyhuh.theblueportal.core.TheBluePortal;
import codyhuh.theblueportal.core.common.entities.LeafEel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheBluePortal.MOD_ID);

    public static final RegistryObject<EntityType<LeafEel>> LEAF_EEL = ENTITY_TYPES.register("leaf_eel", () -> EntityType.Builder.of(LeafEel::new, MobCategory.WATER_CREATURE).sized(1.0F, 0.25F).build("leaf_eel"));
}
