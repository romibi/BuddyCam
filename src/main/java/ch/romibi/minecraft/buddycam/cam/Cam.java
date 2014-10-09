package ch.romibi.minecraft.buddycam.cam;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Cam {
	
	@Element
	public boolean enabled = true;
	
	public void getImage() {
		//TODO: return texture
	}
	
	public void updateImage() {
		//TODO: (re)render View
	}
}
