import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	private final static Path DATA_PATH = Paths.get("/data");
	private final static Path COUNTRIES_PATH = DATA_PATH.resolve("countries.txt");
	private final static Path COUNTRIES_BACKUP_PATH = DATA_PATH.resolve("countries.bak");
	private final static Path LANGUAGES_PATH = DATA_PATH.resolve("languages.txt");
	private final static Path LANGUAGES_BACKUP_PATH = DATA_PATH.resolve("languages.bak");

	public static List<String> gesorteerdeGroenten() {
		return Stream.of("sla", "wortel", "kool", "biet").sorted().collect(Collectors.toList());
	}

	private static void zonderParallel(long aantalWaarden) {
		Random random = new Random();
		long voor = System.nanoTime();
		Stream.generate(() -> BigDecimal.valueOf(random.nextDouble())).limit(aantalWaarden)
				.filter(getal -> getal.remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.ZERO) == 0)
				.max((vorigGrootste, getal) -> vorigGrootste.compareTo(getal));
		System.out.println(String.format("%,16d:%,16d zonder parallel", aantalWaarden, System.nanoTime() - voor));
	}

	private static void metParallel(int aantalWaarden) {
		Random random = new Random();
		long voor = System.nanoTime();
		Stream.generate(() -> BigDecimal.valueOf(random.nextDouble())).parallel().limit(aantalWaarden)
				.filter(getal -> getal.remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.ZERO) == 0)
				.max((vorigGrootste, getal) -> vorigGrootste.compareTo(getal));
		System.out.println(String.format("%,16d:%,16d met parallel", aantalWaarden, System.nanoTime() - voor));
	}

	private static String omgekeerd(StringBuilder builder) {
		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		Stream.of("repel", "lepel").map(StringBuilder::new).map(Main::omgekeerd).map(String::toLowerCase)
				.forEach(System.out::println);

		/*
		 * Stream.of(10, 100, 1_000, 10_000, 100_000, 1_000_000,
		 * 10_000_000).forEach(aantalWaarden -> { zonderParallel(aantalWaarden);
		 * metParallel(aantalWaarden); }); System.out.println("the end");
		 */
		/*
		 * System.out.println(gesorteerdeGroenten()); Map<Integer, List<String>>
		 * groentenPerLengte = Stream.of("sla", "kool", "wortel", "biet")
		 * .collect(Collectors.groupingBy(groente -> groente.length()));
		 * groentenPerLengte.entrySet().stream().forEach(entry -> {
		 * System.out.print(entry.getKey());
		 * entry.getValue().stream().forEach(groente ->
		 * System.out.print(groente)); System.out.println(); });
		 * 
		 * System.out.println(Stream.of("sla", "wortel", "kool",
		 * "biet").collect(Collectors.joining(", ")));
		 */
		/*
		 * System.out.println(Stream.of("sla", "wortel", "kool",
		 * "biet").count()); IntStream stream = IntStream.of(1, 3, 4, 7); //
		 * System.out.println(stream.sum()); stream.min().ifPresent(kleinste ->
		 * System.out.println(kleinste));
		 * 
		 * System.out.println(Stream.of("sla", "wortel", "kool",
		 * "biet").mapToInt(groente -> groente.length()).sum());
		 * 
		 * Stream.of(BigDecimal.valueOf(1.1), BigDecimal.valueOf(0.9),
		 * BigDecimal.valueOf(0.5)) .min((getal1, getal2) ->
		 * getal1.compareTo(getal2)).ifPresent(kleinste ->
		 * System.out.println(kleinste));
		 * 
		 * System.out.println(Stream.of(BigDecimal.valueOf(1.1),
		 * BigDecimal.valueOf(0.9), BigDecimal.valueOf(0.5))
		 * .reduce(BigDecimal.ZERO, (vorigeSom, getal) ->
		 * vorigeSom.add(getal))); Stream.of(BigDecimal.valueOf(1.1),
		 * BigDecimal.valueOf(0.9), BigDecimal.valueOf(0.5)) .reduce((vorigeSom,
		 * getal) -> vorigeSom.add(getal)).ifPresent(som ->
		 * System.out.println(som));
		 */
		/*
		 * Stream.of(Stream.of("Joe", "Jack"), Stream.of("William",
		 * "Averell")).flatMap(stream -> stream) .forEach(voornaam ->
		 * System.out.println(voornaam));
		 */
		/*
		 * Stream.of("The lord of the rings", "The hobbit") .map(titel ->
		 * titel.split(" ")) .flatMap(array -> Arrays.stream(array)) .map(woord
		 * -> woord.toLowerCase()) .distinct() .sorted() .forEach(woord ->
		 * System.out.println(woord));
		 */

		/*
		 * EvenGetallen evenGetallen = getal -> getal % 2 == 0;
		 * System.out.println(evenGetallen.isEven(7)); EvenGetallen
		 * evenGetallen2 = getal -> getal % 2 == 1;
		 * System.out.println(evenGetallen2.isEven(7));
		 */
		/*
		 * String[] groenten = { "tomaat", "sla", "ui", "prei" };
		 * Arrays.sort(groenten, (groente1, groente2) -> groente1.length() -
		 * groente2.length()); System.out.println(Arrays.toString(groenten));
		 */
		/*
		 * new Thread(() -> legeRegelsVerwijderen()).start(); new Thread(() ->
		 * dubbelsVerwijderen()).start();
		 * 
		 * new Venster().setVisible(true);
		 */
		/*
		 * Optional<Integer> optioneelCijfer = eersteCijfer("all4you");
		 * optioneelCijfer.ifPresent(cijfer -> System.out.println(cijfer * 10));
		 * optioneelCijfer = eersteCijfer("wrong");
		 * optioneelCijfer.ifPresent(cijfer -> System.out.println(cijfer * 10));
		 */
		/*
		 * eersteCijfer("all4you").ifPresent(cijfer -> System.out.println(cijfer
		 * * 10)); eersteCijfer("wrong").ifPresent( cijfer ->
		 * System.out.println(cijfer * 10));
		 */
		/*
		 * String[] groenten = { "tomaat", "sla", "ui", "prei" };
		 * Arrays.stream(groenten).forEach(groente ->
		 * System.out.println(groente));
		 */

		/*
		 * List<String> groenten = Arrays.asList("tomaat", "sla", "ui", "prei");
		 * groenten.stream().forEach(groente -> System.out.println(groente));
		 * 
		 * Set<Integer> heiligeGetallen = new LinkedHashSet<>();
		 * heiligeGetallen.add(1); heiligeGetallen.add(3);
		 * heiligeGetallen.add(4); heiligeGetallen.add(7);
		 * heiligeGetallen.stream().forEach(getal -> System.out.println(getal));
		 * 
		 * Map<String, String> talen = new LinkedHashMap<>(); talen.put("NL",
		 * "Nederlands"); talen.put("FR", "Frans");
		 * talen.entrySet().stream().forEach(entry ->
		 * System.out.println(entry.getKey() + ':' + entry.getValue()));
		 */

		/*
		 * "Lambdafun".chars().forEach(unicode->System.out.println((char)
		 * unicode));
		 */

		/*
		 * try (Stream<String> stream = Files.lines(LANGUAGES_PATH)) {
		 * stream.forEach(regel -> System.out.println(regel)); } catch
		 * (IOException ex) { ex.printStackTrace(); }
		 */
		/*
		 * try (Stream<Path> stream = Files.list(DATA_PATH)) {
		 * stream.forEach(entry -> System.out.println(entry.getFileName())); }
		 * catch (Exception ex) { ex.printStackTrace(); }
		 */
		/*
		 * Stream.of("Adam", "Eva").forEach(naam -> System.out.println(naam));
		 */
		/*
		 * Stream.iterate(1, vorigGetal -> vorigGetal +
		 * 2).limit(10).forEach(onevenGetal -> System.out.println(onevenGetal));
		 */
		/*
		 * Stream<String> groenten = Stream.of("sla", "wortel", "kool", "biet");
		 * Stream<String> stream = groenten.filter(groente -> groente.length()
		 * == 4); stream.forEach(groenteMet4Letters ->
		 * System.out.println(groenteMet4Letters));
		 * 
		 * Stream.of("sla", "wortel", "kool", "biet").filter(groente ->
		 * groente.length() == 4) .forEach(groenteMet4Letters ->
		 * System.out.println(groenteMet4Letters));
		 */

		/*
		 * Stream.of("sla", "wortel", "kool", "biet").sorted((groente1,
		 * groente2) -> groente1.length() - groente2.length()) .forEach(groente
		 * -> System.out.println(groente));
		 * 
		 * System.out.println();
		 * 
		 * Comparator<String> comparator = (groente1, groente2) ->
		 * groente1.length() - groente2.length(); comparator =
		 * comparator.thenComparing((groente1, groente2) ->
		 * groente1.compareTo(groente2)); Stream.of("sla", "wortel", "kool",
		 * "biet").sorted(comparator).forEach(groente ->
		 * System.out.println(groente));
		 */
		/*
		 * Stream.of("sla", "wortel", "kool", "biet").filter(groente ->
		 * groente.length() == 4).sorted() .forEach(groente ->
		 * System.out.println(groente));
		 */
		/*
		 * Stream.of("sla", "kool", "wortel", "biet",
		 * "sla").distinct().forEach(groente -> System.out.println(groente));
		 */
		/*
		 * Stream.of("sla", "wortel", "kool", "biet").map(groente ->
		 * groente.length()) .forEach(lengte -> System.out.println(lengte));
		 */

		Stream.of(new Rechthoek(6, 2), new Rechthoek(3, 1), new Rechthoek(5, 4))
				.map(rechthoek -> rechthoek.getOppervlakte()).sorted()
				.forEach(oppervlakte -> System.out.println(oppervlakte));
		List<Rechthoek> rechthoeken = Arrays.asList(new Rechthoek(6, 2), new Rechthoek(3, 1), new Rechthoek(5, 4));
		rechthoeken.stream().map(Rechthoek::getOppervlakte)
		.forEach(System.out::println);
		

		/*
		 * System.out.println(Stream.of("sla", "wortel", "kool",
		 * "biet").allMatch(groente -> groente.length() == 4));
		 */

		// System.out.println(Stream.of("sla", "wortel", "kool",
		// "biet").anyMatch(groente -> groente.length() == 4));

	}

	private static Optional<Integer> eersteCijfer(String string) {
		for (int index = 0; index != string.length(); index++) {
			char teken = string.charAt(index);
			if (Character.isDigit(teken)) {
				return Optional.of(Character.getNumericValue(teken));
			}
		}
		return Optional.empty();
	}

	private static void legeRegelsVerwijderen() {
		try {
			Files.deleteIfExists(COUNTRIES_BACKUP_PATH);
			Files.move(COUNTRIES_PATH, COUNTRIES_BACKUP_PATH);
			try (BufferedReader reader = Files.newBufferedReader(COUNTRIES_BACKUP_PATH);
					Writer bufferedWriter = Files.newBufferedWriter(COUNTRIES_PATH);
					PrintWriter writer = new PrintWriter(bufferedWriter)) {
				for (String regel; (regel = reader.readLine()) != null;) {
					if (!regel.isEmpty()) {
						writer.printf("%s%n", regel);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void dubbelsVerwijderen() {
		Set<String> uniekeTalen = new LinkedHashSet<>();
		try {
			Files.deleteIfExists(LANGUAGES_BACKUP_PATH);
			Files.move(LANGUAGES_PATH, LANGUAGES_BACKUP_PATH);
			try (BufferedReader reader = Files.newBufferedReader(LANGUAGES_BACKUP_PATH)) {
				for (String regel; (regel = reader.readLine()) != null;) {
					uniekeTalen.add(regel);
				}
			}
			try (Writer bufferedWriter = Files.newBufferedWriter(LANGUAGES_PATH);
					PrintWriter writer = new PrintWriter(bufferedWriter)) {
				for (String taal : uniekeTalen) {
					writer.printf("%s%n", taal);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
