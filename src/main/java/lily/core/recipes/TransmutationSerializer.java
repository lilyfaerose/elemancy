package lily.core.recipes;

import com.google.gson.JsonObject;

import lily.core.Elemancy;
import lily.core.Misc;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class TransmutationSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<TransmutationRecipe> {

	public TransmutationSerializer() {
		
		
	}

	@Override
	public TransmutationRecipe fromJson(ResourceLocation loc, JsonObject json) {
		
		
		
		Elemancy.getLogger().debug(json);
		
		String str = JSONUtils.getAsString(json, "input");
		Misc.echo(str);
			Block input = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(str));
		if (input == Blocks.AIR)
		{
			Elemancy.getLogger().error("input block could not be found");
		}
		
		str = JSONUtils.getAsString(json, "result");
		
		
		ItemStack output = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(str)));
		 int amount = (int) JSONUtils.getAsLong(json, "count", -1);
		 
		 if(amount <= 0)
			 Elemancy.getLogger().error("field count not found or set to low.");
		 
		 
		 Misc.echo(amount);
		output.setCount(amount);
		
		TransmutationRecipe recipe = new TransmutationRecipe(input.getRegistryName(), new ResourceLocation(str),loc, amount);
		Misc.echo("recipee output:" + output);
		return recipe;
	}

	@Override
	public TransmutationRecipe fromNetwork(ResourceLocation loc, PacketBuffer buffer) {
		
		Misc.echo("from server");
		
		return null;
	}

	@Override
	public void toNetwork(PacketBuffer buffer, TransmutationRecipe recipe) {
		
		Misc.echo("to client");
		
		
		
	}
	}
