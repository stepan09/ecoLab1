import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private Label label10;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label14;

    private List<Coefficient> coefficients;

    @FXML
    public void initialize() {
        coefficients = new ArrayList<Coefficient>();
    }

    @FXML
    public void calculte() {
        addToList(new Coefficient("Основна заробітня платня", SalaryWorkExecutor.getBasicSalary()));
        label1.setText(String.format("%.2f", SalaryWorkExecutor.getBasicSalary()));
        addToList(new Coefficient("Додаткова заробітня платня", SalaryWorkExecutor.getAdditionalSalary()));
        label2.setText(String.format("%.2f", SalaryWorkExecutor.getAdditionalSalary()));
        addToList(new Coefficient("Загальна заробітня платня", SalaryWorkExecutor.getTotalSalary()));
        label3.setText(String.format("%.2f", SalaryWorkExecutor.getTotalSalary()));
        addToList(new Coefficient("Розрахунок нарахувань на зп", SalaryWorkExecutor.getCalculation()));
        label4.setText(String.format("%.2f", SalaryWorkExecutor.getCalculation()));
        addToList(new Coefficient("Витрати на електроенернію", CostsMaintenanceAndOperation.getElectricityCost()));
        label5.setText(String.format("%.2f", CostsMaintenanceAndOperation.getElectricityCost()));
        addToList(new Coefficient("Витрати на оплату праці (основні)", CostsMaintenanceAndOperation.getPrimarySalaryExpenses()));
        label6.setText(String.format("%.2f", CostsMaintenanceAndOperation.getPrimarySalaryExpenses()));
        addToList(new Coefficient("Витрати на оплату праці (додаткові)", CostsMaintenanceAndOperation.getAdditionalSalaryExpenses()));
        label7.setText(String.format("%.2f", CostsMaintenanceAndOperation.getAdditionalSalaryExpenses()));
        addToList(new Coefficient("Витрати на оплату праці (ЄСВ)", CostsMaintenanceAndOperation.getCalculationSalaryExpenses()));
        label8.setText(String.format("%.2f", CostsMaintenanceAndOperation.getCalculationSalaryExpenses()));
        addToList(new Coefficient("Витрати на витратні матеріали", CostsMaintenanceAndOperation.getCostsOfConsumables()));
        label9.setText(String.format("%.2f", CostsMaintenanceAndOperation.getCostsOfConsumables()));
        addToList(new Coefficient("Витрати на профілактику", CostsMaintenanceAndOperation.getCostsOfPrevention()));
        label10.setText(String.format("%.2f", CostsMaintenanceAndOperation.getCostsOfPrevention()));
        addToList(new Coefficient("Амортизаційні відрахування", CostsMaintenanceAndOperation.getAmortizationDeductionsPerYear()));
        label11.setText(String.format("%.2f", CostsMaintenanceAndOperation.getAmortizationDeductionsPerYear()));
        addToList(new Coefficient("Витрати на утримання та експлуатацію ЕОM", CostsMaintenanceAndOperation.getCostsMaintenanceAndOperationPC()));
        label12.setText(String.format("%.2f", CostsMaintenanceAndOperation.getCostsMaintenanceAndOperationPC()));
        addToList(new Coefficient("Собівартість програмного продукту", SoftwareProducCost.getSoftwareProductCost()));
        label13.setText(String.format("%.2f", SoftwareProducCost.getSoftwareProductCost()));
        addToList(new Coefficient("Вартість програмного продукту", SoftwareProductPrice.getSoftwareProductPrice()));
        label14.setText(String.format("%.2f", SoftwareProductPrice.getSoftwareProductPrice()));
    }

    @FXML
    public void writeToWord() {
        CreateWord createWord = new CreateWord();
        try {
            createWord.writeInWord(coefficients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void writeToExcel() {
        CreateExcel createExcel = new CreateExcel();
        try {
            createExcel.writeInExcel(coefficients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToList(Coefficient coefficient) {
        if (coefficients.stream().noneMatch(t -> t.getName().equals(coefficient.getName()))) {
            coefficients.add(coefficient);
        }
    }
}
