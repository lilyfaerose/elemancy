package lily.bakery;

import java.util.function.Consumer;

import lily.core.Misc;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;

public enum ShappedRecipePattern {

	
	WRAPPED("xxx", "x#x", "xxx", 'x', '#', 'a');

private ShappedRecipePattern(String pattern1, String pattern2, String pattern3, Character key1, Character key2, Character key3) {
	this.pattern = new String[3];
	pattern[0] = pattern1;
	pattern[1] = pattern2;
	pattern[2] = pattern3;
	this.key1 = key1;
	this.Key2 = key2;
	this.key3 = key3;
}





public String[] pattern;


public final Character key1;
public final Character Key2;
public Character getKey1() {
	return key1;
}


public Character getKey2() {
	return Key2;
}


public Character getKey3() {
	return key3;
}


public final Character key3;

ShapedRecipeBuilder make(Consumer<IFinishedRecipe> consumer, Item result, String group /*Map<Character,Item> itemKeys, Map<Character,ITag<Item>>tagKeys*/) 
{
	
	ShapedRecipeBuilder recipe = ShapedRecipeBuilder.shaped(result);
	
	
	for (String str : this.pattern) 
	{
		recipe = recipe.pattern(str);
		Misc.echo(this.pattern[0]);
		recipe.group(group);
	}
	
	return recipe;
}


}
