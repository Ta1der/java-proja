import com.sibsutis.Printable;
import com.sibsutis.devices.PersonalComputer;
import com.sibsutis.devices.Phone;

public class Main {
    public static void main(String[] args) {
        // Создаем устройства
        Printable pc = new PersonalComputer(1, 50000, "192.168.1.100");
        Printable phone1 = new Phone(2, 30000);  // Без IP
        Printable phone2 = new Phone(3, 40000, "192.168.1.101");

        System.out.println(pc.print());
        System.out.println(phone1.print());
        System.out.println(phone2.print());
  
        String pcInfo = pc.print();
        System.out.println("Информация о ПК: " + pcInfo);

        if (pc instanceof PersonalComputer) {
            PersonalComputer computer = (PersonalComputer) pc;
            System.out.println("Тип устройства: " +          computer.getDeviceType());
        }
    }
}
