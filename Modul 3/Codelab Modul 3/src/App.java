import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Input for Balok
        System.out.println("Input for Balok:");
        Balok balok = new Balok("balok");
        balok.inputNilai();
        System.out.println("Luas permukaan balok: " );
        balok.luasPermukaan();
        System.out.println("Volume balok: ");
        balok.volume();

        // Input for Kubus
        System.out.println("\nInput for Kubus:");
        Kubus kubus = new Kubus("kubus");
        kubus.inputNilai();
        System.out.println("Luas permukaan kubus: ");
        kubus.luasPermukaan();
        System.out.println("Volume kubus: ");
        kubus.volume();

        // Input for Tabung
        System.out.println("\nInput for Tabung:");
        Tabung tabung = new Tabung("tabung");
        tabung.inputNilai();
        System.out.println("Luas permukaan tabung: ");
        tabung.luasPermukaan();
        System.out.println("Volume tabung: ");
        tabung.volume();

        scanner.close();
    }
}
