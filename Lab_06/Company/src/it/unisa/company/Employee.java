package it.unisa.company;

public class Employee extends Staff {

    private String jobTitle;
    private float hourlyWage;

    public Employee(String name, String lastname, String jobTitle, float hourlyWage) {
        super(name,lastname);
        this.jobTitle = jobTitle;
        this.hourlyWage = hourlyWage;
        super.setWage(getWage());
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(float hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public float getWage() {
        super.setWage(hourlyWage*40);
        return super.getWage();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Incarico='" + jobTitle + '\'';
    }
}
