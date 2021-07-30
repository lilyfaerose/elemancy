package lily.core;

import java.util.Locale;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

@SuppressWarnings("rawtypes")

public abstract class Binder {

	public Binder(String iD) {
		super();
		ID = iD;
	}

	public String ID; 
	public abstract void register(RegistryEvent.Register event);
	
	@SuppressWarnings("unchecked")
	public void bind(RegistryEvent.Register event, String name, IForgeRegistryEntry entry) 
	
	{
		name = name.toLowerCase(Locale.ENGLISH).replaceAll(" ", ".");
		Misc.echo(name);
		entry.setRegistryName(new ResourceLocation(ID, name));
		
		event.getRegistry().register(entry);

}}
