package it.unisa.school;

public class Person {

    final private String name;
    final private String surname;
    final private int birthYear;
    final private String userId;
    final private String password;

    public Person(String name, String surname, int birthYear, String userId, String password) {
        checkNC(name,"nome");
        checkNC(surname,"cognome");
        checkUP(userId,"UserId");
        checkUP(password,"Password");
        checkYear(birthYear);
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    private void checkUP(String toCheck, String whatIsIt) {
        if(toCheck.length()<5) throw new IllegalArgumentException(whatIsIt+" di lunghezza minore di 5");
        if(toCheck.contains(" ")) throw new IllegalArgumentException("Non sono ammessi spazi nell'"+whatIsIt);
    }

    private void checkNC(String toCheck, String whatIsIt) {
        if(toCheck==null) throw new IllegalArgumentException("Non sono ammessi null in "+whatIsIt);
        if(toCheck.isEmpty()) throw new IllegalArgumentException("Il "+whatIsIt+" dev'essere di lunghezza almeno di 1");
    }

    private void checkYear(int birthYear) {
        if(birthYear<1900) throw new IllegalArgumentException("L'anno di nascita minimo è il 1900 "+birthYear);
    }

    @Override
    public String toString() {
        return "Nome='" + name + '\'' +
                ", Cognome='" + surname + '\'' +
                ", Anno di nascita=" + birthYear;
    }
}
