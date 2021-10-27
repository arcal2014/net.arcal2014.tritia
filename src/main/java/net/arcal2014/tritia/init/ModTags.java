package net.arcal2014.tritia.init;

import net.arcal2014.tritia.Tritia;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class BlockTags {
        //Block tags.
        public static final ITag.INamedTag<Block> ORES_TRITIA;
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_TRITIA;

        static {
            ORES_TRITIA = forge("ores/tritia");
            STORAGE_BLOCKS_TRITIA = forge("storage_blocks/tritias");
        }

        private static ITag.INamedTag<Block> forge(String path) {
            return net.minecraft.tags.BlockTags.createOptional(new ResourceLocation("forge", path));
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return net.minecraft.tags.BlockTags.createOptional(new ResourceLocation(Tritia.MOD_ID, path));
        }
    }

    public static final class ItemTags {
        //Blocks item tags.
        public static final ITag.INamedTag<Item> ORES_TRITIA;
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_TRITIA;
        //Item tags.
        public static final ITag.INamedTag<Item> GEMS_TRITIA;
        public static final ITag.INamedTag<Item> DUSTS_TRITIA;
        public static final ITag.INamedTag<Item> INGOTS_TRITIA;
        public static final ITag.INamedTag<Item> NUGGETS_TRITIA;

        static {
            //Block Tags.
            ORES_TRITIA = forge("ores/tritia");
            STORAGE_BLOCKS_TRITIA = forge("storage_blocks/tritia");

            //Item tags
            GEMS_TRITIA = forge("gems/tritia");
            DUSTS_TRITIA = forge("dusts/tritia");
            INGOTS_TRITIA = forge("ingots/tritia");
            NUGGETS_TRITIA = forge("nuggets/tritia");
        }

        private static ITag.INamedTag<Item> forge(String path) {
            return net.minecraft.tags.ItemTags.createOptional(new ResourceLocation("forge", path));
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return net.minecraft.tags.ItemTags.createOptional(new ResourceLocation(Tritia.MOD_ID, path));
        }
    }
}
