package transplant.db.jdbc;

public class SQLDelete {

			// Put connection here so it can be used in several methods
			private static Connection c;

			private static void printRequest() throws SQLException {
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM request";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					Request request = new Request(id); //TODO random
					System.out.println(request);
				}
				rs.close();
				stmt.close();
			}
			
			
			private static 	Request getRequest(int id) throws SQLException {
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM request WHERE id = "+ id;
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					Request request = new Request(id); //TODO random
					System.out.println(request);
				rs.close();
				stmt.close();
				return request;
			}

			/*public static void main(String args[]) {
				try {
					// Open database connection
					Class.forName("org.sqlite.JDBC");
					// Note that we are using the class' connection
					c = DriverManager.getConnection("jdbc:sqlite:./db/company.db");
					c.createStatement().execute("PRAGMA foreign_keys=ON");
					System.out.println("Database connection opened.");

					// Remove an employee: beginning
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("Choose an employee to delete, type its ID: ");
					printEmployees();
					int dep_id = Integer.parseInt(reader.readLine());
					String sql = "DELETE FROM employees WHERE id=?";
					PreparedStatement prep = c.prepareStatement(sql);
					prep.setInt(1, dep_id);
					prep.executeUpdate();
					System.out.println("Deletion finished.");
					// Remove an employee: end

					// Close database connection
					c.close();
					System.out.println("Database connection closed.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}*/
		}
	}


}
