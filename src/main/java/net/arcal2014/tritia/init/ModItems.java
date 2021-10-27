package net.arcal2014.tritia.init;

import net.arcal2014.tritia.item.crafting.MortarAndPestle;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final RegistryObject<Item> TRITIA;

    public static final RegistryObject<Item> TRITIA_NUGGET;

    public static final RegistryObject<Item> TRITIA_INGOT;

    public static final RegistryObject<Item> TRITIA_DUST;

    public static final RegistryObject<Item> INFUSED_IRON_INGOT;

    public static final RegistryObject<Item> IRON_TRITIA_INFUSING_MIXTURE;

    public static final RegistryObject<Item> MORTAR_AND_PESTLE;

    static {
        //Raw ores and gems
        TRITIA = registryItem("tritia", ModItems::simpleItem);
        //Ingots
        TRITIA_INGOT = registryItem("tritia_ingot", ModItems::simpleItem);
        //Nuggets
        TRITIA_NUGGET = registryItem("tritia_nugget", ModItems::simpleItem);
        //Dusts
        TRITIA_DUST = registryItem("tritia_dust", ModItems::simpleItem);
        //Infused things
        INFUSED_IRON_INGOT = registryItem("iron_infused_ingot", ModItems::simpleItem);
        //Infusing mixtures
        IRON_TRITIA_INFUSING_MIXTURE = registryItem("iron_tritia_mixture", ModItems::simpleItem);
        //Crafting Items
        MORTAR_AND_PESTLE = registryItem("mortar_and_pestle", () ->
                new MortarAndPestle(new Item.Properties().tab(ItemGroup.TAB_MISC).durability(64)));
    }

    private static <T extends Item> RegistryObject<T> registryItem(String id, Supplier<T> item) {
        return Registration.ITEMS.register(id, item);
    }

    private static Item simpleItem() {
        return new Item(new Item.Properties().tab(ItemGroup.TAB_MISC));
    }

    static void register() {
    }
}
