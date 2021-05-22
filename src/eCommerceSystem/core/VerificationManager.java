package eCommerceSystem.core;

import java.util.Random;
import java.util.Scanner;
import eCommerceSystem.business.concretes.AuthManager;
import eCommerceSystem.entities.concretes.User;

public class VerificationManager extends AuthManager implements VerificationService {

	@Override
	public boolean verificate(User user) {
		Scanner scanner = new Scanner(System.in);
		char chosenValue = 'h';
		System.out.println(user.getEmail()
				+ " adresine bir dogrulama kodu gönderildi. Hesabýnýzý onaylamak istiyor musunuz? (E/H)");
		chosenValue = scanner.next().charAt(0);

		if (chosenValue == 'e' || chosenValue == 'E') {
			Random random = new Random();
			int randomInteger, enteredNumber, count = 0;

			do {
				randomInteger = random.nextInt(999999 - 100000 + 1) + 100000;

				System.out.println(
						"Hesabýnýzý doðrulamak  için mailinize gelen 6 haneli þifreyi giriniz:\n--> " + randomInteger);
				enteredNumber = scanner.nextInt();
				count++;
				if (count == 4) {
					System.out.println(
							"Çok sayýda hatalý giriþ yaptýnýz, hesap doðrulanamadý. \n Lütfen daha sonra tekrar deneyiniz..");
					
					
					System.out.println(scanner.nextLine());
					return false;
				}
			} while (!(enteredNumber == randomInteger) && count < 4);
			
			
			
			System.out.println("Hesap doðrulandý. ");
			System.out.println(scanner.nextLine());
			return true;

		}
		
		System.out.println(scanner.nextLine());
		return false;
		
	}

}
