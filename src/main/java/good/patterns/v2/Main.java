package good.patterns.v2;

import good.patterns.v2.abstraction.IFlightDatabase;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        AbstractFlightRoute flightRoute1 =  new FlightRoute("Warszawa","Gdansk");
        AbstractFlightRoute flightRoute2 =  new FlightRoute("Warszawa","Krakow");
        AbstractFlightRoute flightRoute3 =  new FlightRoute("Warszawa","Poznan");
        AbstractFlightRoute flightRoute4 =  new FlightRoute("Warszawa","Wroclaw");
        AbstractFlightRoute flightRoute5 =  new FlightRoute("Poznan","Lodz");

        IFlightDatabase flightDatabase = new FlightDatabase();
        Map<Integer,Map<String,String>> list = new HashMap<>();
        list.put(1,flightDatabase.flightMap(flightRoute1));
        list.put(2,flightDatabase.flightMap(flightRoute2));
        list.put(3,flightDatabase.flightMap(flightRoute3));
        list.put(4,flightDatabase.flightMap(flightRoute4));
        list.put(5,flightDatabase.flightMap(flightRoute5));

        Set <String> setA = list.entrySet().stream()
                .flatMap(m1->m1.getValue().entrySet().stream())
                .map(m2->m2.getKey())
                .collect(Collectors.toSet());

        Collection collectionA = setA.stream().collect(Collectors.toCollection(() -> setA));

        Set <String> setB = list.entrySet().stream()
                .flatMap(m1->m1.getValue().entrySet().stream())
                .map(m2->m2.getValue())
                .collect(Collectors.toSet());
        Collection collectionB = setA.stream().collect(Collectors.toCollection(() -> setB));

        Set <Set> finalSet = new HashSet<>();
        finalSet.addAll(collectionA);
        finalSet.addAll(collectionB);

        System.out.println("List of available city in the system " + finalSet);

        System.out.println("Welcome to SomethingAirline! Please pick your option: ");
        System.out.println("1. Chose all flight 'FROM' city");
        System.out.println("2. Chose all flight 'TO' city");
        System.out.println("3. Check if there is further flight from destination city");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();

        if (choice == 1){
            //Task 1 solve
            System.out.print("Chose flight 'FROM: ");
            String fromCity = scanner.next();
            if (list.containsValue(fromCity)){
                list.entrySet().stream().filter(m1->m1.getValue().containsKey(fromCity)).forEach(System.out::println);
            } else {
                System.out.println("Error, city not found in our database... please try again");
            }
        } else if (choice == 2) {
            //Task 2 solve
            System.out.print("Find flight 'TO': ");
            String toCity = scanner.next();
            if (list.containsValue(toCity)){
                list.entrySet().stream().filter(m1->m1.getValue().containsValue(toCity)).forEach(System.out::println);
            } else {
                System.out.println("Error, city not found in our database... please try again");
            }
        } else if (choice == 3) {
            //Task 3 solve - v.1
            System.out.println("Check form direct connection otherwise find 'INTERMEDIARY' flight");
            System.out.print("From: ");
            String intermediaryFlightFrom = scanner.next();
            System.out.print("Destination: ");
            String intermediaryFlightTo = scanner.next();
            if (list.containsValue(intermediaryFlightFrom) && list.containsValue(intermediaryFlightTo)){
                final List <Map<String, String>> listA = list.entrySet().stream()
                        .filter(m1->m1.getValue().containsKey(intermediaryFlightFrom))
                        .filter(m2->m2.getValue().containsValue(intermediaryFlightTo))
                        .map(m3->m3.getValue())
                        .collect(Collectors.toList());

                final List< Map <String, String>> listB = list.entrySet().stream()
                        .filter(m1->m1.getValue().containsKey(intermediaryFlightTo))
                        .map(m2->m2.getValue())
                        .collect(Collectors.toList());
                List <Map<String,String>> finalList = Stream.concat(listA.stream(),listB.stream()).collect(Collectors.toList());
                System.out.print("Result -> " + finalList);
            } else {
                System.out.println("Error, one of the city was not found or there is no flights between cites... please try again");
            }
        } else {
            System.out.println("Incorrect value... please try again");
        }














    }
}