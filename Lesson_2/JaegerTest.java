public class JaegerTest {
    
    public static void main(String[] args) {
        Jaeger jaegerOne = new Jaeger();
        jaegerOne.setModelName("Gipsy Danger");
        jaegerOne.setMark("Mark-3");
        jaegerOne.setOrigin("USA");
        jaegerOne.setHeight(260);
        jaegerOne.setWeight(1.980f);
        jaegerOne.setStrength(8);
        jaegerOne.setArmor(6);

        Jaeger jaegerTwo = new Jaeger("Striker Eureka", "Mark-5", "Australia", 250, 1.850f, 10, 9);

        System.out.printf("jagerOne: %nИмя: %s%nМодель: %s%nПроизводитель: %s%nВысота:" +
                "%f%nМасса: %f%nСила: %d%nБроня: %d%n%n", jaegerOne.getModelName(), jaegerOne.getMark(), 
                jaegerOne.getOrigin(), jaegerOne.getHeight(), jaegerOne.getWeight(), 
                jaegerOne.getStrength(), jaegerOne.getArmor());

        System.out.println("jaegerTwo:");
        System.out.println("Броня " + jaegerTwo.getModelName() + ": " + jaegerTwo.getArmor());
        jaegerTwo.setArmor(15);
        System.out.println("Новая броня " + jaegerTwo.getModelName() + ": " + jaegerTwo.getArmor());
        jaegerTwo.setHeight(-212.32f);
        System.out.println("Высота " + jaegerTwo.getModelName() + ": " + jaegerTwo.getHeight() + "\n");

        jaegerOne.move();
        jaegerTwo.useWeapons();
    }
}