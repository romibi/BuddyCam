package ch.romibi.minecraft.buddycam.data;

import java.io.File;
import java.util.List;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import ch.romibi.minecraft.buddycam.cam.*;

@Root
public class Data {
	private File file;
	
	@ElementList
	public List<Cam> screens; //TODO: not list -> map
	
	private Data() {
	}
	
	private Data(File file) {
		this.file = file;
	}
	
	public static Data load(File file) {
		Serializer serializer = new Persister();
		try {
			Data data = serializer.read(Data.class, file);
			data.file = file;
			return data;
		} catch (Exception e) {
			return new Data(file);
		}
	}
	
	public void save() {
		Serializer serializer = new Persister();
		try {
			serializer.write(this, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
