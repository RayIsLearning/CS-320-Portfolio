package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;

class ContactTest {

	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
			
	}
	
	@Test
	void testContactAndGetters() { //tests that check conditions
		Contact contact = new Contact("1", "John", "Conner", "5201234567", "123 Skynet street");
		assertTrue(contact.getName().equals("John Conner"));
		assertTrue(contact.getPhone().equals("5201234567"));
		assertTrue(contact.getAddr().equals("123 Skynet Street"));
		assertTrue(contact.getId().equals("1"));
	}
	
	@Test
	void testSetFirstAndLastName() {
		Contact contact = new Contact("2", "Sarah", "Conner", "5201234568", "123 Skynet street");
		contact.setFirstName("Sarah");
		contact.setLastName("Conner");
		assertTrue(contact.getName().equals("Sarah Conner"));
	}
	
	@Test
	void testSetPhoneNumberAndAddress() {
		Contact contact = new Contact("3", "Wolfy", "Conner", "5201234569", "123 Skynet Street");
		contact.setPhoneNumber("5201234569");
		contact.setAddress("123 Skynet Street");
		assertTrue(contact.getPhone().equals("5201234569"));
		assertTrue(contact.getAddr().equals("123 Skynet Street"));
	}
	
	@Test
	void testNullSetAttributes() {
		Contact contact = new Contact("1", "John", "Conner", "5201234567", "123 Skynet street");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName(null);	});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName(null);	});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setAddress(null);	});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setPhoneNumber(null);	});
	}
	
	@Test
	void testAllGetters() {
		Contact contact = new Contact("1", "John", "Conner", "5201234567", "123 Skynet street");
		assertTrue(contact.getName().equals("John Conner"));
		assertTrue(contact.getId().equals("1"));
		assertTrue(contact.getPhone().equals("5201234567"));
		assertTrue(contact.getAddr().equals("123 Skynet Street"));
	}

}