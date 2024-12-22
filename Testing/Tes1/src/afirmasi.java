public class afirmasi extends siswa implements seleksiNilai {
  private Double ipa;
  private Double ips;
  private Double bind;
  private Double bing;


  public afirmasi(String nama, String nis, String jenisKelamin, Double ipa, Double ips
  ,Double bind, Double bing) {
    super(nama, nis, jenisKelamin);
    this.ipa = ipa;
    this.ips = ips;
    this.bind = bind;
    this.bing = bing;
    
  }

  @Override
  public double hitungRataRata() {
    Double rataRata = (bind+bing+ipa+ips)/2;
    return rataRata;
  }

  public Double getIpa() {
    return ipa;
  }

  public Double getIps() {
    return ips;
  }

  public Double getBind() {
    return bind;
  }

  public Double getBing() {
    return bing;
  }

  @Override
  public void sapaan(){
    System.out.println("Halo Siswa Afirmasi");
  }
  
}
