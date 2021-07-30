package core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Creativegroup extends ItemGroup {

	public Creativegroup(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}

	public Creativegroup(int index, String label) {
		super(index, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack makeIcon() {
		
		return new ItemStack(Items.ARMOR_STAND);
	}

}
