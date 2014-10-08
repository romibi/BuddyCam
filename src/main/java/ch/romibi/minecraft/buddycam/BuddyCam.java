package ch.romibi.minecraft.buddycam;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid=BuddyCam.MODID, name="BuddyCam", version=BuddyCam.VERSION)
public class BuddyCam {
	public static final String MODID = "buddycam";
    public static final String VERSION = "1.7.10 a";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		System.out.println("Buddycam initialized");
    }
}
