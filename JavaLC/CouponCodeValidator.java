// Problem: Coupon Code Validator
// Link: https://leetcode.com/problems/coupon-code-validator/

package JavaLC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.*;

public class CouponCodeValidator {

    private static final Logger logger = Logger.getLogger(CouponCodeValidator.class.getName());

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> coupons = new ArrayList<>();
        List<String> bizLines = List.of("electronics", "grocery", "pharmacy", "restaurant");
        HashMap<String, List<String>> validCoupons = new HashMap<>();
        for(String line : bizLines){
            validCoupons.put(line, new ArrayList<>());
        }
        for(int i = 0 ; i < isActive.length; i++){
            if(isCouponValid(code[i], businessLine[i], isActive[i])){
                List<String> value = validCoupons.get(businessLine[i]);
                value.add(code[i]);
                validCoupons.put(businessLine[i], value);
            }
        }
        for(String line: bizLines){
            List<String> value = validCoupons.get(line);
            Collections.sort(value);
            coupons.addAll(value);
        }
        return coupons;
    }

    private boolean isCouponValid(String code, String line, boolean isActive){
        Set<String> bizLines = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        return isActive && bizLines.contains(line) && isCodeValid(code);
    }

    private boolean isCodeValid(String code){
        if(code.length() == 0){
            return false;
        }
        for(Character ch: code.toCharArray()){
            if(!(Character.isLetterOrDigit(ch) || ch.equals('_'))){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        CouponCodeValidator sol = new CouponCodeValidator();
        String[] code = new String[]{"SAVE50"};
        String[] category = new String[]{"electronics"};
        boolean[] isActive = new boolean[]{true};
        List<String> result = sol.validateCoupons(code, category, isActive);
        logger.log(Level.INFO, "Successfully validated");
    }
}