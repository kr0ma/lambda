package test;

import java.math.BigDecimal;

public class VierkanteTegel extends Tegel {
	
	private double zijde;
	
	public VierkanteTegel(BigDecimal prijs, double zijde) {
		super(prijs);		
		this.zijde = zijde;
	}	

	@Override
	public double getOppervlakte() {
		return zijde * zijde;
	}

}
