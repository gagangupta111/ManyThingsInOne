package com.DesignPattern;

import java.util.HashMap;

public class RoyalEnfieldTest {

    public static void main(String[] args){

        EngineFactory chennaiEngineF = new EngineFactory("Chennai Engine factory");
        BodyFactory chennaiBodyF = new BodyFactory("Chennai Body factory");
        RoyalEnfieldFactory chennaiFactory = new RoyalEnfieldFactory("Chennai factory", chennaiEngineF, chennaiBodyF);

        System.out.println(chennaiFactory.makeClassic());
        System.out.println(chennaiFactory.makeThunderBord());

        System.out.println();
        EngineFactory chandigarhEngineF = new EngineFactory("Chandigarh Engine factory");
        BodyFactory chandigarhBodyF = new BodyFactory("Chandigarh Body factory");
        RoyalEnfieldFactory chandigarhFactory = new RoyalEnfieldFactory("Chandigarh factory", chandigarhEngineF, chandigarhBodyF);

        System.out.println(chandigarhFactory.makeClassic());
        System.out.println(chandigarhFactory.makeThunderBord());

    }

}

interface RoyalEnfieldFactoryInterface{

    public RoyalEnfield makeThunderBord();
    public RoyalEnfield makeClassic();

}

class RoyalEnfieldFactory implements RoyalEnfieldFactoryInterface{

    private EngineFactory engineFactory;
    private BodyFactory bodyFactory;
    private String name;

    public RoyalEnfieldFactory(String name, EngineFactory engineFactory, BodyFactory bodyFactory) {
        this.name = name;
        this.engineFactory = engineFactory;
        this.bodyFactory = bodyFactory;
        System.out.println( name + " Estalished ");
    }

    public RoyalEnfield makeThunderBord(){

        return new RoyalEnfield(engineFactory.getEngine(EngineFactory.STANDARD_ENGIE),bodyFactory.getBody(BodyFactory.THUNDERBIRD_BODY) );

    }

    public RoyalEnfield makeClassic(){

        return new RoyalEnfield(engineFactory.getEngine(EngineFactory.STANDARD_ENGIE),bodyFactory.getBody(BodyFactory.STANDARD_BODY) );


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
        System.out.println( name + " Estalished ");

    }

    public Engine getEngine(String engineType){

        return map.get(engineType);

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
        System.out.println( name + " Estalished ");
    }

    public Body getBody(String body){

        return map.get(body);

    }

}

class Engine{

    private String name;
    private int id;

    public Engine(String name, int id) {

        this.name = name;
        this.id = id;

    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class Body{

    private String name;
    private int id;

    public Body(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Body{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class RoyalEnfield{

    private Engine engine;
    private Body body;

    public RoyalEnfield(Engine engine, Body body) {
        this.engine = engine;
        this.body = body;
    }

    @Override
    public String toString() {
        return "RoyalEnfield{" +
                "engine=" + engine +
                ", body=" + body +
                '}';
    }
}

