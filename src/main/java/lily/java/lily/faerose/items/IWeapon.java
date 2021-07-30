package lily.java.lily.faerose.items;

import net.minecraft.entity.LivingEntity;

public interface IWeapon {

	/**
	 * Willl this weapon Crit against this Entity
	 * @param living
	 * @return
	 */
	 public boolean  isCrit(LivingEntity living);
	
	
}
