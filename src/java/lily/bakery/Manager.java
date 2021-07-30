package bakery;

import java.io.File;

import core.basicitem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class Manager {
private String MODID;
@SuppressWarnings("unused")
final private File gamePath;
	public Manager(String mODID, File gamePath) {
		super();
		MODID = mODID;
		this.gamePath = gamePath;
	}
	public String getMODID() {
		return MODID;
	}
	
	public void bakeItems(final RegistryEvent.Register<Item> event) {
		
    	Item test = new basicitem().setRegistryName(MODID, "copper");

		event.getRegistry().register(test);
		
		
	}
	
	}

