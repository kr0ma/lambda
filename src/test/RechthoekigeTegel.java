package test;

import java.math.BigDecimal;

public class RechthoekigeTegel extends Tegel{
	
	private double lengte;
	private double breedte;
	
	public RechthoekigeTegel(BigDecimal prijs, double lengte, double breedte) {
		super(prijs);
		this.breedte = breedte;
		this.lengte = lengte;
	}

	@Override
	public double getOppervlakte() {		
		return lengte * breedte;
	}

}
