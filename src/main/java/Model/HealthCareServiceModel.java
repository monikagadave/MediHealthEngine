package Model;

/**
 * Created by Monika on 09/09/2016.
 */
public class HealthCareServiceModel {

    private String name;
    private int quantity;

    public HealthCareServiceModel(){}

    public HealthCareServiceModel(String name){
        this.name = name;
    }

    public HealthCareServiceModel(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
