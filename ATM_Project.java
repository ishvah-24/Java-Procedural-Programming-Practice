import java.util.Scanner;

public class ATM_Project {
    public static void main(String[] args){

        // Predefined PIN and Balance
        int pin = 1234;
        float balance = 54210;

        // Allows for intake of use input
        Scanner scanner = new Scanner(System.in);
        byte userChoice;
        System.out.print("Bank Management System: \n");

        // PIN entry loop allows for only a max of 3 attempts
        for(byte i = 0; true; i++){
            System.out.print("Enter PIN: ");

            int userPIN = scanner.nextInt();

            if (userPIN != pin) {
                System.out.println("Incorrect PIN, try again.");
                if(i == 2){
                    System.out.println("Max amount of attempts reached, try again later.");
                    // When 3 attempts is exceeded, it will stop the program
                    System.exit(0);
                }
            }
            else {
                break;
            }
        }

        do {
            // Menu interface
            System.out.println(
                    "1. Check Balance \n" +
                    "2. Deposit Money \n" +
                    "3. Withdraw Money \n" +
                    "4. Change PIN \n" +
                    "5. Exit \n"
            );


            System.out.print("Enter an option: ");
            userChoice = scanner.nextByte();

            // Used a switch case system to allow navigation through the program
            switch (userChoice) {

                // Balance print out
                case 1:
                    System.out.println("R" + balance);
                    break;

                // Deposit function
                case 2:
                    System.out.print("Enter amount you would like to deposit: R");
                    float depositAmount = scanner.nextFloat();

                    // Checks if amount entered by user is less than 0
                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount.");

                    }else {
                        balance = balance + depositAmount;
                        System.out.println("Balance: R" + balance);
                    }
                    break;

                // Withdraw Function
                case 3:
                    System.out.print("Enter amount you would like to withdraw: R");
                    float withdrawAmount = scanner.nextFloat();

                    //Checks if withdraw amount is higher than balance
                    if(withdrawAmount>balance){
                        System.out.println("Insufficient Funds, try again\n");
                        System.out.println("Current Balance: R" + balance+"\n");
                    }

                    // Checks if Withdraw amount is less than 0
                    else if(withdrawAmount<=0){
                        System.out.println("Invalid Amount, try again.\n");
                    }else{
                        balance = balance - withdrawAmount;
                        System.out.println("Balance: R" + balance + "\n");
                    }
                    break;

                // Change PIN function
                case 4:

                    //Prompts user to first enter their current PIN
                    System.out.print("Enter your current PIN: ");
                    int userPIN = scanner.nextInt();

                    //Checks if user entered wrong current PIN
                    if(userPIN!= pin){
                        System.out.println("Incorrect PIN");
                    }else{
                        System.out.print("Enter your new PIN: ");
                        int newPIN = scanner.nextInt();
                        String str = Integer.toString(newPIN);
                        int length = str.replace("-", "").length();

                        //Input validation for new PIN
                        if(length<4){
                            System.out.println("Pin length too short. \n");
                        }else if(newPIN==pin){
                            System.out.println("New pin can't be the same as current PIN \n");
                        }else{
                            System.out.println("Pin Change successful\n");
                            pin = newPIN;
                        }
                    }
                    break;

                // Program Exit
                case 5:
                    System.out.println("Goodbye!");

                    // Close scanner to free up resources and reduce leaks
                    scanner.close();
                    break;

                default:
                    System.out.println("Invalid Entry, try again \n");
                    break;
            };
        }while (userChoice != 5);
    }
}