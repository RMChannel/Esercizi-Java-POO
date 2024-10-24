package it.unisa.SMS;

import java.util.*;

public class SMSOrganizer {
    private ArrayList<SMS> organizers;
    public SMSOrganizer() {
        organizers = new ArrayList<SMS>();
    }
    public void addSMSToOrganizer(SMS messaggio) {
        organizers.add(messaggio);
    }
    public List<SMS> getListByDate() {
        List<SMS> listByDate = new ArrayList<SMS>(organizers);
        listByDate.sort(new sortByDate());
        return listByDate;
    }
    public List<SMS> getListBySender() {
        List<SMS> listBySender = new ArrayList<SMS>(organizers);
        listBySender.sort(new sortBySender());
        return listBySender;
    }
}
