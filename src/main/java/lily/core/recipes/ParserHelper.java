package lily.core.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

import lily.core.Elemancy;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;

public class ParserHelper {

	public ParserHelper() {
	}
	
	
	static public String getString(JsonElement json, String key, ResourceLocation loc) 
	{			
		try {return JSONUtils.convertToString(json, key);} catch(JsonSyntaxException e) 
		{
			StringBuilder sb = new StringBuilder().append("error parsing ").append(loc).append("unable to get String ").append(key).append(" from").append(json);
			Elemancy.getLogger().info(e);
			Elemancy.getLogger().info(sb.toString());
			
			
			
		}
		
		return "";
	}
	
	
	
}
