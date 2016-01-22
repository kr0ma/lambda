package tasks;

public class Rechthoek {
	private final int lengte;
	private final int breedte;

	public Rechthoek(int lengte, int breedte) {
		this.lengte = lengte;
		this.breedte = breedte;
	}

	public int getOppervlakte() {
		return lengte * breedte;
	}

	@Override
	public String toString() {
		return "lengte: " + lengte + " breedte: " + breedte;
	}
	
	
}
