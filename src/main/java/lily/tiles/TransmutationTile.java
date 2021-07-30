package lily.tiles;

import lily.core.Misc;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.extensions.IForgeTileEntity;

public class TransmutationTile extends TileEntity implements IForgeTileEntity, ITickableTileEntity{

	public TransmutationTile()  {
		super(null);
	}

	@Override
	public void tick() {
		Misc.echo("test level?");
	}

}
