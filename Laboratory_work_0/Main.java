package Laboratory_work_0;

public class Main
{
    public static void main(String[] args){
        Animal animal = new Animal("Caine", "mamifer", "f", 2);
        System.out.println("Denumire: "+animal.denumire+"\n"+"Tip: "+animal.tip+"\n"+"Sex: "+animal.sex+"\n"+"Age: "+animal.age);
    }
}
