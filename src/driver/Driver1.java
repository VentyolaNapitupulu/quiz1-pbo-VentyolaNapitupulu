//12S24042_Ventyola Rohati Napitupulu

import java.util.*;

public class Driver1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Data Menu
        Map<String, String> namaMenu = new HashMap<>();
        Map<String, Integer> hargaMenu = new HashMap<>();

        namaMenu.put("NGS", "Nasi Goreng Spesial");
        hargaMenu.put("NGS", 15000);

        namaMenu.put("AP", "Ayam Penyet");
        hargaMenu.put("AP", 20000);

        namaMenu.put("SA", "Sate Ayam (10 Tusuk)");
        hargaMenu.put("SA", 25000);

        namaMenu.put("BU", "Bakso Urat");
        hargaMenu.put("BU", 18000);

        namaMenu.put("MAP", "Mie Ayam Pangsit");
        hargaMenu.put("MAP", 15000);

        namaMenu.put("GG", "Gado-Gado");
        hargaMenu.put("GG", 15000);

        namaMenu.put("SAM", "Soto Ayam");
        hargaMenu.put("SAM", 17000);

        namaMenu.put("RD", "Rendang Daging");
        hargaMenu.put("RD", 25000);

        namaMenu.put("IB", "Ikan Bakar");
        hargaMenu.put("IB", 35000);

        namaMenu.put("NUK", "Nasi Uduk Komplit");
        hargaMenu.put("NUK", 20000);

        List<String> daftarMenu = new ArrayList<>();
        List<Integer> daftarPorsi = new ArrayList<>();
        List<Integer> daftarHarga = new ArrayList<>();
        List<Integer> daftarTotal = new ArrayList<>();

        int subtotal = 0;

        while (true) {
            String kode = input.nextLine();

            if (kode.equals("END")) {
                break;
            }

            // Validasi jika kode tidak ada di menu untuk menghindari error null pointer
            if (!hargaMenu.containsKey(kode)) {
                continue;
            }

            int porsiButet = input.nextInt();
            input.nextLine(); 

            int porsiUcok = porsiButet * 2;
            int totalPorsi = porsiButet + porsiUcok;

            int harga = hargaMenu.get(kode);
            int totalHarga = totalPorsi * harga;

            daftarMenu.add(namaMenu.get(kode));
            daftarPorsi.add(totalPorsi);
            daftarHarga.add(harga);
            daftarTotal.add(totalHarga);

            subtotal += totalHarga;
        }

        // Hitung diskon
        double diskonPersen = 0;
        String kupon = "Tidak Ada";

        if (subtotal >= 500000) {
            diskonPersen = 0.25;
            kupon = "Hitam";
        } else if (subtotal >= 400000) {
            diskonPersen = 0.20;
            kupon = "Hijau";
        } else if (subtotal >= 300000) {
            diskonPersen = 0.15;
            kupon = "Merah";
        } else if (subtotal >= 200000) {
            diskonPersen = 0.10;
            kupon = "Kuning";
        } else if (subtotal >= 100000) {
            diskonPersen = 0.05;
            kupon = "Biru";
        }

        double diskon = subtotal * diskonPersen;
        double totalBayar = subtotal - diskon;

        // OUTPUT STRUK SESUAI GAMBAR
        // Format: Nama(24 karakter), Porsi(8), Harga(12), Total(rata kanan)
        System.out.printf("%-24s %-8s %-12s %s\n", "Menu", "Porsi", "Harga", "Total");
        System.out.println("======================================================");

        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.printf("%-24s %-8d %-12d %d\n",
                    daftarMenu.get(i),
                    daftarPorsi.get(i),
                    daftarHarga.get(i),
                    daftarTotal.get(i));
        }

        System.out.println("======================================================");
        
        // Bagian bawah struk dengan perataan yang rapi
        System.out.printf("%-40s %d\n", "Subtotal", subtotal);
        if (diskonPersen > 0) {
            System.out.printf("%-40s %d\n", "Diskon (" + (int)(diskonPersen * 100) + "%)", (int)diskon);
        }
        System.out.printf("%-40s %d\n", "Total Pembayaran", (int)totalBayar);
        System.out.printf("%-40s %s\n", "Kupon", kupon);

        input.close();
    }
}
