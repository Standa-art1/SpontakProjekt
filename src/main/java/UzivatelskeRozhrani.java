import java.util.*;

public class UzivatelskeRozhrani {
    private Scanner sc = new Scanner(System.in);
    private EvidencePojistencu evidence = new EvidencePojistencu();

    public void spustit() {
        while (true) {
            int volba;
            while (true) {
            System.out.println("Vyberte si akce:");
            System.out.println("1 - Přidat noveho pojisteneho");
            System.out.println("2 - Vypsat všechne pojistene");
            System.out.println("3 - Vyhledat pojisteneho");
            System.out.println("4 - Konec");
                String input = sc.nextLine().trim();
                if (input.matches("[1-4]")) {
                    volba = Integer.parseInt(input);
                    break;
                }
                System.out.println("Neplatná volba, zadejte číslo 1-4.");
            }
            switch (volba) {
                case 1 -> pridejPojistence();
                case 2 -> evidence.vypisPojistence();
                case 3 -> vyhledejPojistence();
                case 4 -> {
                    return;
                }
            }
        }
    }
    private void pridejPojistence() {
        System.out.println("Jméno:"); String jmeno = sc.nextLine().trim();
        System.out.println("Příjmení:"); String prijmeni = sc.nextLine().trim();
        System.out.println("Věk:");
        int vek;
        while (true) {
            try {
                String vekInput = sc.nextLine().trim();
                vek = Integer.parseInt(vekInput);
                if (vek < 0 || vek > 150) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Neplatný vstup. Zadejte věk mezi 0-150.");
            }
        }
        System.out.println("Telefon:");
        String telefon;
        while (true) {
            telefon = sc.nextLine().trim();
            if (telefon.matches("\\d{9,13}")) break;
            System.out.println("Telefon musí obsahovat 9-13 číslic.");
        }

        if (jmeno.isEmpty() || prijmeni.isEmpty() || telefon.isEmpty()) {
            System.out.println("Jméno, příjmení a telefon nesmí být prázdné.");
            return;
        }
        if (!jmeno.matches("[\\p{L}]{3,50}") || !prijmeni.matches("[\\p{L}]{3,50}")) {
            System.out.println("Jméno a příjmení musí obsahovat pouze písmena a mít 3-50 znaků.");
            return;
        }

        evidence.pridejPojistence(jmeno, prijmeni, vek, telefon);
        System.out.println("Data byla uložena, pokračujte libovolnou klávesou ...");
        sc.nextLine();
    }
    private void vyhledejPojistence() {
        System.out.print("Jméno: "); String jmeno = sc.nextLine();
        System.out.print("Příjmení: "); String prijmeni = sc.nextLine();
        Pojistenec pojistenec = evidence.vyhledejPojistence(jmeno, prijmeni);
        System.out.println(pojistenec != null ? pojistenec : "Pojištěnec nenalezen.");
        System.out.println("Pokračujte libovolnou klávesou ...");
        sc.nextLine();
    }
}
