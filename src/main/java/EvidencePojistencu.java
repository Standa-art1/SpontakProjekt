import java.util.*;
public class EvidencePojistencu {
    private List<Pojistenec> pojistenci = new ArrayList<>();
    public void pridejPojistence(String jmeno, String prijmeni, int vek, String telefon) {
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telefon));
    }

    /**
     * vrat pojištence
     * @return
     */
    public List<Pojistenec> vratPojistence() {
       return pojistenci;
    }
    public Pojistenec vyhledejPojistence(String jmeno, String prijmeni) {
        return pojistenci.stream().filter(poj -> poj.jmeno().equalsIgnoreCase(jmeno) && poj.prijmeni().equalsIgnoreCase(prijmeni)).findFirst().orElse(null);
    }
}