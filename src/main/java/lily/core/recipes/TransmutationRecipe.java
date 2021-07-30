package lily.core.recipes;

import lily.core.Elemancy;
import lily.core.Misc;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

public class TransmutationRecipe implements IRecipe<IInventory> {

	@Override
	public String toString() {
		return "TransmutationRecipe [input=" + input + ", output=" + output + ", id=" + id + ", amount=" + amount + "]";
	}


	public TransmutationRecipe() {
		super();
	}

	
	public TransmutationRecipe(ResourceLocation input, ResourceLocation id, ResourceLocation output, int amount) {
		this();
		
		Misc.echo(output);
		Misc.echo(input);
		Elemancy.getLogger().debug(amount);
		this.input = input;this.input = input;
		this.output = output;
		this.amount = amount;
		this.id = id;
		
		
		
		Misc.echo("recipe being baked: " + id);
		
	}
	
	public ResourceLocation input ;
	public ResourceLocation output;
	public ResourceLocation id;
	public int amount;
	@Override
	public boolean matches(IInventory inv, World world) {
		//sb.append(inv);
		return true;
	}

	@Override
	public ItemStack assemble(IInventory inv) {
		Misc.echo("output?"+ ForgeRegistries.ITEMS.containsKey(this.output));
		Misc.echo(output);
		
		ItemStack stack = new ItemStack(ForgeRegistries.ITEMS.getValue(input));
		
		
		
		stack.setCount(Math.max(this.getAmount(), 2));
		return stack;
	}
	
	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		
		ItemStack stack = new ItemStack(ForgeRegistries.ITEMS.getValue(this.output));
		stack.setCount(this.amount);
		
		Misc.echo("output?"+ stack);

		return stack;

	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public IRecipeSerializer<TransmutationRecipe> getSerializer() {
		return Elemancy.Recipees.transmutationser;
	}

	@Override
	public IRecipeType<TransmutationRecipe> getType() {
		return Elemancy.Recipees.transmutationType;
	}

	public Block getBlockIngrediant() {
		return ForgeRegistries.BLOCKS.getValue(input);
	}

	public Item getresult() {
		return ForgeRegistries.ITEMS.getValue(this.output);
	}

	public int getAmount() {
		return this.amount;
	}}



