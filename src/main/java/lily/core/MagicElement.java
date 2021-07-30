package lily.core;

public enum MagicElement {
	/**
	 *  element of warmth and heat
	 */
FIRE,
/**
 * element of fluids
 */
WATER,
/* 
 * element of gas and electricity
 */
AIR,
/**
 * element of stone and plants
 */
EARTH,
/*
 * element of purity 
 */
LIGHT,
/*
 * element of corruption?
 */
SHADOW,
/**
 * 
 * element of Mercy
 */
DARK;


MagicElement getOpposite() {
	
	switch(this) 
	{
	case AIR:return EARTH;
	case DARK:
		return LIGHT;
	case EARTH:
		return AIR;
	case FIRE:
		return WATER;
	case LIGHT:
		return DARK;
	case SHADOW:
		return SHADOW;
	case WATER:
		return FIRE;
	default:return SHADOW;
	 
	}
	
}}
