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
				+ " adresine bir dogrulama kodu g�nderildi. Hesab�n�z� onaylamak istiyor musunuz? (E/H)");
		chosenValue = scanner.next().charAt(0);

		if (chosenValue == 'e' || chosenValue == 'E') {
			Random random = new Random();
			int randomInteger, enteredNumber, count = 0;

			do {
				randomInteger = random.nextInt(999999 - 100000 + 1) + 100000;

				System.out.println(
						"Hesab�n�z� do�rulamak  i�in mailinize gelen 6 haneli �ifreyi giriniz:\n--> " + randomInteger);
				enteredNumber = scanner.nextInt();
				count++;
				if (count == 4) {
					System.out.println(
							"�ok say�da hatal� giri� yapt�n�z, hesap do�rulanamad�. \n L�tfen daha sonra tekrar deneyiniz..");
					
					
					System.out.println(scanner.nextLine());
					return false;
				}
			} while (!(enteredNumber == randomInteger) && count < 4);
			
			
			
			System.out.println("Hesap do�ruland�. ");
			System.out.println(scanner.nextLine());
			return true;

		}
		
		System.out.println(scanner.nextLine());
		return false;
		
	}

}
