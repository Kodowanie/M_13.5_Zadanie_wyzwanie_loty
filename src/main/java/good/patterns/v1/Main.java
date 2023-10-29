package good.patterns.v1;

import good.patterns.v1.abstraction.IFlightDatabase;

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

        System.out.println("Welcome to SomethingAirline! Plesae pick your option: ");
        System.out.println("1. Chose all flight 'FROM' city");
        System.out.println("2. Chose all flight 'TO' city");
        System.out.println("3. Find connection from city A to cit B, if no direct line exist find intermediary route");
        Scanner scanner = new Scanner(System.in);


       //Task 1 solve
       System.out.print("Chose flight 'FROM: ");
       String fromCity = scanner.next();
       list.entrySet().stream().filter(m1->m1.getValue().containsKey(fromCity)).forEach(System.out::println);

        //Task 2 solve
        System.out.print("Find flight 'TO': ");
        String toCity = scanner.next();
        list.entrySet().stream().filter(m1->m1.getValue().containsValue(toCity)).forEach(System.out::println);

    }
}