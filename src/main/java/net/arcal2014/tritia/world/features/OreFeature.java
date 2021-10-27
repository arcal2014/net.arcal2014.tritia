package net.arcal2014.tritia.world.features;

import net.arcal2014.tritia.util.config.OresConfig;
import net.arcal2014.tritia.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreFeature {

    public static void addOres(final BiomeLoadingEvent event) {
        overWorldOres(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.TRITIA_ORE.get().defaultBlockState(), OresConfig.trita_vein_size.get(), 0, 60, OresConfig.tritia_amount.get());
        dimensionalOres(event, OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.TRITIA_NETHER_ORE.get().defaultBlockState(),OresConfig.nether_tritia_vein_size.get(), 0, 120, 6);
    }

    public static void overWorldOres(final BiomeLoadingEvent event, RuleTest rule, BlockState state,int veinSize, int minHeight, int maxHeight, int amount) {
        if(!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))) {
            event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.configured(new OreFeatureConfig(rule, state, veinSize))
                            .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight))).squared().count(amount));

        }
    }

    public static void dimensionalOres(final BiomeLoadingEvent event, RuleTest rule, BlockState state, int veinSize, int minHeight, int maxHeight, int amount) {
        if((event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))) {
            event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.configured(new OreFeatureConfig(rule, state, veinSize))
                            .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight))).squared().count(amount));
        }
    }
}
