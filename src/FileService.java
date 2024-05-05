import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileService {
    void readFiles(List<String> fileNames, SalesReportService salesReport) {
        CarModel car;

        for (String file : fileNames) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file + ".csv"))) {
                /*Yeet that header right into the sea*/
                bufferedReader.readLine();
                car = new CarModel(file);
                Map<YearMonth, Integer> sales = new LinkedHashMap<>();

                while (bufferedReader.ready()) {
                    String[] salesInput = bufferedReader.readLine().split(",");
                    YearMonth saleMonth = YearMonth.parse(salesInput[0], DateTimeFormatter.ofPattern("MMM-yy"));
                    sales.put(saleMonth, Integer.valueOf(salesInput[1]));
                }

                car.setMonthlySales(sales);
                salesReport.addCarModel(car);
            } catch (IOException e) {
                System.out.println("File error with " + file + ": " + e.getMessage());
            }
        }
    }
}
