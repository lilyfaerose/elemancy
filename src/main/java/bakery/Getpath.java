package bakery;

import java.io.File;

public enum Getpath implements IconstructPath {
SOURCE {

	@Override
	public File get() {
		return new File(Strings.source);
	}
	
},
}
