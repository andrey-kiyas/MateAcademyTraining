package MateAcademy.equals_hashcode_clone;

public class Car implements Cloneable {
    private Engine engine;
    private String chassis;
    private String body;
    private String transmission;
    private String brakeSystem;

    public Car() { //please don't remove this constructor!
    }

    //write your code here
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBrakeSystem() {
        return brakeSystem;
    }

    public void setBrakeSystem(String brakeSystem) {
        this.brakeSystem = brakeSystem;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", chassis='" + chassis + '\'' +
                ", body='" + body + '\'' +
                ", transmission='" + transmission + '\'' +
                ", brakeSystem='" + brakeSystem + '\'' +
                '}';
    }

    public Car(Engine engine, String chassis, String body, String transmission, String brakeSystem) {
        this.engine = engine;
        this.chassis = chassis;
        this.body = body;
        this.transmission = transmission;
        this.brakeSystem = brakeSystem;
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return new Car(engine.clone(), chassis, body, transmission, brakeSystem);
    }

//    @Override
//    public Car clone() {
//        try {
//            Car clonedCar = (Car) super.clone();
//            clonedCar.setEngine(engine.clone());
//            return clonedCar;
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException("Can't create Car clone", e);
//        }
//    }
}
