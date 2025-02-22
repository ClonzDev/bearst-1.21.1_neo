package com.clonz.bearst.init;

import com.clonz.bearst.BearstMod;
import com.clonz.bearst.entity.BearstEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, BearstMod.MODID);

    public static <T extends Mob> DeferredHolder<EntityType<?>, EntityType<T>> registerMob(String name, EntityType.EntityFactory<T> entity,
                                                                                           float width, float height, int primaryEggColor, int secondaryEggColor) {
        DeferredHolder<EntityType<?>, EntityType<T>> entityType = ENTITIES.register(name,
                () -> EntityType.Builder.of(entity, MobCategory.CREATURE).sized(width, height).build(name));

        return entityType;
    }

    public static final DeferredHolder<EntityType<?>, EntityType<BearstEntity>> BEARST = registerMob("bearst", BearstEntity::new,
            1f, 2.2f, 0x302219, 0xACACAC);


    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> BearstEntity.init());
    }

    @SubscribeEvent
    public static void  registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BEARST.get(), BearstEntity.createAttributes().build());
    }
}
