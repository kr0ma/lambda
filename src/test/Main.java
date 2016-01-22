package test;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args){
		Tegel tegel1 = new VierkanteTegel(new BigDecimal(3), 30.0);
		
		Tegel tegel2 = new RechthoekigeTegel(new BigDecimal(5), 40.0, 20.0);
		
		Tegel tegel3 = new DriehoekigeTegel(new BigDecimal(4), 40.0, 15.0);
		
		Bestelling bestelling = new Bestelling();
		
		bestelling.detailToevoegen(tegel1, 10);
		bestelling.detailToevoegen(tegel2, 3);
		bestelling.detailToevoegen(tegel3, 15);
		bestelling.wijzigAantalVanDetail(tegel2, 5);
		System.out.println(bestelling.getOppervlakte());
		System.out.println(bestelling.getTeBetalen());
		
	}
}
