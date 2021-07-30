package lily.core.binders;

import lily.core.Binder;
import lily.java.lily.faerose.blocks.BasicBlock;
import lily.java.lily.faerose.blocks.TransmuteBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent.Register;

public class BlockBinder extends Binder {
public Block brass = new BasicBlock(Properties.of(Material.STONE));
public Block test = new TransmuteBlock(Properties.of(Material.GLASS));
	public BlockBinder(String iD) {
		super(iD);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void register(Register event) {
		this.bind(event, "brass block", brass);
		this.bind(event, "transmute", test);
	}

}
