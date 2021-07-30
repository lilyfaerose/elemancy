package lily.core.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;

@SuppressWarnings("rawtypes")
public interface ITransmutationRecipe extends IRecipe{
Block getBlockIngrediant();

Item getresult();


int getAmount();


}
