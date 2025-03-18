package org.example.mobile;

import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int pos = findContact(oldContact.getName());
        if (pos < 0) {
            return false;
        }
        myContacts.set(pos, newContact);
        return true;
    }
    public boolean removeContact(Contact contact) {
        int pos = findContact(contact.getName());
        if (pos < 0) {
            return false;
        }
        myContacts.remove(pos);
        return true;
    }

    public int findContact(Contact contact) {
        return findContact(contact.getName());
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int pos = findContact(name);
        if (pos >= 0) {
            return myContacts.get(pos);
        }
        return null;
    }

    public void printContact() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
