package net.arcal2014.tritia.util.block;

import net.minecraft.block.Block;

public class ModStorageBlock extends Block {
    private final int harvestLevel;

    public ModStorageBlock(Properties properties) {
        super(properties);
        this.harvestLevel = properties.getHarvestLevel();
    }

}
