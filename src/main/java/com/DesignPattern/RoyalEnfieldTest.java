package com.DesignPattern;

import java.util.HashMap;

public class RoyalEnfieldTest {

    public static void main(String[] args){

        RoyalEnfieldFactoryInterface chennaiFactory = API.installFactory("chennai");
        System.out.println(chennaiFactory.makeClassic());
        System.out.println(chennaiFactory.makeThunderBord());

        System.out.println();
        RoyalEnfieldFactoryInterface chandigarhFactory = API.installFactory("chandigarh");
        System.out.println(chandigarhFactory.makeClassic());
        System.out.println(chandigarhFactory.makeThunderBord());

    }

}

abstract class API{

    public static RoyalEnfieldFactoryInterface installFactory(String city){

        EngineFactoryInterface  engineF     = new EngineFactory(city);
        BodyFactory             bodyF       = new BodyFactory(city);
        RoyalEnfieldFactory chennaiFactory  = new RoyalEnfieldFactory(city, engineF, bodyF);
        return chennaiFactory;
    }

}

interface RoyalEnfieldFactoryInterface{

    public RoyalEnfield makeThunderBord();
    public RoyalEnfield makeClassic();

}

class RoyalEnfieldFactory implements RoyalEnfieldFactoryInterface{

    private EngineFactoryInterface engineFactory;
    private BodyFactoryInterface bodyFactory;
    private String city;

    public RoyalEnfieldFactory(String name, EngineFactoryInterface engineFactory, BodyFactoryInterface bodyFactory) {

        this.city = name;
        this.engineFactory = engineFactory;
        this.bodyFactory = bodyFactory;
        System.out.println( name + " RoyalEnfieldFactory Estalished ");

    }

    public RoyalEnfield makeThunderBord(){

        return new RoyalEnfield(engineFactory.getEngine(EngineFactory.STANDARD_ENGIE),bodyFactory.getBody(BodyFactory.THUNDERBIRD_BODY), city);

    }

    public RoyalEnfield makeClassic(){

        return new RoyalEnfield(engineFactory.getEngine(EngineFactory.STANDARD_ENGIE),bodyFactory.getBody(BodyFactory.STANDARD_BODY), city);


    }

}

interface EngineFactoryInterface{

    public Engine getEngine(String engineType);

}

class EngineFactory implements EngineFactoryInterface{

    public static String STANDARD_ENGIE = "StandardEngine";
    public static final int ID = 100;
    private HashMap<String, Engine> map;
    private String name;

    public EngineFactory(String name) {

        this.name = name;
        map = new HashMap<>();
        map.put(EngineFactory.STANDARD_ENGIE, new Engine(EngineFactory.STANDARD_ENGIE, EngineFactory.ID) );
        System.out.println( name + " EngineFactory Estalished ");

    }

    public Engine getEngine(String engineType){

        Engine engine = map.get(engineType);
        return new Engine(engine.getName(), engine.getId());

    }

}

interface BodyFactoryInterface{

    public Body getBody(String body);

}

class BodyFactory implements BodyFactoryInterface{

    public static final String STANDARD_BODY = "StandardBODY";
    public static final String THUNDERBIRD_BODY = "ThunderbirdBODY";

    public static final int ID_STANDARD = 100;
    public static final int ID_THUNDERBIRD = 200;

    private HashMap<String, Body> map;
    private String name;

    public BodyFactory(String name) {

        this.name = name;
        this.map = new HashMap<>();
        map.put(BodyFactory.STANDARD_BODY, new Body(BodyFactory.STANDARD_BODY, BodyFactory.ID_STANDARD));
        map.put(BodyFactory.THUNDERBIRD_BODY, new Body(BodyFactory.THUNDERBIRD_BODY, BodyFactory.ID_THUNDERBIRD));
        System.out.println( name + " BodyFactory Estalished ");

    }

    public Body getBody(String body){

        Body body1 =  map.get(body);
        return new Body(body1.getName(), body1.getId());

    }

}

class Engine{

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Engine(String name, int id) {

        this.name = name;
        this.id = id;

    }

    @Override
    public String toString() {
        return "Engine{" +
                "city='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class Body{

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Body(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Body{" +
                "city='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class RoyalEnfield{

    private Engine engine;
    private Body body;
    private String madeIn;

    public RoyalEnfield(Engine engine, Body body, String madeIn) {
        this.engine = engine;
        this.body = body;
        this.madeIn = madeIn;
    }

    @Override
    public String toString() {
        return "RoyalEnfield{" +
                "engine=" + engine +
                ", body=" + body +
                ", madeIn='" + madeIn + '\'' +
                '}';
    }
}

