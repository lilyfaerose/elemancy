package lily.core.binders;

import lily.core.Binder;
import lily.core.recipes.TransmutationRecipe;
import lily.core.recipes.TransmutationSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.event.RegistryEvent.Register;

public class RecipeeBinder extends Binder {

	
	
	public IRecipeType<TransmutationRecipe> transmutationType ;
	public TransmutationSerializer transmutationser = new TransmutationSerializer();

	
	
	
	public RecipeeBinder(String iD) {
		super(iD);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void register(Register event) {
		this.bind(event, "transmutation", transmutationser);
		
		
		
		this.transmutationType = IRecipeType.register("transmutation");
		
	}
	
	

}
