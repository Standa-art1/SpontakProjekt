public record Pojistenec(String jmeno, String prijmeni, int vek, String telefon) {
    @Override public String toString() {
        return String.format("Jméno: %s, Příjmení: %s, Věk: %d, Telefon: %s", jmeno, prijmeni, vek, telefon);
    }
}