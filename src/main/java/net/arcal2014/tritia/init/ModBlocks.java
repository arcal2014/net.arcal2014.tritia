package net.arcal2014.tritia.init;

import net.arcal2014.tritia.block.infuser.InfuserBlock;
import net.arcal2014.tritia.util.block.ModOreBlock;
import net.arcal2014.tritia.util.block.ModStorageBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    //Ores.
    public static final RegistryObject<Block> TRITIA_ORE;
    public static final RegistryObject<Block> TRITIA_NETHER_ORE;
    //Storage blocks.
    public static final RegistryObject<Block> TRITIA_BLOCK;
    //Tile Entities blocks.
    public static final RegistryObject<InfuserBlock> INFUSER;

    static {
        //Ores
        TRITIA_ORE= register("tritia_ore",() -> getOre(1,SoundType.STONE));

        //Nether ores
        TRITIA_NETHER_ORE = register("tritia_nether_ore", () -> getOre(1, SoundType.NETHER_GOLD_ORE));

        //Storage blocks
        TRITIA_BLOCK  = register("tritia_block", () -> storageBlocks(1, SoundType.METAL));

        //Tile Entities blocks.
        INFUSER = register("infuser", () -> new InfuserBlock(AbstractBlock.Properties.of(Material.METAL)
                .strength(3.0f,6.0f)
                .requiresCorrectToolForDrops()
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.METAL)));
    }



    private static <T extends Block> RegistryObject<T> registerNoItem(String id, Supplier<T> block) {
        return Registration.BLOCKS.register(id, block);
    }

    private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(id, block);
        Registration.ITEMS.register(id, () -> new BlockItem(ret.get(), new Item.Properties()
                .tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        return ret;
    }

    private static OreBlock getOre(int harvestLevel, SoundType soundType) {
        return new ModOreBlock(AbstractBlock.Properties.of(Material.STONE)
                .strength(4, 10)
                .requiresCorrectToolForDrops()
                .harvestLevel(harvestLevel)
                .harvestTool(ToolType.PICKAXE)
                .sound(soundType));
    }

    private static Block storageBlocks(int harvestLevel, SoundType soundType) {
        return new ModStorageBlock(AbstractBlock.Properties.of(Material.METAL)
                .strength(3.0f,6.0f)
                .requiresCorrectToolForDrops()
                .harvestLevel(harvestLevel)
                .harvestTool(ToolType.PICKAXE)
                .sound(soundType));
    }

    static void register() {
    }
}
