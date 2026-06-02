public class TypeCasting{
    public static void main(String[] args){

        double num1 = 50.54;
        int value1 = (int) num1;

        int num2 = 45;
        double value2 = (double) num2;

        System.out.println("before casting: " + num1);
        System.out.println("after casting: " + value1);

        System.out.println("before casting: " + num2);
        System.out.println("after casting: " + value2);

    }
}