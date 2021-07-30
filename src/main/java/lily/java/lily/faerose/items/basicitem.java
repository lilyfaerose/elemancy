package lily.java.lily.faerose.items;

import javax.annotation.Nullable;

import lily.core.Elemancy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class basicitem extends Item {

	public basicitem(Properties prop) {
		super(prop);
	}
	
	
	public basicitem() {
		super(new Properties().tab(Elemancy.TAB));
	}
	@Override
	public
    boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity)
    {
		
		
		
        return false;
    }


/**
 * Used by saddle, chears, name tag
 */
	@Override
public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
    //target.hurt(new ElementalDamageSource("fire", player, false, MagicElement.LIGHT), Float.MAX_VALUE);
		
		
		return ActionResultType.PASS;}


public void releaseUsing(ItemStack stack, World world, LivingEntity entity, int unknown) {
	
	
	
}

@Override
public boolean isFoil(ItemStack stack) {
    return stack.isEnchanted();

}


public boolean canBeHurtBy(DamageSource sopurce) {
    return ! super.canBeHurtBy(sopurce);
 }



public boolean isShield(ItemStack stack, @Nullable LivingEntity entity)
{
    return stack.getItem() == Items.SHIELD;
}


public boolean canElytraFly(ItemStack stack, LivingEntity entity)
{
    return false;
}


public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks)
{
    return false;
}




public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity)
{
    return false;
}


}