package MateAcademy.more;

public class Plane {
    //write your code below this line
    private final String wing;
    private final String cabin;
    private final String aileron;
    private final String chassis;
    private final String engine;

    public Plane(PlaneBuilder planeBuilder) {
        this.wing = planeBuilder.wing;
        this.cabin = planeBuilder.cabin;
        this.aileron = planeBuilder.aileron;
        this.chassis = planeBuilder.chassis;
        this.engine = planeBuilder.engine;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "wing='" + wing + '\'' +
                ", cabin='" + cabin + '\'' +
                ", aileron='" + aileron + '\'' +
                ", chassis='" + chassis + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }

    public static class PlaneBuilder {
        private String wing;
        private String cabin;
        private String aileron;
        private String chassis;
        private String engine;

        public PlaneBuilder setWing(String wing) {
            this.wing = wing;
            return this;
        }

        public PlaneBuilder setCabin(String cabin) {
            this.cabin = cabin;
            return this;
        }

        public PlaneBuilder setAileron(String aileron) {
            this.aileron = aileron;
            return this;
        }

        public PlaneBuilder setChassis(String chassis) {
            this.chassis = chassis;
            return this;
        }

        public PlaneBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Plane build() {
            return new Plane(this);
        }
    }
}