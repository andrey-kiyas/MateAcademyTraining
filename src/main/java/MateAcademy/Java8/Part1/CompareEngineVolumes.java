package MateAcademy.Java8.Part1;

import java.util.function.BinaryOperator;

public class CompareEngineVolumes implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer int1, Integer int2) {
        return int1 - int2;
    }


//    @Override
//    public Integer apply(Integer integer, Integer integer) {
//        return null;
//    }



//    public int accept(Integer int1, Integer int2) {
//        return int1 - int2;
//    }




//    @Override
//    public Integer apply(Integer int1, Integer int2) {
//        return int1 - int2;
//    }

    //write your code here
//    @Override
//    public Integer apply(Integer engine1, Integer engine2) {
//        return Math.abs(engine1 - engine2);
//    }

//    @Override
//    public Integer apply(Integer int1, Integer int2) {
//        return int1 - int2;
//    }
}



//public class CompareEngineVolumes implements BiFunction<Integer, Integer, Integer> {


