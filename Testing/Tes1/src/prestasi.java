public class prestasi extends siswa {

  public prestasi(String nama, String nis, String jenisKelamin) {
    super(nama, nis, jenisKelamin);
    //TODO Auto-generated constructor stub
  }

  @Override
  public void sapaan(){
    System.out.println("Halo Siswa Prestasi");
  }

  public double hitungRataRata(){
    return 0;
  }
}
