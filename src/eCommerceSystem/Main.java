package eCommerceSystem;

import java.util.Scanner;
import eCommerceSystem.business.abstracts.AuthService;
import eCommerceSystem.business.abstracts.UserService;
import eCommerceSystem.business.concretes.AuthManager;
import eCommerceSystem.business.concretes.UserManager;
import eCommerceSystem.core.GoogleManagerAdapter;
import eCommerceSystem.core.GoogleService;
import eCommerceSystem.core.UserValidationManager;
import eCommerceSystem.core.VerificationManager;
import eCommerceSystem.dataAccess.concretes.HibernateUserDao;
import eCommerceSystem.entities.concretes.User;


public class Main {
	static boolean loggedIn;
    static Scanner scan = new Scanner(System.in);
    static UserService userService = new UserManager(new HibernateUserDao());
    static AuthService authService = new AuthManager(userService, new UserValidationManager(),new VerificationManager());

	public static void main(String[] args) {
		
		String mainMenu = "Ho� geldin!\n\n" + 
						"1.Mail ile kay�t\n" +
						"2.Google ile kay�t\n" + 
						"3.Mail ile giri� yap\n" + 
						"4.Google ile giri� yap\n" + 
						"5.��k��\n" +
						"-----------------------------------";
		
		System.out.println(mainMenu);
		int key ;
        while (true){
        	
            System.out.print("L�tfen yapmak istedi�iniz i�lem numaras�n� yaz�n�z: ");
      
            if(scan.hasNextInt()){key = scan.nextInt();
            
            switch (key){
                case 1:
                	register();
                    	System.out.println(mainMenu);
                    break;
                case 2:
                    signUpWithGoogle();                   
                    	System.out.println(mainMenu);
                    break;
                case 3:
                	logIn();
                	if(loggedIn = true) {
                	System.out.println(loggedMessage);
                	}else {
                		System.out.println(mainMenu);}
                    break;
                case 4:
                	logInWithGoogle();
                	if(loggedIn = true) {
                    	System.out.println(loggedMessage);
                    	}else {
                    		System.out.println(mainMenu);}
                    break;   
                case 5:
                    return;
                default:
                    System.out.println("L�tfen ge�erli bir say� giriniz.");
            }
		
            }
            
            loggedloop:
                while (loggedIn){
                    System.out.print("L�tfen i�lem se�iniz: ");
                    if(scan.hasNextInt()){key = scan.nextInt();
                    
                    switch (key){
                        case 1:
                            updateAccount();
                            break;
                        case 2:
                            deleteAccount();
                            break;
                        case 3:
                            System.out.println(mainMenu);
                            loggedIn = false;
                            break;
                        
                        default:
                            System.out.println("L�tfen ge�erli bir say� giriniz.");
                    }
                }
            }	
	}}
	
	static String loggedMessage = "Merhaba!\n\n" +
    		"1. Bilgilerimi g�ncelle\n"+
            "2. Hesab�m� sil\n"+
            "3. ��k�� yap\n" ;
	
	
    public static void register(){
    	loggedIn = authService.register(1, "G�listan", "Ay", "gulistanayy@mail.com", "123456");
    	loggedIn = false;
    }

    public static void signUpWithGoogle() {
    	GoogleService googleService = new GoogleManagerAdapter();
    	googleService.register(3, "Engin", "Demiro�", "engin@demirog.com", "654321");
    	loggedIn =false;
    }
    
    public static void logIn(){
        authService.logIn("gulistanayy@mail.com", "123456");
        loggedIn = true;
    }

    public static void logInWithGoogle(){
    	GoogleService googleService = new GoogleManagerAdapter();
    	googleService.logIn("engin@demirog.com", "654321");
    	loggedIn = true;
        
    }

    public static void deleteAccount(){
    	User user = new User(3, "Engin", "Demiro�", "engin@demirog.com", "654321");
    	userService.delete(user);
        System.out.println("Hesap ba�ar�yla silindi.");
    }
    
    public static void updateAccount(){
    	User user = new User(3, "Engin", "Demiro�", "engin@demirog.com", "654321");
    	userService.update(user);
        System.out.println("Bilgileriniz g�ncellendi.");
        loggedIn = true;
    }
}
