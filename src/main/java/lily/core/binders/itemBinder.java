package lily.core.binders;

import lily.core.Binder;
import lily.core.MagicElement;
import lily.core.Misc;
import lily.java.lily.faerose.blocks.ItemBlock;
import lily.java.lily.faerose.items.AttckTypes;
import lily.java.lily.faerose.items.MagicWeapon;
import lily.java.lily.faerose.items.basicitem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
@SuppressWarnings("rawtypes")
public class itemBinder extends Binder {

	
	public Item brass =  new basicitem();
	public Item Zincite = new basicitem();
	public Item Amber = new basicitem();
	public Item Brass_Block = new ItemBlock(null);
	public Item bone_Crusher =  new MagicWeapon(AttckTypes.CRUSHING, MagicElement.DARK);
public Item magicPowder = new basicitem();
	
	public itemBinder(String iD) {
		super(iD);
	}

	@Override
	public void register(Register event) {
		
		Misc.echo(event.getGenericType());
		this.bind(event, "ingots", brass);
		this.bind(event, "Zincite", Zincite);
		this.bind(event, "Amber", this.Amber);
		this.bind(event, "bone.Crusher", bone_Crusher);
		this.bind(event, "Magic.Powder", this.magicPowder);
	}

}
