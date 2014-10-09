package ch.romibi.minecraft.buddycam.gui;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import ch.romibi.minecraft.buddycam.helper.Calculators;

import ch.romibi.minecraft.buddycam.data.ResolutionType;
import static ch.romibi.minecraft.buddycam.data.ResolutionType.*;
import static ch.romibi.minecraft.buddycam.helper.GLHelper.*;

import org.lwjgl.*;
import org.lwjgl.opengl.GL11;

@Root
public class Screen {
	
	@Element
	public float posXProcent = 0.68F; // %
	@Element
	public float posYProcent = 0.60F; // %
	@Element
	public float widthProcent = 0.30F; // %
	@Element
	public float heightProcent = 0.30F; // %
	
	private static Minecraft mc = Minecraft.getMinecraft();
	private static Map<Float, String> aviableScreenTextures = new HashMap<Float, String>();
	
	private ResourceLocation bgTexture;
	
	static {
		//aviableScreenTextures.put(1.33f, "buddycam:textures/screen_4_3.png");
		//aviableScreenTextures.put(1.77f, "buddycam:textures/screen_16_9.png");
		aviableScreenTextures.put(1.77f, "buddycam:textures/screen_green.png");
	}
	
	/* Different Variants of Width and Height */
	
	/**
	 * @return the width in Pixel of the screen
	 */
	private int getWidth() {
		return getWidth(NORMAL_RES);
	}
	
	/**
	 * Returns the width of the screen scaled to Gui-Resolution or in normal Resolution as Pixel based on the asked resolutionType
	 * @param resolutionType NORMAL or GUI
	 * @return width in Pixel
	 */
	private int getWidth(ResolutionType resolutionType) {
		switch (resolutionType) {
		case GUI_RES:
			return (int) (Calculators.scaledResolution().x*widthProcent);
		case NORMAL_RES:
		default:
			return (int) (mc.displayWidth*widthProcent);
		}
	}
	
	/**
	 * @return the height of the screen
	 */
	private int getHeight() {
		return getHeight(NORMAL_RES);
	}
	
	/**
	 * Returns the height of the screen scaled to Gui-Resolution or in normal Resolution as Pixel based on the asked resolutionType
	 * @param resolutionType NORMAL or GUI
	 * @return height in Pixel
	 */
	private int getHeight(ResolutionType resolutionType) {
		switch (resolutionType) {
		case GUI_RES:
			return (int) (Calculators.scaledResolution().y*heightProcent);
		case NORMAL_RES:
		default:
			return (int) (mc.displayHeight*heightProcent);
		}
	}
	
	/**
	 * @return the X-Postion of the screen in Pixel
	 */
	private int getPosX() {
		return getPosX(NORMAL_RES);
	}
	
	/**
	 * Returns the X-Position of the screen scaled to Gui-Resolution or in normal Resolution as Pixel based on the asked resolionType
	 * @param resolutionType NORMAL or GUI
	 * @return X-Position in Pixel
	 */
	private int getPosX(ResolutionType resolutionType) {
		switch (resolutionType) {
		case GUI_RES:
			return (int) (Calculators.scaledResolution().x*posXProcent);
		case NORMAL_RES:
		default:
			return (int) (mc.displayWidth*posXProcent);
		}
	}
	
	/**
	 * @return the Y-Position of the screen in Pixel
	 */
	private int getPosY() {
		return getPosY(NORMAL_RES);
	}
	
	/**
	 * Returns the Y-Position of the screen scaled to Gui-Resolution or in normal Resolution as Pixel based on the asked resolionType
	 * @param resolutionType NORMAL or GUI
	 * @return Y-Position in Pixel
	 */
	private int getPosY(ResolutionType resolutionType) {
		switch (resolutionType) {
		case GUI_RES:
			return (int) (Calculators.scaledResolution().y*posYProcent);
		case NORMAL_RES:
		default:
			return (int) (mc.displayHeight*posYProcent);
		}
	}
	
	/* Other things */
	
	private ResourceLocation getBestScreenTexture() {
		float screenratio = (float)getWidth()/getHeight();
		float currentDistance = 9999.9f;
		String currentValue = null;
		for (Float currentRatio : aviableScreenTextures.keySet()) {
			if(currentDistance == 9999.9f || Math.abs((float)currentRatio - screenratio) < currentDistance) {
				currentDistance = Math.abs((float)currentRatio - screenratio);
				currentValue = aviableScreenTextures.get(currentRatio);
			}
		}
		return new ResourceLocation(currentValue);
	}
	
	/* Rendering Code */
	
	/**
	 * renders screen-background, screen-title and screen-image
	 */
	public void render() {
		renderBackground();
		renderTitle();
		renderImage();
	}

	/**
	 * renders screen-background
	 */
	private void renderBackground() {
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		if(bgTexture==null) bgTexture = getBestScreenTexture();
		mc.renderEngine.bindTexture(bgTexture);
		GL11.glColor4f(0.5f,0.5f,0.5f,0.5f);
		drawTexturedModalRect(getPosX(GUI_RES), getPosY(GUI_RES), getWidth(GUI_RES), getHeight(GUI_RES));
		//GL11.glDisable(GL11.GL_ALPHA_TEST);
	}

	/**
	 * renders screen-title
	 */
	private void renderTitle() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * renders screen-image
	 */
	private void renderImage() {
		// TODO Auto-generated method stub
		
	}
}
