package ch.romibi.minecraft.buddycam.helper;

import net.minecraft.client.Minecraft;

import ch.romibi.minecraft.buddycam.data.SimpleTuple;

public class Calculators {

	private static Minecraft mc = Minecraft.getMinecraft();
	
	public static SimpleTuple<Integer, Integer> scaledResolution() {
		return scaledResolution(mc.gameSettings.guiScale);
	}
	
	private static SimpleTuple<Integer, Integer> scaledResolution(int scaleFactor) {
		SimpleTuple<Integer, Integer> guiRes = new SimpleTuple<Integer, Integer>(mc.displayWidth, mc.displayHeight);
		
		int i = scaleFactor;
		scaleFactor = 1;

		if (i == 0) {
			i = 1000;
		}

		for (; scaleFactor < i && guiRes.x / (scaleFactor + 1) >= 320 && guiRes.y / (scaleFactor + 1) >= 240; scaleFactor++) {
		}

		guiRes.x = (int) ((double) guiRes.x / (double) scaleFactor);
		guiRes.y = (int) ((double) guiRes.y / (double) scaleFactor);
		return guiRes;
	}
}
