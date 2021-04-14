package api;

public enum planets {

	MARS(Element.FIRE),
	VENUS(Element.EARTH),
	MERCURITY(Element.WATER),
	JUPITER(Element.AIR),
	GAIA(Element.LIGHT),
	SATURN(Element.DARK);

	private planets(Element aspect) 
	{
		this.aspect = aspect;
	}

	Element aspect; 
}
