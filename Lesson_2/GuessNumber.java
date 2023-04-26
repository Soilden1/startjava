import java.util.Random;

class GuessNumber {

    private Player playerOne;
    private Player playerTwo;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    Random random = new Random();
    private int hiddenNumber = random.nextInt(100) + 1;

    public boolean attemptPlayerOne() {
        int number = playerOne.getNumber();
        if (number == hiddenNumber) {
            System.out.println(playerOne.getName() + " победил!");
            return true;
        } else {
            String position;
            if (number > hiddenNumber) {
                position = "больше";
            } else {
                position = "меньше";
            }
            System.out.printf("Число %d %s того, что загадал компьютер%n", number, position);
            return false;
        }
    }

    public boolean attemptPlayerTwo() {
        int number = playerTwo.getNumber();
        if (number == hiddenNumber) {
            System.out.println(playerTwo.getName() + " победил!");
            return true;
        } else {
            String position;
            if (number > hiddenNumber) {
                position = "больше";
            } else {
                position = "меньше";
            }
            System.out.printf("Число %d %s того, что загадал компьютер%n", number, position);
            return false;
        }
    }
}