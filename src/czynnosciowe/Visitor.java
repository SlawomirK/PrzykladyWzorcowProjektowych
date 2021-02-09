package czynnosciowe;

interface Departament {
    void accept(SalesReport salesReport);
}

interface SalesReport {
    void visitFoodDep(FoodDempartament foodDempartament);

    void visitFurnitureDep(FurnitureDepartment furnitureDepartment);
}

public class Visitor {
    public static void main(String[] args) {
        var foodDep = new FoodDempartament();
        var furnitureDep = new FurnitureDepartment();
        var salesReport = new SalesReportForDepartment();
        foodDep.accept(salesReport);
        furnitureDep.accept(salesReport);
    }
}

class FoodDempartament implements Departament {
    public void accept(SalesReport salesReport) {
        salesReport.visitFoodDep(this);
    }
}

class FurnitureDepartment implements Departament {
    public void accept(SalesReport salesReport) {
        salesReport.visitFurnitureDep(this);
    }
}

class SalesReportForDepartment implements SalesReport {
    @Override
    public void visitFoodDep(FoodDempartament foodDempartament) {
        System.out.println("raport sprzedaży dla " + foodDempartament.getClass().getSimpleName());
    }

    @Override
    public void visitFurnitureDep(FurnitureDepartment furnitureDepartment) {
        System.out.println("Raport sprzedaży dla " + furnitureDepartment.getClass().getSimpleName());
    }
}