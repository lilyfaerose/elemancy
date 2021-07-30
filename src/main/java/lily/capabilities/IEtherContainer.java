package lily.capabilities;

import lily.core.MagicElement;

public interface IEtherContainer {

	int getEther(MagicElement element);
	
	
	int getCapacity();

	/**
	 * Sets the amount of ether in the container returns true if this was successful
	 * @param element
	 * @param amount
	 * @return
	 */
	boolean setEther(MagicElement element, int amount);
	


int fill(MagicElement element, int amount);

int drain (MagicElement element, int amount);

}