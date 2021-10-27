package net.arcal2014.tritia.data.client;

import net.arcal2014.tritia.Tritia;
import net.arcal2014.tritia.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Tritia.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.TRITIA_BLOCK.get());

        simpleBlock(ModBlocks.TRITIA_ORE.get());

        simpleBlock(ModBlocks.TRITIA_NETHER_ORE.get());
    }
}
