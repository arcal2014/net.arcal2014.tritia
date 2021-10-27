package net.arcal2014.tritia.data;

import net.arcal2014.tritia.init.ModTags;
import net.arcal2014.tritia.Tritia;
import net.arcal2014.tritia.init.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator gen,  ExistingFileHelper existingFileHelper) {
        super(gen, Tritia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.BlockTags.ORES_TRITIA).add(ModBlocks.TRITIA_ORE.get()).add(ModBlocks.TRITIA_NETHER_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.BlockTags.ORES_TRITIA);

        tag(ModTags.BlockTags.STORAGE_BLOCKS_TRITIA).add(ModBlocks.TRITIA_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.BlockTags.STORAGE_BLOCKS_TRITIA);
    }
}
