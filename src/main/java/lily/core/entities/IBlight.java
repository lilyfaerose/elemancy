package lily.core.entities;

import lily.core.IElemental;

public interface IBlight extends IElemental{

	
	default boolean shouldrevive() {
		return true;}; 
	
		
		default float reviveHP () {
			return 15;};
			
}
