import java.util.Scanner;

class GuessNumberTest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuation = "yes";

        while (continuation.equals("yes")) {
            System.out.print("Введите имя первого игрока: ");
            Player playerOne = new Player(sc.next());
            System.out.print("Введите имя второго игрока: ");
            Player playerTwo = new Player(sc.next());

            GuessNumber gn = new GuessNumber(playerOne, playerTwo);
            boolean isGuessed = false;
            while (!isGuessed) {
                System.out.print(playerOne.getName() + ", введите число: ");
                int number = sc.nextInt();
                playerOne.setNumber(number);
                isGuessed = gn.attemptPlayerOne();

                if (!isGuessed) {
                    System.out.print(playerTwo.getName() + ", введите число: ");
                    number = sc.nextInt();
                    playerTwo.setNumber(number);
                    isGuessed = gn.attemptPlayerTwo();
                }
            }

            do {
            System.out.println("Хотите продолжить игру? [yes/no]");
            continuation = sc.next();
            } while (!continuation.equals("yes") && !continuation.equals("no"));
        }
    }
}