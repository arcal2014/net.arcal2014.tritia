package net.arcal2014.tritia.init;

import net.arcal2014.tritia.Tritia;
import net.arcal2014.tritia.world.features.OreFeature;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS;
    public static final DeferredRegister<Item> ITEMS;
    public static final DeferredRegister<ContainerType<?>> CONTAINERS;
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES;
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS;

    static {
        BLOCKS = create(ForgeRegistries.BLOCKS);
        ITEMS = create(ForgeRegistries.ITEMS);
        CONTAINERS = create(ForgeRegistries.CONTAINERS);
        TILE_ENTITIES = create(ForgeRegistries.TILE_ENTITIES);
        RECIPE_SERIALIZERS = create(ForgeRegistries.RECIPE_SERIALIZERS);
    }

    public static void register() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        CONTAINERS.register(bus);
        TILE_ENTITIES.register(bus);
        RECIPE_SERIALIZERS.register(bus);

        ModItems.register();
        ModBlocks.register();
        ModTileEntityTypes.register();
        ModContainerTypes.registers();
        ModRecipes.register();


        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreFeature::addOres);
    }

    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, Tritia.MOD_ID);
    }

    @OnlyIn(Dist.CLIENT)
    @Mod.EventBusSubscriber(modid = Tritia.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Client {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModScreenTypes.registerScreens(event);
        }

    }


}
