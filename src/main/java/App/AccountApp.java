package App;

import Entity.Account;
import Service.imp.AccountService;

import java.util.Scanner;

public class AccountApp {
    Scanner scanner = new Scanner(System.in);
    Account account;
    AccountService accountService;
    public void singUp(){
        try {
        System.out.println("\t\twelecom");
        System.out.print("\tplease insert your name: ");
        String name = scanner.next();
        System.out.println();
        System.out.print("\tplease insert your passcode: ");
        int passcode=scanner.nextInt();
        account = new Account(null,null,name,passcode);
       Account account1= accountService.add(account);
            System.out.println("\tyour account: "+account1);
    }catch (Exception e){
            e.printStackTrace();
            System.out.println("\t\t!!!please try again!!!");
        }
    }

}
