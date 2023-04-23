package Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

class ContactServiceTest {

	@Test
	void testAddContactMethod() {// creates a contact
		ContactService contactService = new ContactService();
		String testID = contactService.NewID();
		Contact contact = new Contact(testID, "John", "Conner", "5201234567", "123 Skynet Street");
		contactService.AddContact(contact);//adds to vector
		assertTrue(!contactService.GetContactList().isEmpty());//checks for empty list
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getId()
				.equals(testID));
		assertTrue(contactService.GetContactCount() > 0);
	}
	
	@Test
	void testDeleteContactMethod() {//tests exceptions
		ContactService contactService = new ContactService();
		Contact contact = new Contact("1", "John", "Conner", "5201234567", "123 Skynet street");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.DeleteContact(null);	});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.DeleteContact("12345678901");	});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.DeleteContact("1234567890");	});
		contactService.AddContact(contact);
		contactService.DeleteContact("123457");
		assertTrue(!contactService.GetContactList().isEmpty());
		assertTrue(contactService.GetContactCount() != 0);
		contactService.DeleteContact("123456");
		assertTrue(contactService.GetContactCount() == 0);
		assertTrue(contactService.GetContactList().isEmpty());
		
	}
	
	@Test
	void testUpdateContactMethodErrors() {//tests contact methods
		ContactService contactService = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("123456", "Bruce", 1);	});
		Contact contact = new Contact("1", "John", "Conner", "5201234567", "123 Skynet street");
		contactService.AddContact(contact);
		assertTrue(!contactService.GetContactList().isEmpty());
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("12345678901", "Bruce", 1);	});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact(null, "Bruce", 1);	});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("123456", null, 1);	});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("123456", "Bruce", -1);
		});
		contactService.UpdateContact("123457", "Bruce", 1);
		contactService.UpdateContact("123456", "Bruce", 5);
		
	}
	
	@Test
	void testUpdateContactMethod() {//tests update methods
		ContactService contactService = new ContactService();
		Contact contact = new Contact("1", "John", "Conner", "5201234567", "123 Skynet street");
		contactService.AddContact(contact);
		assertTrue(!contactService.GetContactList().isEmpty());
		contactService.UpdateContact("123456", "Bruce", 1);
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getName()
				.equals("John Conner"));
		contactService.UpdateContact("123456", "Joy", 2);
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getName()
				.equals("Joy"));
		contactService.UpdateContact("123456", "5204567899", 3);
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getPhone()
				.equals("5204567899"));
		contactService.UpdateContact("123456", "825 Bland Street", 4);
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getAddr()
				.equals("825 Bland Street"));
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("123456", "SomeName", 1);	});
		assertTrue(contactService.GetContactCount() == 1);
		assertTrue(contactService.GetContactList().elementAt(0)
				.getName().equals("Ray Cooke"));
				
	}

}