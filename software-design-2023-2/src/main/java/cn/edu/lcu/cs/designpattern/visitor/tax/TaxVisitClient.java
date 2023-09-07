package cn.edu.lcu.cs.designpattern.visitor.tax;

import java.util.ArrayList;
import java.util.List;

public class TaxVisitClient {
    public static void main(String[] args) {
        TaxVisitor visitor = new TaxVisitor();

        // 获取包含各种Tax的列表
        List<Tax> taxes = buildTaxes();
        taxes.forEach(tax -> tax.accept(visitor));
}

    private static List<Tax> buildTaxes() {
        List<Tax> taxes = new ArrayList<>();

        taxes.add(new CharityTax());
        taxes.add(new ElectronicTax());
        taxes.add(new SingleTax());

        return taxes;
    }
}
