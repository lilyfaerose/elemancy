package lily.bakery;

import java.util.function.Consumer;

import lily.core.Misc;
import net.minecraft.block.Block;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;

public class RecipeMaker {

	public RecipeMaker(String line1,String line2,String line3, String group, IItemProvider result) {
		super();
		recipe = ShapedRecipeBuilder.shaped(result).group(group).pattern(line1).pattern(line2).pattern(line3);
	}
	
	public RecipeMaker(String line1,String line2,String line3, String group, Block result) {
		this(line1, line2, line3, group, result.asItem());
		recipe = ShapedRecipeBuilder.shaped(result).group(group).pattern(line1).pattern(line2).pattern(line3);
	}

	
	public ShapedRecipeBuilder recipe;
	
	


RecipeMaker bind(Keyes key, ITag<Item> item)
{
	this.recipe.define(key.getCharacter(), item);

	
	return this;
}

void Run(Consumer<IFinishedRecipe> consumer) {
	
	Misc.echo("save?");
	this.recipe.save(consumer);
}



		
	}