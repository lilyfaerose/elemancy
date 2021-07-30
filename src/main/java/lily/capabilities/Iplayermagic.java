package lily.capabilities;

public interface Iplayermagic extends IEtherContainer {
	/**
	 * Can the player use Magic?
	 * @return
	 */
	boolean usable();
	
	void setUsable (boolean usable);
}
