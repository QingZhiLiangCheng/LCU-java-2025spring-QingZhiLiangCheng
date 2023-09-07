package cn.edu.lcu.cs.designpattern.visitor.tax;

public class TaxCalculator {
    public void calculate(SingleTax tax) {
        System.out.println("计算\tSingleTax");
    }

    public void calculate(ElectronicTax tax) {
        System.out.println("计算\tElectronicTax");
    }

    public void calculate(CharityTax tax) {
        System.out.println("计算\tCharityTax");
    }

    public void calculate(Tax tax) {
        if (tax == null) {
            return;
        }
        // 因为Tax种类未知，需要做判断
        if (tax instanceof SingleTax) {
            calculate((SingleTax) tax);
        } else if (tax instanceof ElectronicTax) {
            calculate((ElectronicTax) tax);
        } else if (tax instanceof CharityTax) {
            calculate((CharityTax) tax);
        }
    }
}
