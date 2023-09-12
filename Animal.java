public class Animal {
    String denumire, tip, sex;
    int age;

    public Animal(String denumire, String tip, String sex, int age){
        this.denumire = denumire;
        this.tip = tip;
        this.sex = sex;
        this.age = age;
    }
    public static void main(String[] args){
        Animal animal = new Animal("Caine", "mamifer", "f", 2);
        System.out.println(animal.denumire+" "+animal.tip+ " "+animal.sex+" "+animal.age);
    }
}
