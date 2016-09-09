package Service;

import Domain.Patient;
import Model.HealthCareServiceModel;
import Repository.HealthCareServiceCostEnum;
import org.springframework.stereotype.Service;

import static Repository.HealthCareServiceCostEnum.VaccineCharge;
import static Utility.DiscountUtility.getDiscount;
import static Utility.Literal.*;

/**
 * Created by Monika on 09/09/2016.
 */
@Service
public class MediHealthService {

    public double getTotalCostOfServices(Patient patient){
        double total = 0;
        for(HealthCareServiceModel careService:  patient.getHealthCareServices()) {
            total += getCalculatedCost(careService, patient);
        }
        total -= (total * getDiscount(patient.getAge()));
        return total;
    }

    private double getCalculatedCost(HealthCareServiceModel careService, Patient patient) {
        double cost = HealthCareServiceCostEnum.valueOf(careService.getName()).getCost();
        if(VACCINE.equalsIgnoreCase(careService.getName())) {
            for (int i = 0; i < careService.getQuantity(); i++) {
                cost += VaccineCharge.getCost();
            }
        }else if(BLOOD_TEST.equalsIgnoreCase(careService.getName()) && patient.isHealthInsuranceHolder()
                && MEDI_HEALTH_PRACTITIONER.equalsIgnoreCase(patient.getDiagnosedBy())){
            cost -= (cost * HEALTH_INSURANCE_DISCOUNT);
        }
        return cost;
    }
}