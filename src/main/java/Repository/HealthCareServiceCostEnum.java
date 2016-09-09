package Repository;

/**
 * Created by Monika on 09/09/2016.
 */
public enum HealthCareServiceCostEnum {

    Diagnosis(60),
    XRay(150),
    BloodTest(78),
    ECG(200.4),
    Vaccine(27.5),
    VaccineCharge(15);

    private double cost;

    private HealthCareServiceCostEnum(double cost){
        this.cost = cost;
    }
    public double getCost() {
        return cost;
    }
}
