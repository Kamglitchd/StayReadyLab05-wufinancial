package com.codedifferently.stayready;

import java.util.HashMap;
import java.util.Map;

public class Convert {
    private Map<String, Double> currencyRate;
    public Convert() {
        currencyRate = new HashMap<String, Double>();
    }
    public void addRates() {
        currencyRate.put("USD", 1.00);
        currencyRate.put("Euro",0.886);
        currencyRate.put("Pound",0.793);
        currencyRate.put("Rupee",75.145);
        currencyRate.put("AUD",1.436);
        currencyRate.put("CAD",1.359);
        currencyRate.put("SD",1.392);
        currencyRate.put("SF",0.940);
        currencyRate.put("Ringgit",4.262);
        currencyRate.put("Yen",107.189);
        currencyRate.put("Yuan",6.994);
    }
    //starting currency and amount to translate
//    public double convertToUSD(String currency, Double amount){
//        double dollarAmount=0.0;
//        if(currency=="USD"){
//            return amount;
//        }
//        dollarAmount=amount*currencyRate.get(currency);
//        return dollarAmount;
//    }
    //checks that currency exists in map
    public boolean contains(String currency) {
        boolean contains = false;//flag for contains
        if (currencyRate.containsKey(currency) ) {//currency exists in map
            contains = true;
        }
        return contains;

    }
    public double getRate(String currency) {
        if (contains(currency)) {
            return currencyRate.get(currency);//value is currency rate
        }
        return 0;
    }
    //amount in startCurrency converted to USD from currencyRate map then to endCurrency
    public double convertToCurrency(String startCurrency,String endCurrency, Double amount){
        if(endCurrency==null||endCurrency==null||!contains(endCurrency)||
        !contains(startCurrency)){
            System.out.println("Cannot complete conversion");
        }
        else if(endCurrency==startCurrency||amount==0){
            return amount;
        }
        //double dollarAmount=amount*currencyRate.get(startCurrency);;
        double currencyAmount=amount*(currencyRate.get(endCurrency)/currencyRate.get(startCurrency));
        return currencyAmount;
    }

}
