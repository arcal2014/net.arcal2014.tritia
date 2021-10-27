package net.arcal2014.tritia.init;

import net.arcal2014.tritia.item.crafting.recipe.InfusingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModRecipes {
    public static class types {
        public static final IRecipeType<InfusingRecipe> INFUSING;

        static {
            INFUSING = IRecipeType.register("infusing");
        }
    }

    public static class Serializers {
        public static final RegistryObject<IRecipeSerializer<InfusingRecipe>> INFUSING;

        static {
            INFUSING = register("infusing", InfusingRecipe.Serializer::new);
        }

        private static <T extends IRecipe<?>>RegistryObject<IRecipeSerializer<T>> register(String name, Supplier<IRecipeSerializer<T>> serializer) {
            return Registration.RECIPE_SERIALIZERS.register(name, serializer);
        }
    }


    static void register() {
    }
}
