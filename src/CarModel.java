import java.time.*;
import java.util.*;

public class CarModel {
    private String carModel;
    private Map<YearMonth, Integer> monthlySales = new LinkedHashMap<>();
    private Map<YearMonth, Integer> yearlySales = new HashMap<>();
    private YearMonth bestMonth;
    private YearMonth worstMonth;

    public CarModel(String carModel) {
        this.carModel = "Model " + carModel.substring(5);
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

    public Map<YearMonth, Integer> getYearlySales() {
        return yearlySales;
    }

    public void setYearlySales(Map<YearMonth, Integer> yearlySales) {
        this.yearlySales = yearlySales;
    }
    public void addYearlySale(Map<YearMonth, Integer> yearlySale) {
        yearlySales.putAll(yearlySale);
    }

    public YearMonth getBestMonth() {
        return bestMonth;
    }

    public void setBestMonth(YearMonth bestMonth) {
        this.bestMonth = bestMonth;
    }

    public YearMonth getWorstMonth() {
        return worstMonth;
    }

    public void findWorstMonth() {
        worstMonth = monthlySales.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public void findBestMonth() {
        bestMonth = monthlySales.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "carModel: " + carModel + ",\n" +
                "monthlySales: " + monthlySales + ",\n" +
                "}";
    }
}
