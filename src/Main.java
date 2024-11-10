public class Main {
    private static Menu makanan1 = new Menu("Nasi Goreng", 25000, "makanan");
    private static Menu makanan2 = new Menu("Mie Goreng", 20000, "makanan");
    private static Menu makanan3 = new Menu("Nasi Padang", 30000, "makanan");
    private static Menu makanan4 = new Menu("Sate Ayam", 22000, "makanan");

    private static Menu minuman1 = new Menu("Es Teh", 5000, "minuman");
    private static Menu minuman2 = new Menu("Es Jeruk", 8000, "minuman");
    private static Menu minuman3 = new Menu("Es Degan", 15000, "minuman");
    private static Menu minuman4 = new Menu("Kopi", 5000, "minuman");

    public static void main(String[] args) {
        tampilkanMenu();

        Pesanan pesanan = new Pesanan();
        pesanan.tambahPesanan("Nasi Goreng", 2);
        pesanan.tambahPesanan("Sate Ayam", 1);
        pesanan.tambahPesanan("Es Teh", 1);
        pesanan.tambahPesanan("Es Jeruk", 2);

        cetakStruk(pesanan);
    }

    private static void tampilkanMenu() {
        System.out.println("===DAFTAR MENU===");

        System.out.println("MAKANAN");
        System.out.printf("%s\tRp %,d\n", makanan1.getNama(), makanan1.getHarga());
        System.out.printf("%s\tRp %,d\n", makanan2.getNama(), makanan2.getHarga());
        System.out.printf("%s\tRp %,d\n", makanan3.getNama(), makanan3.getHarga());
        System.out.printf("%s\tRp %,d\n", makanan4.getNama(), makanan4.getHarga());

        System.out.println("MINUMAN");
        System.out.printf("%s\tRp %,d\n", minuman1.getNama(), minuman1.getHarga());
        System.out.printf("%s\tRp %,d\n", minuman2.getNama(), minuman2.getHarga());
        System.out.printf("%s\tRp %,d\n", minuman3.getNama(), minuman3.getHarga());
        System.out.printf("%s\tRp %,d\n", minuman4.getNama(), minuman4.getHarga());


    }

    static class Pesanan {
        private String[] menuPesanan = new String[4];
        private int[] jumlahPesanan = new int[4];
        private int index = 0;

        public void tambahPesanan(String namaMenu, int jumlah) {
            if (index < 4) {
                menuPesanan[index] = namaMenu;
                jumlahPesanan[index] = jumlah;
                index++;
            }
        }

        public String getMenu(int index) {
            return menuPesanan[index];
        }

        public int getJumlah(int index) {
            return jumlahPesanan[index];
        }
    }

    private static int hitungHargaMenu(String namaMenu) {
        if (namaMenu.equals(makanan1.getNama())) return makanan1.getHarga();
        if (namaMenu.equals(makanan2.getNama())) return makanan2.getHarga();
        if (namaMenu.equals(makanan3.getNama())) return makanan3.getHarga();
        if (namaMenu.equals(makanan4.getNama())) return makanan4.getHarga();

        if (namaMenu.equals(minuman1.getNama())) return minuman1.getHarga();
        if (namaMenu.equals(minuman2.getNama())) return minuman2.getHarga();
        if (namaMenu.equals(minuman3.getNama())) return minuman3.getHarga();
        if (namaMenu.equals(minuman4.getNama())) return minuman4.getHarga();

        return 0;
    }

    private static void cetakStruk(Pesanan pesanan) {
        System.out.println("\n=== STRUK PEMBAYARAN");

        int subTotal = 0;
        if (pesanan.getMenu(0) != null) {
            int harga = hitungHargaMenu(pesanan.getMenu(0));
            int total = harga * pesanan.getJumlah(0);
            subTotal += total;
            System.out.printf("%s\t%d\tRp %,d\tRp %,d\n",
                    pesanan.getMenu(0), pesanan.getJumlah(0), harga, total);

        }
        if (pesanan.getMenu(1) != null) {
            int harga = hitungHargaMenu(pesanan.getMenu(1));
            int total = harga * pesanan.getJumlah(1);
            subTotal += total;
            System.out.printf("%s\t%d\tRp %,d\tRp %,d\n",
                    pesanan.getMenu(1), pesanan.getJumlah(1), harga, total);

        }
        if (pesanan.getMenu(2) != null) {
            int harga = hitungHargaMenu(pesanan.getMenu(2));
            int total = harga * pesanan.getJumlah(2);
            subTotal += total;
            System.out.printf("%s\t%d\tRp %,d\tRp %,d\n",
                    pesanan.getMenu(2), pesanan.getJumlah(2), harga, total);

        }
        if (pesanan.getMenu(3) != null) {
            int harga = hitungHargaMenu(pesanan.getMenu(3));
            int total = harga * pesanan.getJumlah(3);
            subTotal += total;
            System.out.printf("%s\t%d\tRp %,d\tRp %,d\n",
                    pesanan.getMenu(3), pesanan.getJumlah(3), harga, total);

        }

        int pajak = (int)(subTotal * 0.1);
        int biayaLayanan = 20000;

        int diskon = 0;
        if (subTotal > 100000) {
            diskon = (int)(subTotal * 0.1);
        }

        if (subTotal > 50000) {
            System.out.println("+ Anda mendapat promo beli 1 gratis 1 untuk minuman");
        }

        int totalAkhir = subTotal + pajak + biayaLayanan - diskon;

        System.out.println("======================");
        System.out.printf("Total Pembayarab:\t\tRp %,d\n", totalAkhir);
        System.out.println("=======================");
    }
}