package pl.edu.education_project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EducationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationProjectApplication.class, args);

		double [] numbers = {1, 2, 3, 4, 5};
		long n = 1234567890;
		PublicService publicService = new PublicService();
		double sum = publicService.getSum(numbers);
		double sumOfNumber = publicService.getSumOfNumber(numbers);
		int[] numbersOfTry = publicService.functionForTraining(n);

		log.info("Suma wynikowa n na odwrót: ", numbersOfTry);
		log.info("Suma wynikowa tablicy: [{}]", sum);
		log.info("Suma wynikowa tablicy: [{}]", sumOfNumber);
	}
}
