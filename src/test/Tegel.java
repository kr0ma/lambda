package test;

import java.math.BigDecimal;

public abstract class Tegel {
	private BigDecimal prijs;
	
	protected Tegel(BigDecimal prijs){
		this.prijs = prijs;
	}
	
	public abstract double getOppervlakte();
	
	public BigDecimal getPrijs() {
		return prijs;
	}
}
