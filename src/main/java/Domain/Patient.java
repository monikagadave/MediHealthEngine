package Domain;

import Model.HealthCareServiceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monika on 09/09/2016.
 */
public class Patient {

    private String name;
    private double age;
    private boolean healthInsuranceHolder;
    private String diagnosedBy;
    private List<HealthCareServiceModel> healthCareServices = new ArrayList<>();

    public Patient(){}

    public Patient(String name, double age, boolean healthInsuranceHolder) {
        this.name = name;
        this.age = age;
        this.healthInsuranceHolder = healthInsuranceHolder;
    }

    public Patient(String name, double age, boolean healthInsuranceHolder, String diagnosedBy) {
        this.name = name;
        this.age = age;
        this.healthInsuranceHolder = healthInsuranceHolder;
        this.diagnosedBy = diagnosedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isHealthInsuranceHolder() {
        return healthInsuranceHolder;
    }

    public void setHealthInsuranceHolder(boolean healthInsuranceHolder) {
        this.healthInsuranceHolder = healthInsuranceHolder;
    }

    public String getDiagnosedBy() {
        return diagnosedBy;
    }

    public void setDiagnosedBy(String diagnosedBy) {
        this.diagnosedBy = diagnosedBy;
    }

    public List<HealthCareServiceModel> getHealthCareServices() {
        return healthCareServices;
    }

    public void setHealthCareServices(List<HealthCareServiceModel> healthCareServices) {
        this.healthCareServices = healthCareServices;
    }

    public void addHealthCareService(HealthCareServiceModel service){
        this.healthCareServices.add(service);
    }
}
