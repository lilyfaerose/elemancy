package lily.bakery;

import java.util.ArrayList;
/**
 * Used to encode a json for use with data generator or write direct to disk
 * @author lily.faerose
 *
 */
public interface IBaseModel {

	public ArrayList<String> bake(String modid, String name);
	
}
