package bakery;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class basicitem extends Item {

	public basicitem(Properties prop) {
		super(prop);
	}
	
	
	public basicitem() {
		super(new Properties().tab(ItemGroup.TAB_MISC));
	}

	

}
