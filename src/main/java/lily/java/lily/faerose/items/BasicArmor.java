package lily.java.lily.faerose.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class BasicArmor extends ArmorItem {
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	public BasicArmor(IArmorMaterial naterial, EquipmentSlotType type, Properties prop) {
		
		super(naterial, type, prop);
	      Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	      this.defaultModifiers = builder.build();

	}
	
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
		
		if( slot != EquipmentSlotType.MAINHAND)
		{
			return super.getDefaultAttributeModifiers(slot);
		}
		else
		{
			CompoundNBT tags= stack.getOrCreateTag();
			
			//TODO
		}
			
		return defaultModifiers; 
		
	}
		public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
			
			return defaultModifiers;


}}
