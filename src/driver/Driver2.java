//12S24042_Ventyola Rohati Napitupulu

import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input jumlah data
        System.out.print("Masukkan jumlah data (N): ");
        int N = input.nextInt();

        int[] nilai = new int[N];

        // Input deret nilai
        System.out.println("Masukkan deret nilai:");
        for (int i = 0; i < N; i++) {
            nilai[i] = input.nextInt();
        }

        // Input kode kelompok
        System.out.print("Masukkan kode kelompok (L/P): ");
        char kode = input.next().toUpperCase().charAt(0);

        int total = 0;

        for (int i = 0; i < N; i++) {

            // Pola rak tersusun rapat:
            // Index genap = P
            // Index ganjil = L

            if (kode == 'P' && i % 2 == 0) {
                total += nilai[i];
            }
            else if (kode == 'L' && i % 2 != 0) {
                total += nilai[i];
            }
        }

        System.out.println("Total nilai kelompok " + kode + " adalah: " + total);

        input.close();
    }
}