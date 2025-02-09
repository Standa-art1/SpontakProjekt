import java.util.*;
public class EvidencePojistencu {
    private List<Pojistenec> pojistenci = new ArrayList<>();
    public void pridejPojistence(String jmeno, String prijmeni, int vek, String telefon) {
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telefon));
    }
    public void vypisPojistence() {
        pojistenci.forEach(System.out::println);
    }
    public Pojistenec vyhledejPojistence(String jmeno, String prijmeni) {
        return pojistenci.stream().filter(poj -> poj.jmeno().equalsIgnoreCase(jmeno) && poj.prijmeni().equalsIgnoreCase(prijmeni)).findFirst().orElse(null);
    }
}