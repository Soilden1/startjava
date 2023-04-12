class MyFirstGame {

    public static void main(String[] args) {
        int hiddenNum = 10;
        int inputNum = 81;
        int statusChangedCounter = 0;
        int iteration = 0;
        String lastPositionStatus = "не известен";

        while (inputNum != hiddenNum) {
            String position = "больше";
            if (inputNum < hiddenNum) {
                position = "меньше";
            }

            if (hiddenNum != inputNum) {
                System.out.printf("Число %d %s того, что загадал компьютер%n", inputNum, position);

                // Симуляция выбора игрока
                if (lastPositionStatus != position && iteration != 0) {
                    statusChangedCounter++;
                }

                if (position == "больше") {
                    lastPositionStatus = "больше";
                } else {
                    lastPositionStatus = "меньше";
                }

                if (statusChangedCounter == 0) {
                    if (position == "больше") {
                        inputNum -= 30;
                    } else {
                        inputNum += 30;
                    }
                } else if (statusChangedCounter == 1) {
                    if (position == "больше") {
                        inputNum -= 15;
                    } else {
                        inputNum += 15;
                    }
                } else if (statusChangedCounter == 2) {
                    if (position == "больше") {
                        inputNum -= 5;
                    } else {
                        inputNum += 5;
                    }
                } else if (statusChangedCounter >= 3) {
                    if (position == "больше") {
                        inputNum -= 1;
                    } else {
                        inputNum += 1;
                    }
                }

                if (inputNum > 100) {
                    inputNum = 100;
                } else if (inputNum < 1) {
                    inputNum = 1;
                }
            }
            iteration++;
        }

        System.out.println("Вы победили!");
    }
}