import java.io.NotActiveException;
import java.io.Serializable;

public class StaffCard extends Card implements Serializable {
    private String department;
    private double spentAmount;
    private String category;

    public StaffCard(int codice, String nome, String cognome, boolean active, String department, double spentAmount, String Category) {
        super(codice, nome, cognome, active);
        this.department = department;
        this.spentAmount = spentAmount;
        this.category = Category;
    }

    public String getDepartment() {
        return department;
    }

    public double getSpentAmount() {
        return spentAmount;
    }

    public String getCategory() {
        return category;
    }

    public double pay() throws NotActiveException {
        if(!isActive()) throw new NotActiveException();
        if(category.equals("professor")) {
            spentAmount+=1.6;
            return 1.6;
        }
        else if(category.equals("administrative")) {
            spentAmount+=4;
            return 4;
        }
        else {
            throw new RuntimeException("Unrecognized category");
        }
    }

    public void changeCategory() {
        if(category.equals("professor")) {
            category = "administrative";
        }
        else if(category.equals("administrative")) {
            category = "professor";
        }
        else {
            throw new RuntimeException("Unrecognized category");
        }
    }
}
