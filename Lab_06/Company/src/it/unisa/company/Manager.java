package it.unisa.company;

public class Manager extends Employee {

    private String expertiseArea;
    private int workedHours;

    public Manager( String name, String surname, String jobTitle, int hourlyWage, String expertiseArea) {
        super(name,surname,jobTitle,hourlyWage);
        this.expertiseArea = expertiseArea;
        this.workedHours = 0;
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }

    public void setExpertiseArea(String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    @Override
    public float getWage() {
        float result=super.getHourlyWage()*workedHours;
        super.setWage(result);
        return result;
    }



    @Override
    public String toString() {
        return super.toString() +
                ", Area di competenza='" + expertiseArea + '\'';
    }
}
