package com.DesignPattern;

public class Bridge {

    public static void main(String args[])
    {

        Lamp lampA = new LampA();
        Switch aSwitch = new SwitchA(lampA);

        aSwitch.OnOff(true);

        lampA = new LampB();
        aSwitch.setLamp(lampA);
        aSwitch.OnOff(true);

    }


}



interface Lamp{

    public void OnOff(boolean on);

}

abstract class Switch{

    protected Lamp lamp;

    public Switch(Lamp lamp) {
        this.lamp = lamp;
    }

    public void OnOff(boolean on){
        lamp.OnOff(on);
    }

    public void setLamp(Lamp lamp) {
        this.lamp = lamp;
    }
}

class LampA implements Lamp{


    @Override
    public void OnOff(boolean on) {
        if (on)
            System.out.println(" Lamp A on ");
        else
            System.out.println(" Lamp A off ");
    }
}

class LampB implements Lamp{


    @Override
    public void OnOff(boolean on) {
        if (on)
            System.out.println(" Lamp B on ");
        else
            System.out.println(" Lamp B off ");
    }
}

class SwitchA extends Switch{



    public SwitchA(Lamp lamp) {
        super(lamp);
    }

    public void OnOff(boolean on){
        if (on)
            System.out.println(" Switch A on ");
        else
            System.out.println(" Switch A off ");
        lamp.OnOff(on);
    }
}


class SwitchB extends Switch{

    public SwitchB(Lamp lamp) {
        super(lamp);
    }

    public void OnOff(boolean on){
        if (on)
            System.out.println(" Switch B on ");
        else
            System.out.println(" Switch B off ");
        lamp.OnOff(on);
    }
}
