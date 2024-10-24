package it.unisa.SMS;

import java.util.Comparator;
import java.util.GregorianCalendar;

public class SMS {
  private String mittente;
  private GregorianCalendar data;
  private int ID;
  private String testo;
  private static int calcID=0;
  public SMS(String mittente, GregorianCalendar data, String testo) {
      this.mittente = mittente;
      this.data = data;
      this.testo = testo;
      ID=(calcID++);
  }
  public String getSender() {
      return mittente;
  }
  public GregorianCalendar getDate() {
      return data;
  }
}

class sortByDate implements Comparator<SMS> {
    public int compare(SMS o1, SMS o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}

class sortBySender implements Comparator<SMS> {
    public int compare(SMS o1, SMS o2) {
        return o1.getSender().compareTo(o2.getSender());
    }
}