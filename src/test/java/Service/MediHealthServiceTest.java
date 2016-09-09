package Service;

import Domain.Patient;
import Model.HealthCareServiceModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Monika on 09/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MediHealthServiceTest {

    @InjectMocks MediHealthService mediHealthService;

    @Test
    public void shouldReturnTotalCostForServicesNotIncludeVaccine(){
        Patient patient = new Patient();
        patient.setHealthCareServices(getHealthCareServiceModels());

        double totalCost = mediHealthService.getTotalCostOfServices(patient);

        assertEquals(260.4, totalCost, 0.0);
    }

    @Test
    public void shouldRetunrTotalWithVaccineCharges(){
        Patient patient = new Patient();
        List<HealthCareServiceModel> healthCareServiceModels = getHealthCareServiceModels();
        healthCareServiceModels.add(new HealthCareServiceModel("Vaccine", 2));
        patient.setHealthCareServices(healthCareServiceModels);

        double totalCost = mediHealthService.getTotalCostOfServices(patient);

        assertEquals(317.9, totalCost, 0.0);
    }

    @Test
    public void shouldRetunrTotalWith65To70AgeDiscount(){
        Patient patient = new Patient("ABC", 69, false);
        patient.setHealthCareServices(getHealthCareServiceModels());

        double totalCost = mediHealthService.getTotalCostOfServices(patient);

        assertEquals(104.16, totalCost, 0.001);
    }

    @Test
    public void shouldRetunrTotalWithGreaterThan70AgeDiscount(){
        Patient patient = new Patient("ABC", 71, false);
        patient.setHealthCareServices(getHealthCareServiceModels());

        double totalCost = mediHealthService.getTotalCostOfServices(patient);

        assertEquals(26.04, totalCost, 0.001);
    }


    @Test
    public void shouldRetunrTotalWithLessThan5AgeDiscount(){
        Patient patient = new Patient("ABC", 2, false);
        patient.setHealthCareServices(getHealthCareServiceModels());

        double totalCost = mediHealthService.getTotalCostOfServices(patient);

        assertEquals(156.24, totalCost, 0.001);
    }

    @Test
    public void shouldRetunrTotalWithNoHealthInsuranceDiscountForBloodTest(){
        Patient patient = new Patient("ABC", 25, false, "MediHealth Practitioner");
        List<HealthCareServiceModel> healthCareServiceModels = getHealthCareServiceModels();
        healthCareServiceModels.add(new HealthCareServiceModel("BloodTest"));
        patient.setHealthCareServices(healthCareServiceModels);

        double totalCost = mediHealthService.getTotalCostOfServices(patient);

        assertEquals(338.4, totalCost, 0.001);
    }

    @Test
    public void shouldRetunrTotalWithHealthInsuranceDiscountForBloodTest(){
        Patient patient = new Patient("ABC", 25, true, "MediHealth Practitioner");
        List<HealthCareServiceModel> healthCareServiceModels = getHealthCareServiceModels();
        healthCareServiceModels.add(new HealthCareServiceModel("BloodTest"));
        patient.setHealthCareServices(healthCareServiceModels);

        double totalCost = mediHealthService.getTotalCostOfServices(patient);

        assertEquals(326.7, totalCost, 0.001);
    }

    @Test
    public void shouldRetunrTotalWithAgeAndHealthInsuranceDiscountForBloodTest(){
        Patient patient = new Patient("ABC", 2, true, "MediHealth Practitioner");
        List<HealthCareServiceModel> healthCareServiceModels = getHealthCareServiceModels();
        healthCareServiceModels.add(new HealthCareServiceModel("BloodTest"));
        patient.setHealthCareServices(healthCareServiceModels);

        double totalCost = mediHealthService.getTotalCostOfServices(patient);

        assertEquals(196.02, totalCost, 0.001);
    }

    private List<HealthCareServiceModel> getHealthCareServiceModels() {
        List<HealthCareServiceModel> healthCareServiceModels = new ArrayList<>();
        healthCareServiceModels.add(new HealthCareServiceModel("Diagnosis"));
        healthCareServiceModels.add(new HealthCareServiceModel("ECG"));
        return healthCareServiceModels;
    }
}