package net.arcal2014.tritia.data;

import net.arcal2014.tritia.Tritia;
import net.arcal2014.tritia.init.ModItems;
import net.arcal2014.tritia.init.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(gen, blockTagsProvider, Tritia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //Copy block tags to item tags
        copy(ModTags.BlockTags.ORES_TRITIA, ModTags.ItemTags.ORES_TRITIA);
        copy(ModTags.BlockTags.STORAGE_BLOCKS_TRITIA, ModTags.ItemTags.STORAGE_BLOCKS_TRITIA);
        //Item tags
        tag(ModTags.ItemTags.GEMS_TRITIA).add(ModItems.TRITIA.get());
        tag(Tags.Items.GEMS).addTag(ModTags.ItemTags.GEMS_TRITIA);

        tag(ModTags.ItemTags.INGOTS_TRITIA).add(ModItems.TRITIA_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.ItemTags.INGOTS_TRITIA);

        tag(ModTags.ItemTags.DUSTS_TRITIA).add(ModItems.TRITIA_DUST.get());
        tag(Tags.Items.DUSTS).addTag(ModTags.ItemTags.DUSTS_TRITIA);

        tag(ModTags.ItemTags.NUGGETS_TRITIA).add(ModItems.TRITIA_NUGGET.get());
        tag(Tags.Items.NUGGETS).addTag(ModTags.ItemTags.NUGGETS_TRITIA);

    }
}
