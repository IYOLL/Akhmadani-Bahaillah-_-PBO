public class Mahasiswa {
    private String name;
    private String nim;
    private String jurusan;
    private static String universitas = "Universitas Muhammadiyah Malang";

    public Mahasiswa(String name, String nim, String jurusan) {
        this.name = name;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public String getjurusan() {
        return jurusan;
    }

    public static void tampilUniversitas() {
        System.out.println("" + universitas);
    }
}