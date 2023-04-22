public class WolfTest {
    
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();

        wolfOne.setGender("male");
        wolfOne.setNickname("Akella");
        wolfOne.setWeight(60);
        wolfOne.setAge(8);
        wolfOne.setColor("grey");

        System.out.println("gender = " + wolfOne.getGender());
        System.out.println("nickname = " + wolfOne.getNickname());
        System.out.println("weight = " + wolfOne.getWeight());
        System.out.println("age = " + wolfOne.getAge());
        System.out.println("color = " + wolfOne.getColor());

        wolfOne.move();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}