package App;

import Entity.Account;

import java.util.Scanner;

public class App {
    AccountApp accountApp = new AccountApp();
    Scanner scanner = new Scanner(System.in);
    Account account;
    public void menu(){
        System.out.println("\t\tWelcome\n" +
                "\t\tfor singUp insert 1\n" +
                "\t\telse insert any key to continue\n");
        int section = scanner.nextInt();
        if (section==1){
            accountApp.singUp();
        }else {
            if (accountApp.logIn()){
                menuUser();
            }
        }
    }
    private void menuUser(){
        boolean isRun=true;
        this.account=accountApp.myAccount();
        while (isRun){

        }
    }
}
