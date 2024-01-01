public class PesananCuciSepatu {

    private String namaPelanggan;
    private int jumlahSepatu;

    public PesananCuciSepatu(String namaPelanggan, int jumlahSepatu) {
        this.namaPelanggan = namaPelanggan;
        this.jumlahSepatu = jumlahSepatu;
    }

    public int hitungBiaya() {
        // Misalnya, biaya per sepatu adalah 10000 Rupiah
        return jumlahSepatu * 10000;
    }

    @Override
    public String toString() {
        return "Pelanggan: " + namaPelanggan + ", Jumlah Sepatu: " + jumlahSepatu +
                ", Biaya: " + hitungBiaya() + " Rupiah";
    }
}
