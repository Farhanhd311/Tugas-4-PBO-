import java.util.Scanner;

// Parent class Barang (Inheritance akan dilakukan di kelas anak)
class Barang {
    protected String kodeBarang;
    protected String namaBarang;
    protected double hargaBarang;

    // Constructor Barang
    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }
}

// Subclass Faktur (Inheritance dari Barang)
class Faktur extends Barang {
    private String noFaktur;
    private int jumlahBeli;

    // Constructor Faktur yang mewarisi constructor dari parent (Barang)
    public Faktur(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang); // Menggunakan constructor parent (Barang)
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
    }

    // Method untuk menghitung total harga
    public double hitungTotal() {
        return hargaBarang * jumlahBeli;
    }

    // Method untuk menampilkan detail faktur
    public void tampilkanFaktur() {
        System.out.println("\n=== Detail Faktur ===");
        System.out.println("No Faktur   : " + noFaktur);
        System.out.println("Kode Barang : " + kodeBarang);
        System.out.println("Nama Barang : " + namaBarang);
        System.out.println("Harga Barang: Rp " + hargaBarang);
        System.out.println("Jumlah Beli : " + jumlahBeli);
        System.out.println("Total Harga : Rp " + hitungTotal());
    }
}

// Custom Exception untuk validasi input
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

// Main class untuk menjalankan program
public class ProgramFaktur {
    // Method untuk validasi input (String)
    public static void validateInput(String input, String fieldName) throws InvalidInputException {
        if (input == null || input.trim().isEmpty()) { // Mengecek apakah input kosong
            throw new InvalidInputException(fieldName + " tidak boleh kosong.");
        }
    }

    // Method untuk validasi input (double)
    public static void validateInput(double input, String fieldName) throws InvalidInputException {
        if (input <= 0) { // Mengecek apakah input <= 0
            throw new InvalidInputException(fieldName + " harus lebih dari 0.");
        }
    }

    // Method untuk validasi input (int)
    public static void validateInput(int input, String fieldName) throws InvalidInputException {
        if (input <= 0) { // Mengecek apakah input <= 0
            throw new InvalidInputException(fieldName + " harus lebih dari 0.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input No Faktur
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();
            validateInput(noFaktur, "No Faktur"); // Validasi input No Faktur

            // Input Kode Barang
            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();
            validateInput(kodeBarang, "Kode Barang"); // Validasi input Kode Barang

            // Input Nama Barang
            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();
            validateInput(namaBarang, "Nama Barang"); // Validasi input Nama Barang

            // Input Harga Barang
            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();
            validateInput(hargaBarang, "Harga Barang"); // Validasi input Harga Barang

            // Input Jumlah Beli
            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();
            validateInput(jumlahBeli, "Jumlah Beli"); // Validasi input Jumlah Beli

            // Membuat objek Faktur dan menampilkan detailnya
            Faktur faktur = new Faktur(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
            faktur.tampilkanFaktur(); // Menampilkan detail faktur

        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage()); // Menampilkan pesan error jika input tidak valid
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage()); // Menangani kesalahan umum lainnya
        } finally {
            scanner.close(); // Menutup scanner setelah selesai
        }
    }
}
