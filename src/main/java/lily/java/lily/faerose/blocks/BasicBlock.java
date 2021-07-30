/**
 * @author lily.faerose
 */
package lily.java.lily.faerose.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author lily.faerose
 *
 */
public class BasicBlock extends Block {

	/**
	 * @param properties
	 */
	public BasicBlock(Properties properties) {
		super(properties);
	}





public Item asItem() {
	
return ForgeRegistries.ITEMS.getValue(getRegistryName());
}

public boolean hasTileEntity(BlockState state)
{
    return this instanceof ITileEntityProvider;
}

/**
 * Called throughout the code as a replacement for ITileEntityProvider.createNewTileEntity
 * Return the same thing you would from that function.
 * This will fall back to ITileEntityProvider.createNewTileEntity(World) if this block is a ITileEntityProvider
 *
 * @param state The state of the current block
 * @param world The world to create the TE in
 * @return A instance of a class extending TileEntity
 */
@SuppressWarnings("deprecation")
@Nullable
public
TileEntity createTileEntity(BlockState state, IBlockReader world)
{
    if (getBlock() instanceof ITileEntityProvider)
        return ((ITileEntityProvider)getBlock()).newBlockEntity(world);
    return null;
}


}
