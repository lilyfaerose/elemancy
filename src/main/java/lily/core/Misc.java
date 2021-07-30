package lily.core;

import java.util.List;

import lily.java.lily.faerose.items.AdvancedMaterial;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class Misc {
	/**
	 * The modid. this should match with all other mod definitions
	 */
	public static final String MODID = "elemancy";
	public static final Attribute magic = new ModAttr(MODID+ ".magic", 0);
	public static final Attribute capacity = new ModAttr(MODID+ ".capacity", 0);
	public static final Attribute runicArmor = new ModAttr(MODID+ ".Armor", 0);
	public static final Attribute recharge = new ModAttr(MODID+ ".Recharge", 0);
	public static final Attribute resistance = new ModAttr(MODID+ ".resistance", 0);
	public static final Attribute purification = new ModAttr(MODID+ ".purification", 0);
	
	
	public static final IArmorMaterial silver = new AdvancedMaterial(new int[]{1, 4, 5, 2}, 15, 25, SoundEvents.ARMOR_EQUIP_CHAIN, 0, Items.BRICK.getRegistryName(), "silver chainmail") ;
	
	
    public static void echo (Object obj) {
    	System.out.println(obj);
    	}

	public ResourceLocation toResource(String str){
		return toResource(MODID, str);}
	
	
	public ResourceLocation toResource(String domain, String str){
		return new ResourceLocation(domain, str);}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static public List getRecipees(World world, IRecipeType type) {return world.getRecipeManager().getAllRecipesFor(type);}
}
