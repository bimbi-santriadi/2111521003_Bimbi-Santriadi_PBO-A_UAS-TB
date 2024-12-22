import java.sql.*;
import java.util.*;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        database db = new database();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Date d1 = new Date();
        siswa[] prestasi = new prestasi[25];
        siswa[] umum = new umum[50];
        siswa[] afirmasi = new afirmasi[25];
        int p=0, u=0, a=0;

        System.out.println("======== SELAMAT DATANG DI ========");
        Boolean menu = true;
        while (menu) {
            System.out.println("Program Pendaftaran SMA KEBANGSAAN");
            System.out.println("===================================");
            System.out.println("== " + d1.toString() + " ===");
            System.out.println("=========== Menu Utama ============");
            System.out.println("1. Tampilkan Daftar Siswa");
            System.out.println("2. Tambah Siswa");
            System.out.println("3. Hapus Siswa");
            System.out.println("4. Edit Siswa");
            System.out.println("5. Keluar");
            System.out.println("===================================");


            System.out.print("Masukan Pilihan : ");
            int pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    db.select_seluruh_siswa();
                    break;
                case 2:
                    System.out.println("===================================");
                    System.out.println("=========== TAMBAH SISWA ==========");
                    String namatest = sc1.nextLine();
                    System.out.print("Nama \t\t : ");
                    String nama = sc1.nextLine();
                    System.out.print("NIS \t\t : ");
                    String NIS = sc1.nextLine();
                    System.out.print("Jenis Kelamin (L/P) \t : ");
                    String jenisKelamin = sc1.nextLine();
                    System.out.println("Jalur Masuk SMA \t : ");
                    System.out.println("1. Prestasi");
                    System.out.println("2. Umum");
                    System.out.println("3. Afirmasi");
                    System.out.println("Jalur Masuk : ");
                    Boolean cek = true;
                    while (cek) {
                        int jalurMasuk = sc1.nextInt();

                        if (jalurMasuk == 1) {
                            prestasi[p] = new prestasi(nama, NIS, jenisKelamin);
                            db.tambah_siswa(prestasi[p]);
                            p++;
                            cek = false;

                        } else if (jalurMasuk == 2) {
                            System.out.print("Input Nilai Ujian Akhir \t\t");
                            System.out.print("Nilai IPA \t\t:");
                            Double ipa = sc.nextDouble();
                            System.out.print("Nilai IPS \t\t:");
                            Double ips = sc.nextDouble();
                            System.out.print("Nilai Bahasa Indonesia \t:");
                            Double bind = sc.nextDouble();
                            System.out.print("Nilai Bahasa Inggris \t:");
                            Double bing = sc.nextDouble();

                            umum[u] = new umum(nama, NIS, jenisKelamin, ipa, ips, bind, bing);
                            db.tambah_siswa(umum[u]);
                            u++;
                            cek = false;

                        } else if (jalurMasuk == 3) {
                            System.out.print("Input Nilai Ujian Akhir");
                            System.out.print("Nilai IPA \t\t:");
                            Double ipa = sc.nextDouble();
                            System.out.print("Nilai IPS \t\t:");
                            Double ips = sc.nextDouble();
                            System.out.print("Nilai Bahasa Indonesia \t:");
                            Double bind = sc.nextDouble();
                            System.out.print("Nilai Bahasa Inggris \t:");
                            Double bing = sc.nextDouble();

                            afirmasi[a] = new afirmasi(nama, NIS, jenisKelamin, ipa, ips, bind, bing);
                            db.tambah_siswa(afirmasi[a]);
                            a++;
                            cek = false;

                        } else {
                            System.out.println("Pilihan Tidak Tersedia");
                        }

                    }

                    break;

                case 3:
                    System.out.println("===================================");
                    System.out.println("=========== TAMBAH SISWA ==========");
                    System.out.println("Masukan NIM : ");
                    var hapusNim = sc.next();

                    db.hapus_siswa(hapusNim);
                    break;

                    case 4:
    System.out.println("===================================");
    System.out.println("============ EDIT SISWA ===========");
    sc.nextLine(); // Membersihkan buffer
    System.out.print("Masukkan NIS yang ingin diedit: ");
    String cariNis = sc.nextLine();
    
    boolean found = false;

    // Edit di array prestasi
    for (int i = 0; i < p; i++) {
        if (cariNis.equals(prestasi[i].getNis())) {
            System.out.println("NIS ditemukan di jalur Prestasi.");
            System.out.print("Masukkan Nama Baru: ");
            String namaBaru = sc.nextLine();
            prestasi[i].setNama(namaBaru);
            System.out.print("Masukkan Jenis Kelamin Baru: ");
            String jkBaru = sc.nextLine();
            prestasi[i].setJenisKelamin(jkBaru);
            db.update_siswa(prestasi[i], cariNis);
            found = true;
            break;
        }
    }

    // Edit di array umum
    for (int i = 0; i < u; i++) {
        if (cariNis.equals(umum[i].getNis())) {
            System.out.println("NIS ditemukan di jalur Umum.");
            System.out.print("Masukkan Nama Baru: ");
            String namaBaru = sc.nextLine();
            umum[i].setNama(namaBaru);
            System.out.print("Masukkan Jenis Kelamin Baru: ");
            String jkBaru = sc.nextLine();
            umum[i].setJenisKelamin(jkBaru);
            db.update_siswa(umum[i], cariNis);
            found = true;
            break;
        }
    }

    // Edit di array afirmasi
    for (int i = 0; i < a; i++) {
        if (cariNis.equals(afirmasi[i].getNis())) {
            System.out.println("NIS ditemukan di jalur Afirmasi.");
            System.out.print("Masukkan Nama Baru: ");
            String namaBaru = sc.nextLine();
            afirmasi[i].setNama(namaBaru);
            System.out.print("Masukkan Jenis Kelamin Baru: ");
            String jkBaru = sc.nextLine();
            afirmasi[i].setJenisKelamin(jkBaru);
            db.update_siswa(afirmasi[i], cariNis);
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("NIS tidak ditemukan di semua jalur.");
    }
    break;

                

                case 5:
                    menu=false;
                    break;

                default:
                    System.out.println("Menu tidak teredia!");
                    break;
            }

        }

        System.out.println("===================================");
        System.out.println("========= TERIMA KASIH ============");

    }

}