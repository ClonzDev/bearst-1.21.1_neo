package com.clonz.bearst.init;

import com.clonz.bearst.BearstMod;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BearstMod.MODID);

    public static final DeferredItem<Item> BEARST_SPAWN_EGG = ITEMS.register("bearst_spawn_egg",
            () -> new DeferredSpawnEggItem((Supplier)ModEntities.BEARST, 0x7c908b, 0xffb122, new Item.Properties()));
}
