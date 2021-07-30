package lily.core;

public class PotionDamageSource extends net.minecraft.util.DamageSource implements IElemental {

	public PotionDamageSource(String text, MagicElement element) {
		super(text);
		
		this.element = element;

	}

	private final MagicElement element;

	@Override
	public MagicElement getElement() {
		return element;
	}

}
