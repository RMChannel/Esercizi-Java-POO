package it.unisa.SMS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SMSOrganizer {
    final private List<SMS> messages;

    public SMSOrganizer() {
        messages = new ArrayList<>();
    }

    public void addSMSToOrganizer(SMS sms) {
        this.messages.add(sms);
    }

    public List<SMS> getListByDate() {
        Comparator comparator = new Comparator() {
          public int compare(Object o1, Object o2) {
              SMS sms1 = (SMS) o1;
              SMS sms2 = (SMS) o2;
              return sms1.getDate().compareTo(sms2.getDate());
          }
        };
        messages.sort(comparator);
        return this.messages;
    }

    public List<SMS> getListBySender() {
        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                SMS sms1 = (SMS) o1;
                SMS sms2 = (SMS) o2;
                return sms1.getSender().compareTo(sms2.getSender());
            }
        };
        messages.sort(comparator);
        return this.messages;
    }
}
