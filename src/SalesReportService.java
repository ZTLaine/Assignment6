//  5/8/24
//  Zack Laine
//  Assignment 6

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

    void report() {
        FileService fileService = new FileService();
        fileService.readFiles(fileNames, this);

        for (CarModel car : carModelData) {
            car.findBestMonth();
            car.findWorstMonth();

            System.out.println(car.getCarModel() + " Yearly Sales Report");
            car.setYearlySales();
            car.getYearlySales().forEach((key, value) -> System.out.println(key + " -> " + value));

            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println("The best month for " + car.getCarModel() + " was: " + car.getBestMonth());
            System.out.println("The worst month for " + car.getCarModel() + " was: " + car.getWorstMonth());

            System.out.println("\n");
        }
    }
}
