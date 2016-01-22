package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

	private final static Path DATA_PATH = Paths.get("/data");
	private final static Path LANDCODES_PATH = DATA_PATH.resolve("landcodes.txt");
	private final static Path STERRENBEELDEN_PATH = DATA_PATH.resolve("sterrenbeelden.txt");

	private final static Path ALBUMSARTISTS_PATH = DATA_PATH.resolve("albumsartists.txt");

	public static void main(String[] args) {
		/*
		 * EvenGetallen evenGetallen = getal -> getal % 2 == 0;
		 * System.out.println(evenGetallen.isEven(7));
		 * 
		 * String[] groenten = { "tomaat", "sla", "ui", "prei" };
		 * Arrays.sort(groenten, (groente1, groente2) -> groente1.length() -
		 * groente2.length()); System.out.println(Arrays.toString(groenten));
		 */
		/*
		 * // new Venster().setVisible(true);
		 * haalLandnaam("BE").ifPresent(landnaam ->
		 * System.out.println(landnaam));
		 * 
		 * // 1.4 System.out.println("Geef een woord in"); try (Scanner scanner
		 * = new Scanner(System.in)) { String woord =
		 * scanner.next().toUpperCase(); try (Stream<String> stream =
		 * Files.lines(STERRENBEELDEN_PATH)) { // 1.3
		 * //stream.forEach(sterrenbeeld ->
		 * System.out.println(sterrenbeeld.toUpperCase()));
		 * 
		 * // 1.4 stream.filter(sterrenbeeld ->
		 * sterrenbeeld.toUpperCase().contains(woord)).forEach(sterrenbeeld ->
		 * System.out.println(sterrenbeeld)); } } catch (IOException ex) {
		 * ex.printStackTrace(); }
		 */

		/*
		 * // 1.5 List<Integer> getallen = new ArrayList<>(); try (Scanner
		 * scanner = new Scanner(System.in)) { System.out.println("Getal : ");
		 * for (int getal; (getal = scanner.nextInt()) != 0;) {
		 * getallen.add(getal); System.out.println("Getal : "); } }
		 * getallen.stream().filter(getal -> getal % 2 == 1).sorted((getal1,
		 * getal2) -> getal2 - getal1) .forEach(getal ->
		 * System.out.println(getal));
		 */

		// 1.6
		/*
		 * try (Stream<String> stream = Files.lines(LANDCODES_PATH)) {
		 * stream.map(regel -> regel.substring(regel.indexOf(' ') + 1)).sorted()
		 * .forEach(landnaam -> System.out.println(landnaam)); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		/*
		 * // 1.7 try (Stream<String> stream = Files.lines(ALBUMSARTISTS_PATH))
		 * { stream.map(regel -> regel.substring(regel.indexOf(',') +
		 * 1)).distinct().sorted() .forEach(artiest ->
		 * System.out.println(artiest)); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */

		/*
		 * // 1.8 try (Stream<String> stream = Files.lines(ALBUMSARTISTS_PATH))
		 * { Map<String, List<String>> artiestenEnHunAlbums = stream
		 * .collect(Collectors.groupingBy(lijn ->
		 * lijn.substring(lijn.indexOf(',') + 1)));
		 * artiestenEnHunAlbums.entrySet().stream() .sorted((entry1, entry2) ->
		 * entry1.getKey().compareTo(entry2.getKey())) .forEach(entry -> {
		 * System.out.println(entry.getKey()); entry.getValue().stream()
		 * .map(regel -> regel.substring(0, regel.indexOf(','))) .sorted()
		 * .forEach(album -> System.out.println("\t " + album)); });
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		/*
		 *  // 1.9
		List<Rechthoek> rechthoeken = Arrays.asList(new Rechthoek(3, 2), new Rechthoek(4, 5), new Rechthoek(2, 3), new Rechthoek(1, 6));
		OptionalInt kleinsteOppervlakte = rechthoeken.stream()
				.mapToInt(rechthoek -> rechthoek.getOppervlakte())
				.min();
		kleinsteOppervlakte.ifPresent(oppervlakte -> {
			System.out.println(oppervlakte);
			rechthoeken.stream()
					.filter(rechthoek -> rechthoek.getOppervlakte() == oppervlakte)
					.forEach(rechthoek -> System.out.println(rechthoek));
		});
		*/
		
		/*
		// 1.10
		try (Stream<String> stream = Files.lines(LANDCODES_PATH)){
			stream.map(regel -> regel.substring(regel.indexOf(' ') + 1))
			.max((land1, land2) -> land1.compareToIgnoreCase(land2))
			.ifPresent(land -> System.out.println(land));
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		try (Stream<String> stream = Files.lines(STERRENBEELDEN_PATH)){
			stream.map(String::toUpperCase).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Optional<String> haalLandnaam(String code) {
		try (BufferedReader reader = Files.newBufferedReader(LANDCODES_PATH)) {
			for (String regel; (regel = reader.readLine()) != null;) {
				if (!regel.isEmpty() && regel.toLowerCase().startsWith(code.toLowerCase())) {
					return Optional.of(regel.substring(3));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
