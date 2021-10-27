package net.arcal2014.tritia.item.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MortarAndPestle extends Item {
    public MortarAndPestle(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        if (container.hurt(1, random, null)) {
            return ItemStack.EMPTY;
        } else {
            return container;
        }
    }
}
