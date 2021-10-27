package net.arcal2014.tritia.util.block;

import net.arcal2014.tritia.init.ModBlocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class ModOreBlock extends OreBlock {
    private final int harvestLevel;

    public ModOreBlock(Properties properties) {
        super(properties);
        this.harvestLevel = properties.getHarvestLevel();
    }

    @Override
    protected int xpOnDrop(Random xp) {
        if(this == ModBlocks.TRITIA_ORE.get()) {
            return MathHelper.nextInt(xp, 1, 3);
        }
        return super.xpOnDrop(xp);
    }
}
