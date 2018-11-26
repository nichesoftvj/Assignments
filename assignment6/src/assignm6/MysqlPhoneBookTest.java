package assignm6;

import static org.junit.Assert.*;

import java.sql.*;
import java.util.*;

import org.junit.Test;

public class MysqlPhoneBookTest {

	Person person1 = new Person(1, "99009090", "Leonard", "Hofstadter", "HN1", "HN2", "holand", "portland", "UK");
	Person person2 = new Person(2, "90909090", "viju", "park", "HN9", "HN4", "Fairview", "cooper", "UK");
	// Person person4 = new Person(4, "91919190", "Narendra", "Modi", "HN7",
	// "HN8", "Woodcrest", "sttutgard", "Germany");
	Person person5 = new Person(5, "91091010", "peter", "cooper", "HN9", "HN10", "Fairview", "sttutgard", "Germany");
	Person person12 = new Person(12, "92920192", "Barack", "Obama", "cooper", "lona_road", "Africa", "America", "USA");

	Person person9 = new Person(9, "91091010", "joy", "rimme", "HN_11", "HN2", "ishko", "madrid", "spain");
	Person person6 = new Person(6, "90909090", "alex", "rice", "FN_24", "FN_23,do3", "mercy", "paris", "France");
	Person person7 = new Person(7, "9090", "hem", "cooper", "HN1", "5thcross", "cooper", "kimo", "India");
	Person person10 = new Person(10, "9030", "hema", "kiya", "HN63", "HN64", "manhattan", "newyork", "USA");
	Person person4 = new Person(4, "91919197", "Abdul", "Kalaam", "H74", "5thcross", "Banglore", "Karnataka", "India");

	
	@Test
	public void testInsert() {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();
		ResultSet resultSet = null;
		try {
			resultSet = mysqlphonebook.find(person10);
			assertEquals(resultSet.next(), false);

			// mysqlphonebook.addPesron(person7);
			resultSet = mysqlphonebook.find(person7);

			while (resultSet.next()) {
				assertEquals(resultSet.getInt("id"), person7.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();
		ResultSet resultSet = null;
		try {
			Person person11 = new Person(11, "9090", "hem", "char", "HN101", "HN102", "Timo", "kimo", "JAPAN");
			mysqlphonebook.addPerson(person11);
			mysqlphonebook.delete(person11);
			resultSet = mysqlphonebook.find(person11);
			// this returns false if the cursor is not before the first record
			// or if there are no rows in the ResultSet.
			assertFalse(resultSet.isBeforeFirst());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();
		ResultSet resultSet = null;
		try {
			resultSet = mysqlphonebook.find(person10);
			assertEquals(resultSet.next(), false);

			mysqlphonebook.update(person4);
			resultSet = mysqlphonebook.find(person4);
			while (resultSet.next()) {
				assertEquals(resultSet.getInt("id"), 4);
				assertEquals(resultSet.getString("number"), "91919197");
				assertEquals(resultSet.getString("first_name"), "Abdul");
				assertEquals(resultSet.getString("last_name"), "Kalaam");
				assertEquals(resultSet.getString("address1"), "H74");
				assertEquals(resultSet.getString("address2"), "5thcross");
				assertEquals(resultSet.getString("city"), "Banglore");
				assertEquals(resultSet.getString("state"), "Karnataka");
				assertEquals(resultSet.getString("country"), "India");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFind() {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();
		ResultSet resultSet = null;
		try {
			resultSet = mysqlphonebook.find(person10);
			assertEquals(resultSet.next(), false);

			resultSet = mysqlphonebook.find(person4);
			while (resultSet.next()) {
				assertEquals(resultSet.getInt("id"), person4.getId());
				assertEquals(resultSet.getString("number"), person4.getNumber());
				assertEquals(resultSet.getString("first_name"), person4.getFirst_name());
				assertEquals(resultSet.getString("last_name"), person4.getLast_name());
				assertEquals(resultSet.getString("address1"), person4.getAddress1());
				assertEquals(resultSet.getString("address2"), person4.getAddress2());
				assertEquals(resultSet.getString("city"), person4.getCity());
				assertEquals(resultSet.getString("state"), person4.getState());
				assertEquals(resultSet.getString("country"), person4.getCountry());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPatialFind() throws SQLException {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();
		ResultSet resultSet = null;

		Person person10 = new Person(2, null, null, null, null, null, null, null, "USA");
		resultSet = mysqlphonebook.partialFind(person10);
		List<Person> resultList = new ArrayList<Person>();
		resultList.add(person2);
		resultList.add(person12);
		checkPersonList(resultSet, resultList);

		person10 = new Person(0, null, null, null, null, "5thcross", null, null, "India");
		resultSet = mysqlphonebook.partialFind(person10);
		resultList = new ArrayList<Person>();
		resultList.add(person4);
		resultList.add(person7);
		checkPersonList(resultSet, resultList);

		person10 = new Person(0, null, null, null, null, null, null, null, "Pakistan");
		resultSet = mysqlphonebook.partialFind(person10);
		assertEquals(resultSet.next(), false);
	}

	@Test
	public void testFindByNumber() {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();
		ResultSet resultSet = null;
		try {
			resultSet = mysqlphonebook.find(person10);
			assertEquals(resultSet.next(), false);

			resultSet = mysqlphonebook.find(person10);
			assertEquals(resultSet.next(), false);
			resultSet = mysqlphonebook.findByNumber("91", "first_name", true);
			List<Person> resultList = new ArrayList<Person>();
			resultList.add(person4);
			resultList.add(person9);
			resultList.add(person5);
			checkPersonList(resultSet, resultList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByFirstName() throws SQLException {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();
		ResultSet resultSet = mysqlphonebook.findByFirstName("ar", "city", false);
		List<Person> resultList = new ArrayList<Person>();
		resultList.add(person1);
		resultList.add(person12);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByFirstName("_e%", "state", false);
		resultList = new ArrayList<Person>();
		resultList.add(person5);
		resultList.add(person1);
		resultList.add(person7);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByFirstName("m%", "number", true);
		resultList = new ArrayList<Person>();
		resultList.add(person7);
		checkPersonList(resultSet, resultList);
	}

	@Test
	public void testFindByLastName() {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();

		ResultSet resultSet = mysqlphonebook.findByLastName("o", "state", false);
		List<Person> resultList = new ArrayList<Person>();
		resultList.add(person5);
		resultList.add(person1);
		resultList.add(person7);
		resultList.add(person12);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByLastName("%a%", "city", true);
		resultList = new ArrayList<Person>();
		resultList.add(person12);
		resultList.add(person4);
		resultList.add(person2);
		resultList.add(person1);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByLastName("%m", "number", true);
		resultList = new ArrayList<Person>();
		resultList.add(person9);
		checkPersonList(resultSet, resultList);
	}

	@Test
	public void testFindByAddress() throws SQLException {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();

		ResultSet resultSet = mysqlphonebook.findByAddress("HN1", null, null, null, "UK", "first_name", false);
		List<Person> resultList = new ArrayList<Person>();
		resultList.add(person1);
		checkPersonList(resultSet, resultList);
		
		resultSet = mysqlphonebook.findByAddress("H74", null, null, null, null, "first_name", false);
		resultList = new ArrayList<Person>();
		resultList.add(person4);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByAddress("HN9", null, "Fairview", null, null, "first_name", false);
		resultList = new ArrayList<Person>();
		resultList.add(person2);
		resultList.add(person5);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByAddress("H74", null, null, null, null, "last_name", false);
		resultList = new ArrayList<Person>();
		resultList.add(person4);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByAddress(null, "5thcross", null, null, "India", "city", true);
		resultList = new ArrayList<Person>();
		resultList.add(person4);
		resultList.add(person7);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByAddress(null, null, null, "Karnataka", null, "number", true);
		resultList = new ArrayList<Person>();
		resultList.add(person4);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByAddress(null, null, null, null, "spain", "number", true);
		resultList = new ArrayList<Person>();
		resultList.add(person9);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.findByAddress(null, null, null, null, "Pakistan", "number", true);
		assertEquals(resultSet.next(), false);
	}

	@Test
	public void testSearch() throws SQLException {
		MysqlPhoneBook mysqlphonebook = new MysqlPhoneBook();

		ResultSet resultSet = mysqlphonebook.search("cooper");
		List<Person> resultList = new ArrayList<Person>();
		resultList.add(person2);
		resultList.add(person5);
		resultList.add(person7);
		resultList.add(person12);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.search("5thcross");
		resultList = new ArrayList<Person>();
		resultList.add(person4);
		resultList.add(person7);
		checkPersonList(resultSet, resultList);

		resultSet = mysqlphonebook.search("lona");
		assertEquals(resultSet.next(), false);
	}

	public void checkPersonList(ResultSet resultSet, List<Person> resultList) {
		Iterator<Person> itrResult = resultList.iterator();

		try {
			while (resultSet.next() && itrResult.hasNext()) {
				Person p = itrResult.next();
				assertEquals(resultSet.getInt("id"), p.getId());
				assertEquals(resultSet.getString("number"), p.getNumber());
				assertEquals(resultSet.getString("first_name"), p.getFirst_name());
				assertEquals(resultSet.getString("last_name"), p.getLast_name());
				assertEquals(resultSet.getString("address1"), p.getAddress1());
				assertEquals(resultSet.getString("address2"), p.getAddress2());
				assertEquals(resultSet.getString("city"), p.getCity());
				assertEquals(resultSet.getString("state"), p.getState());
				assertEquals(resultSet.getString("country"), p.getCountry());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}