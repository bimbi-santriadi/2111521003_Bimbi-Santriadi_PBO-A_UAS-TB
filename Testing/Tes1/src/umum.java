public class umum extends siswa implements seleksiNilai{
  private Double ipa;
  private Double ips;
  private Double bind;
  private Double bing;

  public umum(String nama, String nis, String jenisKelamin, Double ipa, Double ips
  ,Double bind, Double bing) {
    super(nama, nis, jenisKelamin);
    //TODO Auto-generated constructor stub
    this.ipa = ipa;
    this.ips = ips;
    this.bind = bind;
    this.bing = bing;
    
  }

  @Override
  public double hitungRataRata() {
    Double rataRata = (bind+bing+ipa+ips)/4;
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
    System.out.println("Halo Siswa Umum");
  }
  
}
