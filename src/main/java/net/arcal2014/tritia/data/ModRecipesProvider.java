package net.arcal2014.tritia.data;

import net.arcal2014.tritia.init.ModTags;
import net.arcal2014.tritia.Tritia;
import net.arcal2014.tritia.init.ModBlocks;
import net.arcal2014.tritia.init.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider {
    public ModRecipesProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        //Shapeless crafting
        ShapelessRecipeBuilder.shapeless(ModItems.TRITIA.get(), 9)
                .requires(ModBlocks.TRITIA_BLOCK.get())
                .unlockedBy("has_item", has(ModTags.ItemTags.GEMS_TRITIA)).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.TRITIA_NUGGET.get(), 9)
                .requires(ModItems.TRITIA_INGOT.get())
                .unlockedBy("has_item", has(ModTags.ItemTags.GEMS_TRITIA)).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.TRITIA_DUST.get(), 9)
                .requires(ModItems.TRITIA.get())
                .requires(ModItems.MORTAR_AND_PESTLE.get())
                .unlockedBy("has_item", has(ModTags.ItemTags.GEMS_TRITIA))
                .save(consumer);

        //Shaped crafting
        ShapedRecipeBuilder.shaped(ModBlocks.TRITIA_BLOCK.get())
                .define('#', ModItems.TRITIA.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModTags.ItemTags.GEMS_TRITIA))
                .save(consumer);

        CookingRecipeBuilder.smelting(Ingredient.of(ModItems.TRITIA.get()), ModItems.TRITIA_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ModTags.ItemTags.GEMS_TRITIA)).save(consumer, modId("tritia_ingot_smelting"));

        CookingRecipeBuilder.blasting(Ingredient.of(ModItems.TRITIA.get()), ModItems.TRITIA_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_item", has(ModTags.ItemTags.GEMS_TRITIA)).save(consumer, modId("tritia_ingot_blasting"));


    }



    private static ResourceLocation modId(String path) {
        return new ResourceLocation(Tritia.MOD_ID, path);
    }
}
