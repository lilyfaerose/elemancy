package lily.java.lily.faerose.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import lily.core.Elemancy;
import lily.core.ElementalDamageSource;
import lily.core.MagicElement;
import lily.core.Misc;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.entity.PartEntity;

public class MagicWeapon extends basicitem 
{
	
	
	private final AttckTypes type;
	private final MagicElement baseElement;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	
	
	
	
	@SuppressWarnings("static-access")
	public MagicWeapon(AttckTypes type, MagicElement baseElement) {
		super();
		this.type = type;
		this.baseElement = baseElement;
		
		
	      Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	      builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)10, AttributeModifier.Operation.ADDITION));
	      builder.put(Elemancy.Attribute.capacity, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)5, AttributeModifier.Operation.ADDITION));
	      builder.put(Elemancy.Attribute.magic, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)50, AttributeModifier.Operation.ADDITION));
	      builder.put(Elemancy.Attribute.resistance, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)10, AttributeModifier.Operation.ADDITION));
	      this.defaultModifiers = builder.build();

	}

	
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context)
    {
        return ActionResultType.PASS;
    }

	//List recipees = Misc.getRecipees(context RecipeData.transmutationType);
	
	@Override
	public boolean isFoil(ItemStack stack) {
	    return false;// May set this to if the client player is corrupted

}

@SuppressWarnings("rawtypes")
@Override
public
boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity)
{
	
	
	
	if(this.type == null)
		return false;
	
	if (entity instanceof PartEntity)
		entity = ((PartEntity)entity).getParent();
	
	
	if((entity instanceof LivingEntity))
	{
		LivingEntity living = (LivingEntity) entity;
				
		
		boolean iscrit= this.type.isCrit(living);
		 float spellmulti = 1.0F;
		net.minecraftforge.event.entity.player.CriticalHitEvent hitResult = net.minecraftforge.common.ForgeHooks.getCriticalHit(player,entity ,false , 1.5F);
		iscrit = hitResult!= null;
		
		ElementalDamageSource source = new ElementalDamageSource(Misc.MODID +":" +this.type.name(), player, iscrit, this.baseElement);
		float Power = (float) player.getAttribute(Misc.magic).getValue() *spellmulti;
		if(iscrit) { Power*=Math.max(hitResult.getDamageModifier(), 1.5F);}
		int knockback = 1;
		float damage = living.getHealth();
		boolean sucess = living.hurt(source, Power);
		(living).knockback((float)knockback * 0.5F, (double)MathHelper.sin(player.yRot * ((float)Math.PI / 180F)), (double)(-MathHelper.cos(player.yRot * ((float)Math.PI / 180F))));		
        if (player.level instanceof ServerWorld && damage > 2.0F) {
            int k = (int)((damage * 0.5D));
            player.level.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP,
player.getSoundSource(), 2.0F, 1.9F);
            ((ServerWorld)player.level).sendParticles(ParticleTypes.DAMAGE_INDICATOR, living.getX(), living.getY(0.5D), living.getZ(), k, 0.1D, 0.0D, 0.1D, 0.2D);

		return true;}
		
		else 
	{
		
			return true;
	}}
	return true;
	
}
@SuppressWarnings("deprecation")
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
