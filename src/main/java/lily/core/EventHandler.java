package lily.core;

import java.util.List;

import lily.core.entities.IBlight;
import lily.core.recipes.TransmutationRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.event.RecipesUpdatedEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.ItemHandlerHelper;

public class EventHandler {
    @SuppressWarnings({ "rawtypes", "resource" })
	@SubscribeEvent
    public void pickupItem(PlayerInteractEvent.RightClickBlock event) {
        ;
        List list = Misc.getRecipees(event.getWorld(), Elemancy.Recipees.transmutationType);
        
        if(event.getWorld().isClientSide || event.isCanceled())
        {
        	return;
        }
        	
        PlayerEntity player =event.getPlayer();
        if (player == null || list == null)
        {
        	Misc.echo("null");
        	return;
        }
        	
        
        Misc.echo(event.getItemStack());
        
        
        if(event.getItemStack().getItem() != Elemancy.Items.magicPowder)
        {Misc.echo(list.size());
        	return;
        	
        }
        	
        
        
        for (Object obj : list)
        {
        	TransmutationRecipe recipe = (TransmutationRecipe)  obj;
        	
        	Misc.echo("attempting" + obj.toString());
        	Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
        	
        	if(block == Blocks.AIR)
        	{
        		return;
        	}
        	
        	
        	{
        	
        	
        	Misc.echo("targetting "+ block);
        	if(block == recipe.getBlockIngrediant())
        	{
        		event.setResult(Result.DENY);
        		event.getWorld().setBlock(event.getPos(), Blocks.AIR.defaultBlockState(), 512);
        		//event.getWorld().setBlock(event.getPos(), Elemancy.Blocks.test.defaultBlockState(), 512);
                ItemHandlerHelper.giveItemToPlayer(player, recipe.getResultItem().copy());
                
                
                player.swing(event.getHand(), true);
                if(player.abilities.instabuild)
                	return;
                
                
                //ItemStack stack = event.getItemStack();
                //stack.shrink(1);
                
        		return;
        	}
			
			else {}
				
        	
        	
        }}
        
        
        
    }


@SubscribeEvent
public void onExplosion(ExplosionEvent event) {
	
	
    //TODO FIZZLE
    
    
}

@SubscribeEvent
public void blightRevive(LivingDeathEvent event) {

	if(event.getEntityLiving() instanceof IBlight)
	{
		
		IBlight blight = (IBlight) event.getEntityLiving();
		if(!blight.shouldrevive())
						
			return;
		
MagicElement magic = blight.getElement();
DamageSource suorce = event.getSource();


if(!(suorce instanceof IElemental)) {return;}
else 
{
	IElemental element = (ElementalDamageSource)suorce;
	
	if(magic.getOpposite()!= element.getElement()) 
	{
		event.setCanceled(true);
	event.getEntityLiving().setHealth(blight.reviveHP());
	//handle chunk drain

	}
}

	}else {return;}
}


@SubscribeEvent
public void onDamage(LivingDamageEvent event) {
	
	
	if(event.getSource() instanceof IElemental)
	{
		IElemental Attacker = (IElemental)event.getSource();
		if(Attacker.getElement() == MagicElement.SHADOW)
		{
			double resist = event.getEntityLiving().getAttributeValue(Misc.resistance);
			double damage = event.getAmount() - Math.max(resist, 0);
			 event.setAmount((float) damage);
						
		}
	}
	
	
	
	
	//if(!(event.getEntityLiving() instanceof PlayerEntity))
		//return;
	if (event.getSource() instanceof IElemental)
	{
		
		IElemental element = (IElemental)event.getSource();
		//Misc.echo(element.getElement());
		
		
		
	}//else {Misc.echo("fail");}
	
	
	
	//TODO Warded
	
	
}



@SubscribeEvent
public void onWakeup(RecipesUpdatedEvent event) {
	
	
	Elemancy.getLogger().debug("recipe update");
	
	//event.getRecipeManager().getAllRecipesFor(RecipeData.transmutationType);
	
}
	




@SubscribeEvent
public void onWakeup(PlayerWakeUpEvent event) {
	
	PlayerEntity player = event.getPlayer();
	
	double purity = player.getAttributeValue(Misc.purification);
	
	
	if (purity >=20D)
	{
		Misc.echo("TODO purify");
	}
	
}



}