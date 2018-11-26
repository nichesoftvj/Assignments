package assignm6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MysqlPhoneBook {

	/**
	 * @func - makes connection to mysql using jdbc driver manager interface
	 * @return - Connection
	 * @throws Exception
	 */
	public Connection connection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/assignm6";

		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "newrootpassword");
		properties.setProperty("useSSL", "false");
		Connection conn = DriverManager.getConnection(url, properties);
		return conn;
	}

	/**
	 * @func - add person to database
	 * @param person
	 *            - person object
	 */
	public void addPerson(Person person) {
		try {
			Connection conn = connection();
			PreparedStatement preparedStmt = conn.prepareStatement(
					"INSERT INTO phone_book (id,number,first_name,last_name,address1,address2,city,state,country) VALUES (?,?,?,?,?,?,?,?,?)");

			preparedStmt.setInt(1, person.getId());
			preparedStmt.setString(2, person.getNumber());
			preparedStmt.setString(3, person.getFirst_name());
			preparedStmt.setString(4, person.getLast_name());
			preparedStmt.setString(5, person.getAddress1());
			preparedStmt.setString(6, person.getAddress2());
			preparedStmt.setString(7, person.getCity());
			preparedStmt.setString(8, person.getState());
			preparedStmt.setString(9, person.getCountry());
			int i = preparedStmt.executeUpdate();
			System.out.println(String.format(i + " %s", "record inserted"));
			preparedStmt.close();
			conn.close();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	/**
	 * @func - delete person from database
	 * @param person
	 *            - person object
	 */
	public void delete(Person person) {
		String query = String.format("Delete from phone_book where id=%d", person.getId());
		try {
			Connection conn = connection();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			int i = preparedStmt.executeUpdate();
			System.out.println(String.format(i + " %s", "record deleted"));
			preparedStmt.close();
			conn.close();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	/**
	 * @func - update person of database
	 * @param person
	 *            - person object
	 */
	public void update(Person person) {
		try {
			Connection conn = connection();
			String query = String.format(
					"UPDATE phone_book set number=?, first_name=?, last_name=?, address1=?, address2=?, city=?, state=?, country=? WHERE id=%d",
					person.getId());
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, "91919197");
			preparedStmt.setString(2, "Abdul");
			preparedStmt.setString(3, "Kalaam");
			preparedStmt.setString(4, "H74");
			preparedStmt.setString(5, "5thcross");
			preparedStmt.setString(6, "Banglore");
			preparedStmt.setString(7, "Karnataka");
			preparedStmt.setString(8, "India");
			int i = preparedStmt.executeUpdate();
			System.out.println(String.format(i + " %s", "record updated"));
			conn.close();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	/**
	 * @func partialFind - finds the person object using its any one or more
	 *       parameters
	 * @param person
	 *            - person object
	 * @return resultSet - table of data returned by a sql statement
	 */
	public ResultSet partialFind(Person person) {
		ResultSet resultSet = null;
		String query = null;

		try {
			Connection conn = connection();
			Statement stmt = conn.createStatement();
			query = String.format(
					"SELECT * from phone_book WHERE id='%s' OR number='%s' OR first_name='%s' OR last_name='%s' OR address1='%s' OR address2='%s' OR city='%s' OR state='%s' OR country='%s'",
					person.getId(), person.getNumber(), person.getFirst_name(), person.getLast_name(),
					person.getAddress1(), person.getAddress2(), person.getCity(), person.getState(),
					person.getCountry());
			resultSet = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;

	}

	/**
	 * @func - find person from database
	 * @param person
	 *            - person object
	 * @return - resultSet
	 */
	public ResultSet find(Person person) {
		ResultSet resultSet = null;
		String query = String.format("SELECT * from phone_book WHERE id=%d", person.getId());
		resultSet = executeQuery(resultSet, query);
		return resultSet;
	}

	/**
	 * @func - executes query and returns resultset
	 * @param resultSet
	 *            - set of columns and rows value representing a table
	 * @param query
	 *            - command used to access table
	 * @return - resultSet
	 */
	public ResultSet executeQuery(ResultSet resultSet, String query) {
		try {
			Connection conn = connection();
			Statement stmt = conn.createStatement();
			resultSet = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * @func - checks the order in which the resultset has to be sorted
	 * @param ascending
	 *            - order to sort the list
	 * @return
	 */
	public String checkSortingOrder(boolean ascending) {
		String order;
		if (ascending) {
			order = "ASC";
		} else {
			order = "DESC";
		}
		return order;
	}

	/**
	 * @func - finds person using number field value
	 * @param number
	 *            - non empty string
	 * @param sortField
	 *            - string refering a field
	 * @param ascending
	 *            - - order to sort the list
	 * @return - table of data returned by a sql statement
	 */
	public ResultSet findByNumber(String number, String sortField, boolean ascending) {
		ResultSet resultSet = null;
		String order;
		if (number != null) {
			order = checkSortingOrder(ascending);
			String query = String.format("SELECT * from phone_book WHERE number LIKE '%%%s%%' ORDER BY %s %s", number,
					sortField, order);
			resultSet = executeQuery(resultSet, query);
		}
		return resultSet;
	}

	/**
	 * @func - finds person using last_name field value
	 * @param last_name
	 *            - non empty string
	 * @param sortField
	 *            - string refering a field
	 * @param ascending
	 *            - - order to sort the list
	 * @return resultSet
	 */
	public ResultSet findByLastName(String last_name, String sortField, boolean ascending) {
		ResultSet resultSet = null;
		String order;
		if (last_name != null) {
			order = checkSortingOrder(ascending);
			String query = String.format("SELECT * from phone_book WHERE last_name LIKE '%%%s%%' ORDER BY %s %s",
					last_name, sortField, order);

			resultSet = executeQuery(resultSet, query);
		}
		return resultSet;
	}

	/**
	 * @func - finds person using first_name field value
	 * @param first_name
	 *            - non empty string
	 * @param sortField
	 *            - string refering a field
	 * @param ascending
	 *            - order to sort the list
	 * @return - resultSet
	 */
	public ResultSet findByFirstName(String first_name, String sortField, boolean ascending) {
		ResultSet resultSet = null;
		String order;
		if (first_name != null) {
			order = checkSortingOrder(ascending);
			String query = String.format("SELECT * from phone_book WHERE first_name LIKE '%%%s%%' ORDER BY %s %s",
					first_name, sortField, order);
			resultSet = executeQuery(resultSet, query);
		}
		return resultSet;
	}

	static String addressQuery = null;

	/**
	 * @func - finds person using address1,address2,city,state and country field
	 *       value
	 * @param address1
	 *            - non empty String
	 * @param address2
	 *            - non empty String
	 * @param city
	 *            - non empty String
	 * @param state
	 *            - non empty String
	 * @param country
	 *            - non empty String
	 * @param sortField
	 *            - string refering a field
	 * @param ascending
	 *            - order to sort the list
	 * @return - resultSet
	 */
	public ResultSet findByAddress(String address1, String address2, String city, String state, String country,
			String sortField, boolean ascending) {
		ResultSet resultSet = null;
		String order;
		order = checkSortingOrder(ascending);

		try {
			Connection conn = connection();
			Statement stmt = conn.createStatement();

			int flag = 0;
			addressQuery = "SELECT * FROM phone_book WHERE";

			if (address1 != null) {
				addressQuery = getAddressQuery(flag, address1, "address1");
				flag = 1;
			}
			if (address2 != null) {
				addressQuery = getAddressQuery(flag, address2, "address2");
				flag = 1;
			}
			if (city != null) {
				addressQuery = getAddressQuery(flag, city, "city");
				flag = 1;
			}
			if (state != null) {
				addressQuery = getAddressQuery(flag, state, "state");
				flag = 1;
			}
			if (country != null) {
				addressQuery = getAddressQuery(flag, country, "country");
			}
			addressQuery = addressQuery + " " + "ORDER BY" + " " + sortField + " " + order;
			resultSet = stmt.executeQuery(addressQuery);
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * @func - creates query
	 * @param flag
	 *            - integer value(0,1) representing set or reset
	 * @param columnValue
	 *            - string value of columnName
	 * @param columnName
	 *            - string name of the table
	 * @return - resultSet
	 */
	public String getAddressQuery(int flag, String columnValue, String columnName) {
		if (flag == 1) {
			addressQuery += " " + "AND" + " " + columnName + "=" + "'" + columnValue + "'";
		} else {
			addressQuery += " " + columnName + "=" + "'" + columnValue + "'";
		}
		return addressQuery;
	}

	/**
	 * @func - using a data checks the matching person by searching all the
	 *       columns and fields
	 * @param data
	 *            - string to be searched
	 * @return - resultSet
	 */
	public ResultSet search(String data) {
		ResultSet resultSet = null;
		try {
			Connection conn = connection();
			String query = String.format(
					"SELECT * FROM phone_book WHERE number=? OR first_name=? OR last_name=? OR address1=? OR address2=? OR city=? OR state=? OR country=?");
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, data);
			preparedStmt.setString(2, data);
			preparedStmt.setString(3, data);
			preparedStmt.setString(4, data);
			preparedStmt.setString(5, data);
			preparedStmt.setString(6, data);
			preparedStmt.setString(7, data);
			preparedStmt.setString(8, data);
			resultSet = preparedStmt.executeQuery();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return resultSet;
	}
}