package MateAcademy.Java8.Part1.сheckElectricEngine;

import java.util.function.Predicate;

public class CheckElectricEngine implements Predicate<Engine> {
    //write your code here
    @Override
    public boolean test(Engine engine) {
        return engine.getEngineType().equals(Engine.EngineType.ELECTRIC);
    }

    public static void main(String[] args) {
        Engine engine1 = new Engine();
        engine1.setEngineType(Engine.EngineType.ELECTRIC);
        Engine engine2 = new Engine();
        engine2.setEngineType(Engine.EngineType.DIESEL);
        Engine engine3 = new Engine();
        engine3.setEngineType(Engine.EngineType.GASOLINE);

        CheckElectricEngine checkElectricEngine = new CheckElectricEngine();

        System.out.println(checkElectricEngine.test(engine1));
        System.out.println(checkElectricEngine.test(engine2));
        System.out.println(checkElectricEngine.test(engine3));


    }
}
