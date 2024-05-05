import java.util.ArrayList;
import java.util.List;

public class SalesReportService {
    private List<CarModel> carModelData = new ArrayList<>();
    private List<String> fileNames = new ArrayList<>();

    public SalesReportService() {
        fileNames.add("model3");
        fileNames.add("modelS");
        fileNames.add("modelX");
    }

    public List<CarModel> getCarModelData() {
        return carModelData;
    }

    public void setCarModelData(List<CarModel> carModelData) {
        this.carModelData = carModelData;
    }

    public void addCarModel(CarModel carModel) {
        carModelData.add(carModel);
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    public void addFileName(String fileName) {
        fileNames.add(fileName);
    }

    void report() {
        FileService fileService = new FileService();
        fileService.readFiles(fileNames, this);

        for(CarModel car : carModelData){
            System.out.println(car.toString());
        }
    }
}
