package assignm2;

import static org.junit.Assert.*;
import org.junit.Test;

public class PhoneDairyTest {

	@Test
	public void testAdd() {
		PhoneDairy pdairy = new PhoneDairy();
		pdairy.loadEntities();
		assertTrue(pdairy.add("teeka", "380"));
		assertTrue(pdairy.add("diya", "402"));
		assertTrue(pdairy.add("monika", "930"));
		assertTrue(pdairy.add("000", ""));
		assertTrue(pdairy.add("", ""));
		assertTrue(pdairy.add(null, null));
	}

	@Test
	public void testRemoveName() {
		PhoneDairy pdairy = new PhoneDairy();
		pdairy.loadEntities();
		assertFalse(pdairy.removeName(""));
		assertFalse(pdairy.removeName(null));
		assertFalse(pdairy.removeName("tina"));
		assertNotNull(pdairy);
		assertFalse(pdairy.removeName("meena"));
		assertFalse(pdairy.removeName("0000"));
		assertFalse(pdairy.removeName("dominika"));
	}

	@Test
	public void testRemoveNumber() {
		PhoneDairy pdairy = new PhoneDairy();
		pdairy.loadEntities();
		assertFalse(pdairy.removeNumber("tina"));
		assertNotNull(pdairy);
		assertFalse(pdairy.removeNumber("300"));
		assertFalse(pdairy.removeNumber("00io0"));
		assertFalse(pdairy.removeNumber("500"));
	}

	@Test
	public void testGetNumber() {
		PhoneDairy pdairy = new PhoneDairy();
		pdairy.loadEntities();
		assertEquals("200", pdairy.getNumber("meena"));
		assertEquals("300", pdairy.getNumber("deeka"));
		assertEquals(null, pdairy.getNumber("deena"));
		assertEquals(null, pdairy.getNumber(null));
		assertEquals(null, pdairy.getNumber("   "));
		assertEquals(null, pdairy.getNumber("+" + "+"));
		assertEquals("500", pdairy.getNumber("dominika"));
	}
}