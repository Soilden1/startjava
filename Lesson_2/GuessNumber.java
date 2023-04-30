import java.util.Scanner;
import java.util.Random;

class GuessNumber {

    private int hiddenNumber;
    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void launch() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        hiddenNumber = random.nextInt(100) + 1;

        do {
            System.out.print(player1.getName() + ", введите число: ");
            player1.setNumber(sc.nextInt());

            if (isGuessed(player1)) {
                System.out.print(player2.getName() + ", введите число: ");
                player2.setNumber(sc.nextInt());
            } else {
                return;
            }
        } while (isGuessed(player2));
    }

    private boolean isGuessed(Player player) {
        int number = player.getNumber();
        if (number == hiddenNumber) {
            System.out.println(player.getName() + " победил!");
            return false;
        }

        String state;
        if (number > hiddenNumber) {
            state = "больше";
        } else {
            state = "меньше";
        }
        System.out.printf("Число %d %s того, что загадал компьютер%n", number, state);
        return true;
    }
}