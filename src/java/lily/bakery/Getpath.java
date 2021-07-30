package bakery;

import java.io.File;

import core.Strings;

public enum Getpath implements IconstructPath {
SOURCE {

	@Override
	public File get() {
		return new File(Strings.source);
	}
	
},
BLOCKSTATES{

	@Override
	public File get() {
		return new File(Strings.source);
	}
	
},
LANG{

	@Override
	public File get() {
		return new File(Strings.resources);
	}
	
},
lOOT_TABLES{

	@Override
	public File get() {
		return new File(Strings.source);
	}
	
},


}
