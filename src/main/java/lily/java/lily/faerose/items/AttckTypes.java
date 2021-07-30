package lily.java.lily.faerose.items;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IFlyingAnimal;

public enum AttckTypes implements IWeapon {
CRUSHING,
Potion,
POWDER,
MAGIC,
CLAW,
SPEAR,
SHOT,
SLASHING,
EXPLOSIVE;

@Override
public boolean isCrit(LivingEntity living) {
	
	switch(this){
	case CRUSHING:
		return living.getMobType() == CreatureAttribute.UNDEAD;
	case MAGIC:
		return living instanceof GolemEntity;
	case Potion:
		return living instanceof EndermanEntity;
	case POWDER:
		return living.getMobType() == CreatureAttribute.ARTHROPOD;
	case CLAW:return living instanceof CreeperEntity;
	case SHOT:return living instanceof EnderDragonEntity || living instanceof FlyingEntity || living instanceof BlazeEntity ||living instanceof IFlyingAnimal;
	case SPEAR: return living.getMobType() == CreatureAttribute.ILLAGER||living instanceof WitchEntity;
	case SLASHING:
		return living instanceof SlimeEntity;
	case  EXPLOSIVE: return living.getMobType() == CreatureAttribute.UNDEFINED;
	default:
		return false;}
}}


