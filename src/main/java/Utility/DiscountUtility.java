package Utility;

/**
 * Created by Monika on 09/09/2016.
 */
public class DiscountUtility {

    public static final double CHILDEREN_DISCOUNT = 0.4;
    public static final double SENIOR_CITIZEN_DISCOUNT = 0.6;
    public static final double OLD_AGE_DISCOUNT = 0.9;

    public static double getDiscount(double age) {
        double discount = 0.0;
        if(age > 0 && age < 5){
            discount = CHILDEREN_DISCOUNT;
        }else if (age >= 65 && age <= 70){
            discount = SENIOR_CITIZEN_DISCOUNT;
        }else if(age > 70){
            discount = OLD_AGE_DISCOUNT;
        }
        return discount;
    }
}
