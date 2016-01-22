package test;

import java.math.BigDecimal;

public class DriehoekigeTegel extends Tegel {
	
	private double breedte;
	private double lengte;

	public DriehoekigeTegel(BigDecimal prijs, double lengte, double breedte) {
		super(prijs);
		this.breedte = breedte;
		this.lengte = lengte;
	}

	@Override
	public double getOppervlakte() {		
		return lengte * breedte / 2;
	}

}
