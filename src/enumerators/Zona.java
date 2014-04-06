package enumerators;

public enum Zona {
	NORTE,SUL,LESTE,OESTE;

	
	public static Zona convertStringToZona(String zona){
		for(Zona z: Zona.values()){
			if(zona.equalsIgnoreCase(z.name())){
				return z;
			}
		}
		return null;
	}
}
