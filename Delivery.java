package JavaOsnova;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Address {
    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}

class Delivery {
    public static void main(String[] args) {

        Map<Address, Integer> costPerAddress = new HashMap<>();
        Set<String> countries = new HashSet<String>();
        costPerAddress.put(new Address("Россия", "Москва"), 200);
        costPerAddress.put(new Address("Россия", "Тула"), 350);
        costPerAddress.put(new Address("США", "Монтана"), 750);
        costPerAddress.put(new Address("Австралия", "Мельбурн"), 1600);
        costPerAddress.put(new Address("Азербайджан", "Баку"), 1000);

        Scanner scanner = new Scanner(System.in);
        int sumTotal = 0;

        while (true) {
            System.out.println("\nЗаполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();
            if (country.equalsIgnoreCase("end")) {
                break;
            }


            System.out.print("Введите город: ");
            String city = scanner.nextLine();

            System.out.print("Введите вес (кг): ");
            int weight = scanner.nextInt();
            scanner.nextLine();

            Address address = new Address(country, city);

            if (costPerAddress.containsKey(address)) {
                countries.add(country);
                int cost = weight * costPerAddress.get(address);
                sumTotal += cost;
                System.out.println("Стоимость доставки составит: " + cost + " руб");
                System.out.println("Общая стоимость всех доставок: " + sumTotal + " руб");
                System.out.println("Кол-во доставляемых стран: " + countries.size());

            } else {
                System.out.println("Доставки по этому адресу нет");
            }
        }
    }
}
