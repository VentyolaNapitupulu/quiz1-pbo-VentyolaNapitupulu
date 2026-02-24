// 12S24042_Ventyola Rohati Napitupulu
// Sistem Pencatatan dan Laporan Harian Cucian Mahasiswa
import java.util.ArrayList;
import java.util.Scanner;

class LaundryItem {
    private String namaMahasiswa;
    private String tanggalMasuk;
    private String status; // "DICUCI" atau "SELESAI"

    public LaundryItem(String namaMahasiswa, String tanggalMasuk) {
        this.namaMahasiswa = namaMahasiswa;
        this.tanggalMasuk = tanggalMasuk;
        this.status = "DICUCI"; // default saat masuk
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tampilkanInfo() {
        System.out.println("- " + namaMahasiswa + " - " + status);
    }
}

public class Driver3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<LaundryItem> daftarCucian = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Laundry Del ---");
            System.out.println("1. Tambah Cucian");
            System.out.println("2. Update Status Cucian");
            System.out.println("3. Laporan Harian");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int menu = sc.nextInt();
            sc.nextLine(); // buang newline

            switch (menu) {
                case 1:
                    System.out.print("Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Tanggal Masuk (dd-mm-yyyy): ");
                    String tanggal = sc.nextLine();
                    LaundryItem cucian = new LaundryItem(nama, tanggal);
                    daftarCucian.add(cucian);
                    System.out.println("Cucian berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.print("Nama Mahasiswa untuk update: ");
                    String namaUpdate = sc.nextLine();
                    boolean ditemukan = false;
                    for (LaundryItem item : daftarCucian) {
                        if (item.getNamaMahasiswa().equalsIgnoreCase(namaUpdate)) {
                            item.setStatus("SELESAI");
                            System.out.println("Status cucian berhasil diupdate menjadi SELESAI!");
                            ditemukan = true;
                            break;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Cucian tidak ditemukan!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Laporan Harian ---");
                    System.out.println("Total cucian masuk hari ini: " + daftarCucian.size());
                    System.out.println("Cucian yang belum selesai:");
                    for (LaundryItem item : daftarCucian) {
                        if (item.getStatus().equals("DICUCI")) {
                            item.tampilkanInfo();
                        }
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan Laundry Del!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }

        sc.close();
    }
}