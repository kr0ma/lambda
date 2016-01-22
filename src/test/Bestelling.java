package test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Bestelling {

	private Map<Tegel, Integer> details = new HashMap<>();

	public void detailToevoegen(Tegel tegel, int aantal) {
		if (details.containsKey(tegel)) {
			aantal += details.get(tegel);
		}
		details.put(tegel, aantal);
	}

	public void wijzigAantalVanDetail(Tegel tegel, int aantal) {
		if (details.containsKey(tegel)) {
			details.put(tegel, aantal);
		}
	}

	public Double getOppervlakte() {
		// return details.keySet().stream().mapToDouble(tegel ->
		// tegel.getOppervlakte() * details.get(tegel)).sum();
		return details.entrySet().stream().mapToDouble(entry -> entry.getKey().getOppervlakte() * entry.getValue())
				.sum();
	}

	private Optional<BigDecimal> getTeBetalenOptional() {
		return details.entrySet().stream()
				.map(entry -> entry.getKey().getPrijs().multiply(BigDecimal.valueOf(entry.getValue())))
				.reduce((vorigeSom, prijs) -> vorigeSom.add(prijs));
	}

	public BigDecimal getTeBetalen() {
		if (getTeBetalenOptional().isPresent()) {
			return getTeBetalenOptional().get();
		} else {
			return null;
		}
	}
}
