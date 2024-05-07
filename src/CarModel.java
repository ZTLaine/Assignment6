import java.time.YearMonth;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CarModel {
    private String carModel;
    private Map<YearMonth, Integer> monthlySales = new LinkedHashMap<>();
    private Map<Integer, Integer> yearlySales = new LinkedHashMap<Integer, Integer>();
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

    public Map<Integer, Integer> getYearlySales() {
        return yearlySales;
    }

    public void setYearlySales() {
        this.yearlySales = monthlySales.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.getKey().getYear(),
                        Collectors.summingInt(Map.Entry::getValue)));
    }

    public void addYearlySale(Map<Integer, Integer> yearlySale) {
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
