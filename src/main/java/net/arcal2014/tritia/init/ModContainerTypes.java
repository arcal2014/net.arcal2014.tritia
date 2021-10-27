package net.arcal2014.tritia.init;

import net.arcal2014.tritia.block.infuser.InfuserContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.IContainerFactory;

public class ModContainerTypes {

    public static final RegistryObject<ContainerType<InfuserContainer>> INFUSER = register("infuser", InfuserContainer::new);

    private static <T extends Container> RegistryObject<ContainerType<T>> register(String id, IContainerFactory<T> factory) {
        return Registration.CONTAINERS.register(id, () -> IForgeContainerType.create(factory));
    }

    static void registers() {
    }
}
