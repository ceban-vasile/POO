package challenges_0;

public class MathsUtils {
    public static void mathsutils(int number){
        int[] list = new int[25];
        String numbers = "(";
        int j = 0, sum = 0;
        for(int i = 1; i < number; i++){
            if(i%3 == 0){
                list[j] = i;
                j++;
            }
            if(i%5 == 0) {
                list[j] = i;
                j++;
            }
        }
        numbers = numbers + list[0];
        sum = list[0];
        for(int i = 1; i < j; i++){
            if(list[i] != list[i+1]){
                sum = sum + list[i];
                numbers = numbers + ", ";
                numbers = numbers + list[i];
            }
        }
        numbers = numbers + ")";
        System.out.println(number+"->"+sum+numbers);
    }
}
