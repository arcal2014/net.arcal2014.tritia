package net.arcal2014.tritia.init;

import net.arcal2014.tritia.util.config.OresConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {

    public static void registerConfig() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OresConfig.SPEC, "Tritia-Mechanisms-OresConfig.toml");
    }
}
