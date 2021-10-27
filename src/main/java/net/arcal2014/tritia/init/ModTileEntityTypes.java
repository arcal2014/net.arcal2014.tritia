package net.arcal2014.tritia.init;

import net.arcal2014.tritia.block.infuser.InfuserTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModTileEntityTypes {

    public static final RegistryObject<TileEntityType<InfuserTileEntity>> INFUSER_TILE;

    static {
        INFUSER_TILE = register("infuser",
                InfuserTileEntity::new,
                () -> new Block[]{ModBlocks.INFUSER.get()});
    }


    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String id, Supplier<T> factoryIn, Supplier<Block[]> validBlocksSupplier)
    {
        return Registration.TILE_ENTITIES.register(id, () -> TileEntityType.Builder.of(factoryIn, validBlocksSupplier.get()).build(null));
    }

    static void register() {
    }
}
