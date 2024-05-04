import java.time.*;
import java.util.*;

public class CarModel {
    private String carModel;
    private Map<YearMonth, Integer> monthlySales = new LinkedHashMap<>();

    public CarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Map<YearMonth, Integer> getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(Map<YearMonth, Integer> monthlySales) {
        this.monthlySales = monthlySales;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "carModel: " + carModel + ",\n" +
                "monthlySales: " + monthlySales + ",\n" +
                "}";
    }
}
