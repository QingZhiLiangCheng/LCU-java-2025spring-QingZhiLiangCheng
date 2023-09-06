package cn.edu.lcu.cs.design_pattern.visitor.tax;

public class TaxVisitor implements Visitor {
    @Override
    public void visit(SingleTax tax) {
        System.out.println("Visit\tSingleTax");
    }

    @Override
    public void visit(CharityTax tax) {
        System.out.println("Visit\tCharityTax");

    }

    @Override
    public void visit(ElectronicTax tax) {
        System.out.println("Visit\tElectronicTax");

    }

    @Override
    public void visit(EntertainmentTax tax) {
        System.out.println("Visit\tEntertainmentTax");

    }

    @Override
    public void visit(FamilyTax tax) {
        System.out.println("Visit\tFamilyTax");

    }
}
