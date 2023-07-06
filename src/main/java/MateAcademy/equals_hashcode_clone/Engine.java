package MateAcademy.equals_hashcode_clone;

public class Engine implements Cloneable {
    private String cylinderBlock;
    private String injectionSystem;
    private String supplySystem;
    private String lubricationSystem;
    private String coolingSystem;

    public Engine() { //please don't remove this constructor!
    }

    //write your code here
    public String getCylinderBlock() {
        return cylinderBlock;
    }

    public void setCylinderBlock(String cylinderBlock) {
        this.cylinderBlock = cylinderBlock;
    }

    public String getInjectionSystem() {
        return injectionSystem;
    }

    public void setInjectionSystem(String injectionSystem) {
        this.injectionSystem = injectionSystem;
    }

    public String getSupplySystem() {
        return supplySystem;
    }

    public void setSupplySystem(String supplySystem) {
        this.supplySystem = supplySystem;
    }

    public String getLubricationSystem() {
        return lubricationSystem;
    }

    public void setLubricationSystem(String lubricationSystem) {
        this.lubricationSystem = lubricationSystem;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    public void setCoolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "cylinderBlock='" + cylinderBlock + '\'' +
                ", injectionSystem='" + injectionSystem + '\'' +
                ", supplySystem='" + supplySystem + '\'' +
                ", lubricationSystem='" + lubricationSystem + '\'' +
                ", coolingSystem='" + coolingSystem + '\'' +
                '}';
    }

    public Engine(String cylinderBlock, String injectionSystem, String supplySystem, String lubricationSystem, String coolingSystem) {
        this.cylinderBlock = cylinderBlock;
        this.injectionSystem = injectionSystem;
        this.supplySystem = supplySystem;
        this.lubricationSystem = lubricationSystem;
        this.coolingSystem = coolingSystem;
    }

    @Override
    protected Engine clone() throws CloneNotSupportedException {
        return new Engine(cylinderBlock, injectionSystem, supplySystem, lubricationSystem, coolingSystem);
    }

//    @Override
//    protected Engine clone() {
//        try {
//            return (Engine) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException("Can't clone engine", e);
//        }
//    }
}
