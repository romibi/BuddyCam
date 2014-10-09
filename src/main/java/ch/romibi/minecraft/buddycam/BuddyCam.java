package ch.romibi.minecraft.buddycam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ch.romibi.minecraft.buddycam.cam.Cam;
import ch.romibi.minecraft.buddycam.data.Data;
import ch.romibi.minecraft.buddycam.gui.Screen;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid=BuddyCam.MODID, name="BuddyCam", version=BuddyCam.VERSION)
@SideOnly(Side.CLIENT)
public class BuddyCam {
	/* Mod-Info */
	public static final String MODID = "buddycam";
    public static final String VERSION = "1.7.10 a";
    
    /* Debug code */
    public static final boolean DEBUG = true;
    public Screen debugscreen = new Screen();
    
    /* Data & Config */
    public Configuration config;
    public Data data;
    
    @Instance(MODID)
	public static BuddyCam instance;
    
    /**
     * Loads config and saved data on Minecraft start
     * @param event
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	config = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + "/"+MODID+".cfg"));
    	config.load();
    	data = Data.load(new File(event.getModConfigurationDirectory().getAbsolutePath()+"/"+MODID+".xml"));
    }
    
    /**
     * Registers MODID for events
     * @param event
     */
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(instance);
    }
    
    /**
     * Renders things to render
     * @param event
     */
    @SubscribeEvent(priority=EventPriority.LOWEST)
	public void onRender(RenderGameOverlayEvent.Post event)
	{
    	renderScreens();
    }

    /**
     * Calls render() on each Cam in data.screens
     */
	private void renderScreens() {
		if(DEBUG) debugscreen.render();
		if(data.screens==null) return;
		for(Screen screen : data.screens) {
			screen.render();
		}
	}
    
    //TODO: Keyboard-Event -> Menu
}
