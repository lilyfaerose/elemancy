package lily.java.lily.faerose.blocks;

import lily.core.Elemancy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemBlock extends BlockItem {

	public ItemBlock(Block block, Properties properties) {
		super(block, properties);
		// TODO Auto-generated constructor stub
	}


	public ItemBlock(Block block) {
		this(block, new Properties().tab(Elemancy.TAB));}


@Override
public Block getBlock() 
{
	return ForgeRegistries.BLOCKS.getValue(getRegistryName());

		
}}