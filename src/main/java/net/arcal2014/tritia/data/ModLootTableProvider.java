package net.arcal2014.tritia.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.arcal2014.tritia.init.Registration;
import net.arcal2014.tritia.init.ModBlocks;
import net.arcal2014.tritia.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.*;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((id, table) -> LootTableManager.validate(validationtracker, id, table));
    }

    public static class ModBlockLootTables extends BlockLootTables {

        @Override
        protected void addTables() {
            //Drop itself
            dropSelf(ModBlocks.TRITIA_BLOCK.get());
            //Do not drop itself
            add(ModBlocks.TRITIA_ORE.get(), block ->
                    createSilkTouchDispatchTable(block, applyExplosionDecay(block, ItemLootEntry.lootTableItem(ModItems.TRITIA.get())
                            .apply(SetCount.setCount(RandomValueRange.between(3, 6)))
                            .apply(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));
            add(ModBlocks.TRITIA_NETHER_ORE.get(), block ->
                    createSilkTouchDispatchTable(block, applyExplosionDecay(block, ItemLootEntry.lootTableItem(ModItems.TRITIA.get())
                            .apply(SetCount.setCount(RandomValueRange.between(3, 6)))
                            .apply(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }
}
