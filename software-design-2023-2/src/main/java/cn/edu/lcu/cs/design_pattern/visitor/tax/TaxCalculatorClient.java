package cn.edu.lcu.cs.design_pattern.visitor.tax;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorClient {
    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();

        // 获取包含各种Tax的列表
        List<Tax> taxes = buildTaxes();
        taxes.forEach(tax -> { calculator.calculate(tax);
//            // 因为Tax种类未知，需要做判断
//            if (tax instanceof SingleTax) {
//                calculator.calculate((SingleTax) tax);
//            } else if (tax instanceof ElectronicTax) {
//                calculator.calculate((ElectronicTax) tax);
//            } else if (tax instanceof CharityTax) {
//                calculator.calculate((CharityTax) tax);
//            }
        });
    }

    private static List<Tax> buildTaxes() {
        List<Tax> taxes = new ArrayList<>();

        taxes.add(new CharityTax());
        taxes.add(new ElectronicTax());
        taxes.add(new SingleTax());

        return taxes;
    }
}
