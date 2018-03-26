package com.DesignPattern;

import java.util.*;

public class LOGISTICS {

    public static void main(String[] args){

        Driving_Agency_Interface drivingAPI = new Driving_Agency();
        LOGISTICS_API logistics_api = new LOGISTICS_API_IMPL(drivingAPI);

        logistics_api.addDriver(new HumanDriver(100, "gagan", "Gurugram"));
        logistics_api.addDriver(new HumanDriver(200, "narendra", "Ahmedabad"));
        logistics_api.addDriver(new HumanDriver(300, "modi", "jaipur"));

        logistics_api.addVehicle(new Truck(501, "HR26-9229", "Gurugram"));
        logistics_api.addVehicle(new Truck(502, "GJ26-9229", "Ahmedabad"));
        logistics_api.addVehicle(new Truck(503, "RJ26-9229", "jaipur"));

        String cityF = "Gurugram";
        String cityT = "Ahmedabad";

        Driver one = null;
        System.out.println(" Drivers in city");
        Set<Driver> drivers = logistics_api.getAllDriversInCity(cityF);
        for (Driver driver : drivers){
            one = driver;
            System.out.println(" Driver " + driver);
        }

        Vehicle two = null;
        System.out.println(" Vehicles in city");
        Set<Vehicle> vehicles = logistics_api.getAllVehicleInCity(cityF);
        for (Vehicle vehicle : vehicles){
            two = vehicle;
            System.out.println(" Vehicle " + vehicle);
        }

        logistics_api.addDriving(one, two, cityF,cityT );

        System.out.println(" Is Driver " + one + " Driving ? ");
        System.out.println(logistics_api.isDriverDriving(one));

        System.out.println(" Is Vehicle " + one + " on Drive ? ");
        System.out.println(logistics_api.isVehicleOnRide(two));

    }

}

interface LOGISTICS_API{

    public void addDriver(Driver driver);
    public void addVehicle(Vehicle vehicle);
    public Set<Driver> getAllDriversInCity(String city);
    public Set<Vehicle> getAllVehicleInCity(String city);

    public long addDriving(Driver driver, Vehicle vehicle, String cityFrom, String cityTo);
    public boolean removeDriving(Driver driver, Vehicle vehicle);
    public DrivesInterface isDriverDriving(Driver driver);
    public DrivesInterface isVehicleOnRide(Vehicle vehicle);

}

class LOGISTICS_API_IMPL implements LOGISTICS_API{

    private HashMap<String, Set<Driver>> driverMap;
    private HashMap<String, Set<Vehicle>> vehicleMap;
    private Driving_Agency_Interface drivingAPI;

    public LOGISTICS_API_IMPL(Driving_Agency_Interface drivingAPI) {

        driverMap = new HashMap<>();
        vehicleMap = new HashMap<>();
        this.drivingAPI = drivingAPI;

    }

    @Override
    public void addDriver(Driver driver) {

        Set<Driver> drivers = driverMap.get(driver.getCiy());
        if (drivers == null){
            drivers = new HashSet<>();
            drivers.add(driver);
            driverMap.put(driver.getCiy(), drivers);
        }else {
            drivers.add(driver);
        }

        System.out.println(driver + " Driver added in System " );

    }

    @Override
    public void addVehicle(Vehicle vehicle) {

        Set<Vehicle> vehicles = vehicleMap.get(vehicle.getCity());
        if (vehicles == null){
            vehicles = new HashSet<>();
            vehicles.add(vehicle);
            vehicleMap.put(vehicle.getCity(), vehicles);
        }else {
            vehicles.add(vehicle);
        }

        System.out.println(vehicle + " vehicle added in system ");

    }

    @Override
    public Set<Driver> getAllDriversInCity(String city) {
        return driverMap.get(city);
    }

    @Override
    public Set<Vehicle> getAllVehicleInCity(String city) {
        return vehicleMap.get(city);
    }

    @Override
    public long addDriving(Driver driver, Vehicle vehicle, String cityFrom, String cityTo) {
        drivingAPI.addDriving(driver, vehicle, cityFrom, cityTo);
        return drivingAPI.getTotalDrivings();
    }

    @Override
    public boolean removeDriving(Driver driver, Vehicle vehicle) {

        return drivingAPI.removeDriving(driver, vehicle);

    }

    @Override
    public DrivesInterface isDriverDriving(Driver driver) {
        return drivingAPI.isDriverDriving(driver);
    }

    @Override
    public DrivesInterface isVehicleOnRide(Vehicle vehicle) {
        return drivingAPI.isVehicleOnRide(vehicle);
    }

}

interface Vehicle{

    public Driver getDriver();
    public void setDriver(Driver driver);
    public String getCity();
    public String getNumber();

}

class Truck implements Vehicle{

    private final int id;
    private final String number;
    private Driver driver;
    private String city;

    public Truck(int id, String number, String city) {
        this.id = id;
        this.city = city;
        this.number = number;
    }

    public Truck(int id, String number, Driver driver, String city) {
        this.id = id;
        this.number = number;
        this.driver = driver;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Truck truck = (Truck) o;

        if (id != truck.id) return false;
        if (!number.equals(truck.number)) return false;
        if (driver != null ? !driver.equals(truck.driver) : truck.driver != null) return false;
        return city.equals(truck.city);

    }

    @Override
    public int hashCode() {

        int result = id;
        result = 31 * result + number.hashCode();
        result = 31 * result + (driver != null ? driver.hashCode() : 0);
        result = 31 * result + city.hashCode();
        return result;

    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", driver=" + driver +
                ", city='" + city + '\'' +
                '}';
    }
}

interface Driver{

    public String getName();
    public void setVehicle(Vehicle vehicle);
    public Vehicle getVehicle();
    public String getCiy();

}

class HumanDriver implements Driver{

    private final int id;
    private final String name;
    private Vehicle vehicle;
    private String ciy;

    public HumanDriver(int id, String name, String ciy) {
        this.id = id;
        this.ciy = ciy;
        this.name = name;
    }

    public HumanDriver(int id, String name, Vehicle vehicle, String ciy) {
        this.id = id;
        this.name = name;
        this.ciy = ciy;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getCiy() {
        return ciy;
    }

    public void setCiy(String ciy) {
        this.ciy = ciy;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HumanDriver that = (HumanDriver) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (vehicle != null ? !vehicle.equals(that.vehicle) : that.vehicle != null) return false;
        return ciy.equals(that.ciy);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + ciy.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "HumanDriver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vehicle=" + vehicle +
                ", ciy='" + ciy + '\'' +
                '}';
    }
}

interface Driving_Agency_Interface {

    public long addDriving(Driver driver, Vehicle vehicle, String cityFrom, String cityTo);
    public boolean removeDriving(Driver driver, Vehicle vehicle);
    public DrivesInterface isDriverDriving(Driver driver);
    public DrivesInterface isVehicleOnRide(Vehicle vehicle);
    public long getTotalDrivings();

}

class Driving_Agency implements Driving_Agency_Interface {

    public static long count = 0;

    private HashMap<Driver, DrivesInterface> driverMap;
    private HashMap<Vehicle, DrivesInterface> vehicleMap;
    private List<DrivesInterface> list;

    public long getTotalDrivings(){
        return count;
    }

    public Driving_Agency() {
        driverMap = new HashMap<>();
        vehicleMap =  new HashMap<>();
        list = new ArrayList<>();
    }

    @Override
    public long addDriving(Driver driver, Vehicle vehicle, String cityFrom, String cityTo) {

        DrivesInterface driving = new DrivesInProgress(count+1, driver, vehicle, cityFrom, cityTo);
        list.add(driving);

        driverMap.put(driver, driving);
        vehicleMap.put(vehicle, driving);
        count += 1;
        System.out.println(" Driving_Agency_Interface added for " + driver + " on vehicle " + vehicle + " from " + cityFrom + " to " + cityTo);
        return count;

    }

    @Override
    public boolean removeDriving(Driver driver, Vehicle vehicle) {

        driverMap.remove(driver);
        vehicleMap.remove(vehicle);
        System.out.println(" Driving_Agency_Interface removed for driver " + driver + " to vehicle " + vehicle);
        return true;

    }

    @Override
    public DrivesInterface isDriverDriving(Driver driver) {

        return driverMap.get(driver);

    }

    @Override
    public DrivesInterface isVehicleOnRide(Vehicle vehicle) {

        return vehicleMap.get(vehicle);

    }

}

interface DrivesInterface{

}

class DrivesInProgress implements DrivesInterface{

    private long id;
    private Driver driver;
    private Vehicle vehicle;
    private String cityFrom;
    private String cityTo;

    public DrivesInProgress(long id, Driver driver, Vehicle vehicle, String cityFrom, String cityTo) {
        this.id = id;
        this.driver = driver;
        this.vehicle = vehicle;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    @Override
    public String toString() {
        return "DrivesInProgress{" +
                "id=" + id +
                ", driver=" + driver +
                ", vehicle=" + vehicle +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                '}';
    }
}