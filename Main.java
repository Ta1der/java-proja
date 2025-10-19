public class Main {
    public static void main(String[] args) {
        Car[] cars = {
            new Car(1, "Toyota", "Camry", 2020, "Black", 25000.0, "AB123CD"),
            new Car(2, "Honda", "Civic", 2018, "White", 20000.0, "EF456GH"),
            new Car(3, "Toyota", "Corolla", 2015, "Red", 18000.0, "IJ789KL"),
            new Car(4, "Toyota", "RAV4", 2017, "Blue", 22000.0, "MN012OP"),
            new Car(5, "BMW", "X5", 2019, "Black", 45000.0, "QR345ST"),
            new Car(6, "Honda", "Accord", 2016, "Silver", 21000.0, "UV678WX")
        };

        System.out.println("=== Тест метода getCarByBrend ===");
        Car[] toyotaCars = getCarByBrend(cars, "Toyota");
        System.out.println("Найдено машин Toyota: " + toyotaCars.length);
        for (Car car : toyotaCars) {
            System.out.println(" - " + car.getBrand() + " " + car.getModel() + " (" + car.getYear() + ")");
        }
        Car[] hondaCars = getCarByBrend(cars, "Honda");
        System.out.println("Найдено машин Honda: " + hondaCars.length);

        Car[] bmwCars = getCarByBrend(cars, "BMW");
        System.out.println("Найдено машин BMW: " + bmwCars.length);

        System.out.println("\n=== Тест метода getCarByBrendAndYearOperational ===");
        Car[] oldToyotaCars = getCarByBrendAndYearOperational(cars, "Toyota", 5);
        System.out.println("Найдено машин Toyota старше 5 лет: " + oldToyotaCars.length);
        for (Car car : oldToyotaCars) {
            int yearsOperational = java.time.Year.now().getValue() - car.getYear();
            System.out.println(" - " + car.getBrand() + " " + car.getModel() + " (" + car.getYear() + ") - " + yearsOperational + " лет в эксплуатации");
        }

        Car[] oldHondaCars = getCarByBrendAndYearOperational(cars, "Honda", 4);
        System.out.println("Найдено машин Honda старше 4 лет: " + oldHondaCars.length);

        // Тест с несуществующей маркой
        Car[] noCars = getCarByBrendAndYearOperational(cars, "Audi", 3);
        System.out.println("Найдено машин Audi старше 3 лет: " + noCars.length);
    }

    // Метод для фильтрации машин по марке
    public static Car[] getCarByBrend(Car[] cars, String brend) {
        // Сначала подсчитаем количество машин нужной марки
        int count = 0;
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brend)) {
                count++;
            }
        }

        // Создаем массив нужного размера
        Car[] result = new Car[count];
        int index = 0;
        
        // Заполняем массив
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brend)) {
                result[index++] = car;
            }
        }

        return result;
    }

    // Метод для фильтрации машин по марке и сроку эксплуатации
    public static Car[] getCarByBrendAndYearOperational(Car[] cars, String brend, int years) {
        int currentYear = java.time.Year.now().getValue();
        
        // Сначала подсчитаем количество подходящих машин
        int count = 0;
        for (Car car : cars) {
            int yearsOperational = currentYear - car.getYear();
            if (car.getBrand().equalsIgnoreCase(brend) && yearsOperational > years) {
                count++;
            }
        }

        // Создаем массив нужного размера
        Car[] result = new Car[count];
        int index = 0;
        
        // Заполняем массив
        for (Car car : cars) {
            int yearsOperational = currentYear - car.getYear();
            if (car.getBrand().equalsIgnoreCase(brend) && yearsOperational > years) {
                result[index++] = car;
            }
        }

        return result;
    }
}
