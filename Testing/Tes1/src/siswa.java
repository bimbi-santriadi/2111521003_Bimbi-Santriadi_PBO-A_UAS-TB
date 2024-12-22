public class siswa {
    private String nama;
    private String nis;
    private String jenisKelamin;

    public siswa(String nama, String nis, String jenisKelamin) {
        this.nama = nama;
        this.nis = nis;
        this.jenisKelamin = jenisKelamin;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNis(String nis) {
        this.nis = nis;
    }
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public String getNama() {
        return nama;
    }
    public String getNis() {
        return nis;
    }
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void sapaan(){}
    

    

}
