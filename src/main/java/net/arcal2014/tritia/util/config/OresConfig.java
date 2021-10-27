package net.arcal2014.tritia.util.config;

import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.tileentity.EndPortalTileEntity;
import net.minecraftforge.common.ForgeConfigSpec;

public class OresConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> trita_vein_size;
    public static final ForgeConfigSpec.ConfigValue<Integer> tritia_amount;

    public static final ForgeConfigSpec.ConfigValue<Integer> nether_tritia_amount;
    public static final ForgeConfigSpec.ConfigValue<Integer> nether_tritia_vein_size;



    static {
        BUILDER.push("Trita Mechanics ore configs");

        trita_vein_size = BUILDER.comment("vein size for the tritia ore.")
                .define("Tritia vein size", 11);
        tritia_amount = BUILDER.comment("tritia amount by chunk.")
                .define("Tritia amount", 9);

        nether_tritia_vein_size = BUILDER.comment("vein size for the nether tritia ore.")
                .define("Nether tritia vein size", 9);
        nether_tritia_amount = BUILDER.comment("nether tritia amount by chunk.")
                .define("Nether tritia amount", 7);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
