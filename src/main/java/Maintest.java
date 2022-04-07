import App.App;
public class Maintest {
    static {
        System.out.println("Static block");
    }
    public static void main(String[] args) {


         App app = new App();
         while (true){
         try {
             app.menu();
         }catch (Exception e){
             e.printStackTrace();
             continue;
         }
    }

    }
}
