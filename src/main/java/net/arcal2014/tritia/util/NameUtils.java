package net.arcal2014.tritia.util;

import com.google.common.base.Preconditions;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public class NameUtils {

    public static ResourceLocation checkNotNull(@Nullable ResourceLocation name) {
        Preconditions.checkNotNull(name, "Name is null");
        return name;
    }

    public static ResourceLocation from(IForgeRegistryEntry<?> entry) {
        return checkNotNull(entry.getRegistryName());
    }

}
