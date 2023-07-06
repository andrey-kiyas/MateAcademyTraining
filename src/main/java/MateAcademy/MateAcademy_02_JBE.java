package MateAcademy;

public class MateAcademy_02_JBE {
    public static void main(String[] args) {


//        int neighboursCellsSum = 3 + 1 + 1 + 9 = 14;
//        getNeighboursCellsSum();

//        int[][] matrix = new int[][]{
//                {-2, 3},
//                {11, 4}
//        };
//        getMaxElement(matrix);


//        якщо words = ["java", "mad", "zoo"], то результат буде 7;
//        якщо words = ["jazz", "hazy", "lazy"], то результат буде 0;
//        якщо words = ["pizza", "apple", "legalize"], то результат буде 5.

//        String[] words = new String[]{"laptop", "clan", "ability", "zigzag", "zombi"};
//        System.out.println(getWordsLength(words));

//        System.out.println(getPaymentSystem(55));

//        Product pr1 = new Product();
//        pr1.name = "pr1";
//        pr1.price = 25;
//        Product pr2 = new Product();
//        pr2.name = "pr2";
//        pr2.price = 50;
//        Product[] product = new Product[]{pr1, pr2};
//        calculatePrice(product);





//        Student student1 = new Student();

//                {"Alina", "Ivanova", 30, true},
//                {"Ivan", "Petrov", 26, false},
//                {"Irina", "Stetsenko", 35, true},
//                {"Yurii", "Shvets", 40, true},
//                {"Daria", "Kovalchyk", 33, false},
//                {"Olha", "Kulyk", 22, true}
//        };

        Student stud1 = new Student();
        stud1.age = 33;
        stud1.isEmployed = true;

        Student stud2 = new Student();
        stud2.age = 31;
        stud2.isEmployed = true;

        Student stud3 = new Student();
        stud3.age = 30;
        stud3.isEmployed = true;

        Student stud4 = new Student();
        stud4.age = 40;
        stud4.isEmployed = true;

        Student stud5 = new Student();
        stud5.age = 37;
        stud5.isEmployed = true;

        Student[] student = new Student[]{stud1, stud2, stud3, stud4, stud5};

        getPercentOfEmployedStudent(student);





//////////
    }
//////////

    public static class Student {
        String firstName;
        String lastName;
        int age;
        boolean isEmployed;
    }

    public static double getPercentOfEmployedStudent(Student[] studentsInfo) {
        // Write code below this line
        int empl = 0;
        int sumAge = 0;
        for (Student student : studentsInfo) {
            if (student.isEmployed && (student.age >= 30 || student.age <= 40)) {
                empl += 1;
            }
            if (student.age >= 30 || student.age <= 40) {
                sumAge += 1;
            }
        }
        System.out.println(studentsInfo.length);
        System.out.println(empl);
        System.out.println((double) empl / sumAge);
        return (double) empl / sumAge;
        // Write code above this line
    }

    public static String getPaymentSystem(int number) {
        // Write code below this line
        String system = "";
        switch (number) {
            case 34:
            case 37:
                system = "American Express";
//                System.out.println("American Express");
                break;
            case 4:
                system = "VISA";
//                System.out.println("VISA");
                break;
            case 52:
            case 53:
            case 54:
            case 55:
                system = "MasterCard";
//                System.out.println("MasterCard");
                break;
            case 63:
            case 67:
                system = "Maestro";
//                System.out.println("Maestro");
                break;
            default:
                system = "unknown payment system";
//                System.out.println("unknown payment system");
                break;
        }
        return system;
        // Write code above this line
    }

    public static int getWordsLength(String[] words) {
        // write code here
        int result = 0;
        for (String word : words) {
            boolean isCharA = false;
            boolean isCharZ = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == 'a') {
                    isCharA = true;
                }
                if (word.charAt(i) == 'z') {
                    isCharZ = true;
                }
            }
            if (isCharA && !isCharZ) {
                result += word.length();
                System.out.println("R: " + result + "  <--> WL: " + word.length());
            }
        }
        return result;
    }

    public static int getMaxElement(int[][] matrix) {
        int sum = matrix[0][0];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                sum = (sum < matrix[x][y]) ? matrix[x][y] : sum;
//                System.out.println(sum + " - " + matrix[x][y] );
            }
        }

        System.out.println(sum);
        return sum;
    }

    public static int getNeighboursCellsSum() {
        int rowIndex = 1;
        int columnIndex = 1;
        int[][] array = {{2, 3, 5},
                {1, 7, 1},
                {5, 9, 2}};

        int rowLength = array.length - 1;
        int columnLength = array[0].length - 1;
        boolean el1 = false, el2 = false, el3 = false, el4 = false;
        int sum = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if (rowIndex - 1 >= 0 && rowIndex - 1 <= rowLength && el1 == false) {
                    sum += array[rowIndex - 1][columnIndex];
//                    System.out.println(sum);
                    System.out.println(1 + " - " + array[rowIndex - 1][columnIndex]);
                    el1 = true;
                }
                if (rowIndex + 1 >= 0 && rowIndex + 1 <= rowLength && el2 == false) {
                    sum += array[rowIndex + 1][columnIndex];
//                    System.out.println(sum);
                    System.out.println(2 + " - " + array[rowIndex + 1][columnIndex]);
                    el2 = true;
                }
                if (columnIndex - 1 >= 0 && columnIndex - 1 <= columnLength && el3 == false) {
                    sum += array[rowIndex][columnIndex - 1];
//                    System.out.println(sum);
                    System.out.println(3 + " - " + array[rowIndex][columnIndex - 1]);
                    el3 = true;
                }
                if (columnIndex + 1 >= 0 && columnIndex + 1 <= columnLength && el4 == false) {
                    sum += array[rowIndex][columnIndex + 1];
//                    System.out.println(sum);
                    System.out.println(4 + " - " + array[rowIndex][columnIndex + 1]);
                    el4 = true;
                }
            }
        }
        System.out.println("Sum: " + sum);
        return sum;
    }


}
