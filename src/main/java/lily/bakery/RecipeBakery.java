package lily.bakery;

import java.util.function.Consumer;

import lily.core.Misc;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.SmithingRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeRecipeProvider;

@SuppressWarnings("unused")
public class RecipeBakery extends ForgeRecipeProvider {

	public RecipeBakery(DataGenerator generator) {
		super(generator);}
		
		
		
	    @Override
	    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
	    {
	
    this.getShapped(Blocks.RED_MUSHROOM_BLOCK).pattern("xxx").pattern("x#x").pattern("xxx").define('x', Tags.Items.STONE).define('#', Tags.Items.DYES_RED).group(Misc.MODID).unlockedBy("cobblestone", InventoryChangeTrigger.Instance.hasItems(Blocks.COBBLESTONE)).save(consumer);
	//RecipePattern.WRAPPED.make(consumer, Blocks.RED_CONCRETE.asItem(), Misc.MODID, Tags.Items.COBBLESTONE, Misc.MODID, Tags.Items.DUSTS_GLOWSTONE);
     //RecipeMaker maker = new RecipeMaker(ShappedRecipePattern.WRAPPED, Misc.MODID).bind(Tags.Items.COBBLESTONE).bind(Tags.Items.DUSTS_REDSTONE);
     //maker.Run(Blocks.RED_GLAZED_TERRACOTTA, consumer);
	
	
	//ShappedRecipePattern pattern = ShappedRecipePattern.WRAPPED;
	//Misc.echo("xxxx#xxxx".subSequence(0, 3));
	//Misc.echo("xxxx#xxxx".subSequence(3, 6));
	//Misc.echo("xxxx#xxxx".subSequence(6, 9));
	
	//RecipeMaker maker = new RecipeMaker("xxx", "x#x", "xxx", Misc.MODID, Blocks.EMERALD_ORE);
	//maker.bind(Keyes.X, Tags.Items.DYES_LIGHT_GRAY).bind(Keyes.Pound, Tags.Items.BONES).Run(consumer);
	//maker.Run(null);
	
	//pattern.make(consumer, Items.WITHER_ROSE, Misc.MODID).define(pattern.getKey1(), Tags.Items.DYES_RED).define(pattern.getKey2(), Items.ACACIA_PLANKS).save(consumer); 
	}
public ShapedRecipeBuilder getShapped(IItemProvider output) {
	return ShapedRecipeBuilder.shaped(output);};

public SmithingRecipeBuilder getSmelting(Ingredient input, Ingredient other, Item output) {
	return SmithingRecipeBuilder.smithing(input, other, output);}}
