package lily.bakery;

public enum Keyes {


X,
A,
B,
C, Y,
Z,
Pound;
	

	public Character getCharacter() 
	{
		
		switch(this)
		{
		case A:
			return 'a';
		case B:
			return 'b';
		case C:
			return 'c';
		case X:
			return 'x';
		case Y:
			return'y';
		case Z:
			return'Z';
			
		case Pound: return '#';
		default:
			return '#';
		
		}
		
	}


}