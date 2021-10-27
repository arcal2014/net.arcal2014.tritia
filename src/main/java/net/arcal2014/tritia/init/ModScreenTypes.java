package net.arcal2014.tritia.init;

import net.arcal2014.tritia.block.infuser.InfuserScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModScreenTypes {
    @OnlyIn(Dist.CLIENT)
    public static void registerScreens(FMLClientSetupEvent event) {
        ScreenManager.register(ModContainerTypes.INFUSER.get(), InfuserScreen::new);
    }
}
