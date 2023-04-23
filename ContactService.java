package contactService;

import java.util.Random;
import java.util.Vector;

public class ContactService {

	private Vector<Contact> contacts = new Vector<Contact>();//initialize empty vector
	private int contactCount = 0;
	
	public int GetContactCount() {//returns size of vector
		return contactCount;
	}
	
	public Vector<Contact> GetContactList(){//returns contents of vector
		return contacts;
	}

	public void AddContact(String id, String fName, String lName, String phone, String addy) {//adds contact 
		Contact newContact = new Contact(
				id,
				fName,
				lName,
				phone,
				addy);
		
		contacts.add(newContact);
		contactCount++;
	}
	
	public void AddContact(Contact contact) {//updates list size
		contacts.add(contact);
		contactCount++;
	}
	
	public void DeleteContact(String id) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(contacts.isEmpty()) {
			throw new IllegalArgumentException("No contacts to delete");
		}
		
		int indx = -1;
		for (Contact c : contacts) {
			if (c.getId() == id) {
				indx = contacts.indexOf(c);
			}	
		}
		if (indx == -1) {
			System.out.println("Contact not found.");
			return;
		}
		else{
			contacts.remove(indx);
			contactCount--;
			System.out.println("Contact removed from list.");
		}
	}
	
	private void DeleteContact(Contact contact) {//removes contact from vector
		contacts.remove(contact);
		contactCount--;
	}
	
	public void UpdateContact(String id, String update, int selection) {
		if(id == null || id.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(contacts.isEmpty()) {
			throw new IllegalArgumentException("No contacts exist in list");
		}
		
		int indx = -1;
		for (Contact c : contacts) {
			if (c.getId() == id) {
				indx = contacts.indexOf(c);
			}
		}
		if (indx == -1) {
			System.out.println("Contact not found.");
			return;
		}
		Contact updateContact = contacts.get(indx);//logic to update contact info
		switch (selection){
		case 1:{
			updateContact.setFirstName(update);
			break;}
		case 2:{
			updateContact.setLastName(update);
			break;}
		case 3:{
			updateContact.setPhoneNumber(update);
			break;}
		case 4:{
			updateContact.setAddress(update);
			break;}
		default:{
			System.out.println("Contact not updated, invalid change requested.");
			break;}
		}
		
		DeleteContact(contacts.elementAt(indx));
		AddContact(updateContact);	
	}
	
	public void UpdateContact(String id, String fName, String lName, String phone, String addy) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(contacts.isEmpty()) {
			throw new IllegalArgumentException("No contacts exist in list");
		}
		int indx = -1;
		for (Contact c : contacts) {
			if (c.getId() == id) {
				indx = contacts.indexOf(c);
			}
		}
		if (indx == -1) {
			System.out.println("Contact not found.");
			return;
		}
		Contact tempContact = contacts.get(indx);
		tempContact.setFirstName(fName);
		tempContact.setLastName(lName);
		tempContact.setAddress(addy);
		tempContact.setPhoneNumber(phone);
		
		contacts.remove(indx);
		contacts.add(tempContact);
	}
	public String NewID() {// makes new id for a contact
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String freshId = Integer.toString(newID);
		
		for (Contact c : contacts) {
			while (c.getId() == freshId) {
				newID = rand.nextInt(1000000000);
				freshId = Integer.toString(newID);
			}
		}
		System.out.println("ID created: " + freshId);
		return freshId;
	}
	
	
	
}