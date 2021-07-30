package lily.core;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;

public class ElementalDamageSource extends EntityDamageSource implements IElemental {

	public ElementalDamageSource(String name, Entity attacker, boolean crit, MagicElement element) {
		super(name, attacker);
		this.crit = crit;
		this.element = element;
	}
	protected final boolean crit;
	public boolean isCrit() {
		return crit;
	}
	public MagicElement getElement() {
		return element;
	}
	protected final MagicElement element;
	
	
	
	
	
}
