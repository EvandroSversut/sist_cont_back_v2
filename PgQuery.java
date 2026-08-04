import java.sql.*;
public class PgQuery {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:postgresql://localhost:5432/sistema_contabil_teste";
    String user = "postgres";
    String pass = "admin";
    String sql = "SELECT table_schema, table_name FROM information_schema.tables WHERE lower(table_name) LIKE '%icms%' OR lower(table_name) LIKE '%pis%' OR lower(table_name) LIKE '%cofins%' OR lower(table_name) LIKE '%ipi%' OR lower(table_name) LIKE '%ibs%' OR lower(table_name) LIKE '%cbs%' OR lower(table_name) LIKE '%imposto%';";
    try (Connection c = DriverManager.getConnection(url, user, pass);
         Statement st = c.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
      while (rs.next()) {
        System.out.println(rs.getString(1) + "\t" + rs.getString(2));
      }
    }
  }
}
