package lily.java.lily.faerose.blocks;

import lily.tiles.TransmutationTile;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.world.IBlockReader;

@SuppressWarnings("deprecation")
public class TransmuteBlock extends BasicBlock implements ITileEntityProvider{

	public TransmuteBlock(Properties properties) {
		super(properties);
	}

	@Override
	public TransmutationTile newBlockEntity(IBlockReader p_196283_1_) {
		return new TransmutationTile();
	}

}
