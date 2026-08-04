import java.sql.*;
public class PgProbe {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:postgresql://localhost:5432/sistema_contabil_teste";
    String user = "postgres";
    String pass = "admin";
    try (Connection c = DriverManager.getConnection(url, user, pass)) {
      System.out.println("CONNECTED");
      try (Statement st = c.createStatement(); ResultSet rs = st.executeQuery("SELECT current_database()")) { while (rs.next()) System.out.println(rs.getString(1)); }
      try (Statement st = c.createStatement(); ResultSet rs = st.executeQuery("SELECT current_schema()")) { while (rs.next()) System.out.println(rs.getString(1)); }
      try (Statement st = c.createStatement(); ResultSet rs = st.executeQuery("SHOW search_path")) { while (rs.next()) System.out.println(rs.getString(1)); }
      try (Statement st = c.createStatement(); ResultSet rs = st.executeQuery("SELECT table_schema, table_name FROM information_schema.tables WHERE table_type = 'BASE TABLE' ORDER BY table_schema, table_name")) {
        while (rs.next()) System.out.println(rs.getString(1) + "\t" + rs.getString(2));
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
