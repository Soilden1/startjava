public class WolfTest {
    
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();

        wolfOne.gender = "male";
        wolfOne.nickname = "Akella";
        wolfOne.weight = 60;
        wolfOne.age = 9;
        wolfOne.color = "grey";

        System.out.println("gender = " + wolfOne.gender);
        System.out.println("nickname = " + wolfOne.nickname);
        System.out.println("weight = " + wolfOne.weight);
        System.out.println("age = " + wolfOne.age);
        System.out.println("color = " + wolfOne.color);

        wolfOne.move();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}