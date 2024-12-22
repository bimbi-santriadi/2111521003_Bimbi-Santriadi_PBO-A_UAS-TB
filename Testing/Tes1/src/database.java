import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;

public class database {
    public final String driver = "com.mysql.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost/smakebangsaan";
    public final String username = "root";
    public final String password = "";

    public void tambah_siswa(siswa s) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql = "insert into siswa values('" + s.getNama() + "','" + s.getNis() + "','" +
                    s.getJenisKelamin() + "')";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception se) {
            }
        }
    }

    public void hapus_siswa(String nis) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql = "delete from siswa where nis='" + nis + "'";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception se) {
            }
        }
    }

    public void update_siswa(siswa data, String oldNis) {
        Connection conn = null; // Tambahkan deklarasi conn
        PreparedStatement stmt = null; // Tambahkan deklarasi PreparedStatement
        try {
            conn = DriverManager.getConnection(url, username, password); // Pastikan koneksi dibuat di awal
            String query = "UPDATE siswa SET nama = ?, jenis_kelamin = ? WHERE nis = ?";
            stmt = conn.prepareStatement(query); // Pastikan menggunakan conn
            stmt.setString(1, data.getNama());
            stmt.setString(2, data.getJenisKelamin());
            stmt.setString(3, oldNis); // Nis dari parameter
            
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data berhasil diperbarui.");
            } else {
                System.out.println("Tidak ada data yang diperbarui.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close(); // Tutup statement
                if (conn != null) conn.close(); // Tutup koneksi
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    


    public void select_seluruh_siswa() {
        ArrayList<siswa> listsiswa = new ArrayList<siswa>();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql = "select nis,nama,jeniskelamin from siswa";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listsiswa.add(new siswa(rs.getString("Nama"), rs.getString("NIS"),
                rs.getString("JenisKelamin")));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception se) {
            }
        }
        
        System.out.println();
        System.out.println("|NAMA \t |NIS \t |JK \t |");
        for(siswa siswa1: listsiswa){
            System.out.println(
                "|"+siswa1.getNama()+"\t |"+
                siswa1.getNis()+"\t |"+
                siswa1.getJenisKelamin()+"\t |"
            );
        }
    }
}
