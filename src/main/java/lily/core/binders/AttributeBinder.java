package lily.core.binders;

import lily.core.Binder;
import lily.core.Misc;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraftforge.event.RegistryEvent.Register;

public class AttributeBinder extends Binder {

	
	
	public static final Attribute magic = Misc.magic;
	public static final Attribute capacity = Misc.capacity;
	public static final Attribute runicArmor = Misc.runicArmor;
	public static final Attribute recharge = Misc.recharge;
	public static final Attribute resistance = Misc.resistance;
	public static final Attribute purification = Misc.purification;

	
	
	
	
	
	public AttributeBinder(String iD) {
		super(iD);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void register(Register event) {
		this.bind(event, "magic", magic);
		this.bind(event, "runicArmor", runicArmor);
		this.bind(event, "recharge", recharge);

		this.bind(event, "capacity", capacity);
		this.bind(event, "resistance", resistance);
		this.bind(event, "purification", purification);


		
	}

}
