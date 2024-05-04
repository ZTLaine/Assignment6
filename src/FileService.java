import java.util.ArrayList;
import java.util.List;

public class FileService {
    List<CarModel> readFiles(List<String> fileNames){
        List<CarModel> salesData = new ArrayList<>();

        for(String file : fileNames){
//            Read the file here
            CarModel car = new CarModel(file);

        }
        return salesData;
    }
}
