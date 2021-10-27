package net.arcal2014.tritia;

import net.arcal2014.tritia.init.Config;
import net.arcal2014.tritia.init.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Tritia.MOD_ID)
public class Tritia {
    private static final Logger LOGGER = LogManager.getLogger();

    
    public static final String MOD_ID = "tritia";
    public Tritia() {
        MinecraftForge.EVENT_BUS.register(this);
        Registration.register();
        Config.registerConfig();
    }
}
