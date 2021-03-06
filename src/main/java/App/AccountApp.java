package App;

import Entity.Account;
import Service.LoginService;
import Service.imp.AccountService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Scanner;

public class AccountApp {
    Scanner scanner = new Scanner(System.in);
    Account account;
    String name;
    AccountService accountService = new AccountService();
    LoginService loginService = new LoginService();
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
    public void changePassword(String idName){
        accountService.setName(idName);
        try{
        System.out.println();
        System.out.print("please insert newPassCode: ");
        Integer passCode = scanner.nextInt();
        accountService.changePassword(passCode);
    }catch (Exception e){
            e.printStackTrace();
            System.out.println("\t\t!!!WROong!!!");
        }
    }
    public void ShowAllUser(){
        List<Account> accountList;
        try {
            accountList=accountService.findAll();
            accountList.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("\t\t!!!Not Find!!!");
        }
    }
    public void findByUser(){
        Account account2;
        System.out.print("\tplease insert userId: ");
        Integer name=scanner.nextInt();
        account2=accountService.findByUserId(name);
    }
    public Account findById(){
        Account account2;
        System.out.print("\tplease insert userId: ");
        Integer id=scanner.nextInt();
        account2=accountService.findById(id);
        return account2;
    }
    public Account findByName(){
        Account account2;
        System.out.print("\tplease insert userName: ");
        String name = scanner.next();
        account2=accountService.findByUserName(name);
        return account2;
    }
    public boolean logIn(){
        System.out.print("please insert userName: ");
        String name = scanner.next();
       // System.out.println();
        System.out.print("please insert passcode: ");
        Integer passcode=scanner.nextInt();
        Boolean check =loginService.checking(name,passcode);
        if(check){
            System.out.println("\t\tyou currect");
            this.name=name;
            return true;
        }else {
            System.out.println("\t\tNot find");
            return false;

        }
    }
    public Account myAccount(){
        Account account2;
        System.out.println(this.name+"  ddd ");
        account2=accountService.findByUserName(this.name);
        return account2;

    }
}
