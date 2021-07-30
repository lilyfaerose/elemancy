package lily.java.lily.faerose.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class AdvancedMaterial implements IArmorMaterial, IItemTier {

	public AdvancedMaterial(int[] defense, int durability, int enchant, SoundEvent equipSound, float toughness,
			ResourceLocation repair, String name) {
		super();
		this.defense = defense;
		this.durability = durability;
		this.enchant = enchant;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.repair = repair;
		this.name = name;
	}

	int[] defense;
	int durability;
	int enchant;
	SoundEvent equipSound;
	float toughness;
	ResourceLocation repair;
	String name;
	
	@Override
	public int getDurabilityForSlot(EquipmentSlotType type) {
		return type.getFilterFlag() *this.durability;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlotType type) {
		return defense[type.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchant;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(ForgeRegistries.ITEMS.getValue(repair));
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.getKnockbackResistance();
	}

	@Override
	public int getUses() {
		return this.durability *10;
	}

	@Override
	public float getSpeed() {
		return 0;
	}

	@Override
	public float getAttackDamageBonus() {

		return 0;
	}

	@Override
	public int getLevel() {

		return 0;
	}

}
