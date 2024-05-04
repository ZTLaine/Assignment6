import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileService {
    List<CarModel> readFiles(List<String> fileNames){
        List<CarModel> salesData = new ArrayList<>();

        for(String file : fileNames){
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                bufferedReader.readLine();
                CarModel car = new CarModel(file);
                Map<YearMonth, Integer> sales = new LinkedHashMap<>();
                while (bufferedReader.ready()) {
                    String[] salesInput = bufferedReader.readLine().split(",");
//                    YearMonth saleMonth = ;
//                    sales.put(saleMonth,salesInput[1]);
                }
            }
            catch (IOException e){
                System.out.println("File error with " + file + ": " + e.getMessage());
            }
        }
        return salesData;
    }
}
