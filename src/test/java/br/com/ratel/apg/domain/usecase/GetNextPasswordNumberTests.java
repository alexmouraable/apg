package br.com.ratel.apg.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.ratel.apg.domain.data.password.GetGreaterPasswordNumberData;
import br.com.ratel.apg.domain.entry.password.ExistsPasswordEntry;
import br.com.ratel.apg.domain.entry.password.GetNextPasswordNumberEntry;
import br.com.ratel.apg.domain.entry.password.request.ExistsPasswordRequest;
import br.com.ratel.apg.domain.entry.password.request.GetNextPasswordNumberRequest;
import br.com.ratel.apg.domain.type.PasswordType;

@ExtendWith(SpringExtension.class)
public class GetNextPasswordNumberTests {

	@TestConfiguration
	static class GetNextPasswordNumberTestsConfiguration {

		@Bean
		public GetNextPasswordNumberEntry getNextPasswordNumberEntry() {
			return new GetNextPasswordNumberUseCase();
		}

	}

	@MockBean
	private ExistsPasswordEntry existsPasswordEntry;

	@MockBean
	private GetGreaterPasswordNumberData getGreaterPasswordNumberData;

	@Autowired
	private GetNextPasswordNumberEntry getNextPasswordNumberEntry;

	@Test
	public void return1IfNoNormalPasswordGeneratedForToday() {
		ExistsPasswordRequest existsPasswordRequest = new ExistsPasswordRequest();
		existsPasswordRequest.setPasswordType(PasswordType.NORMAL);
		
		when(this.existsPasswordEntry.execute(existsPasswordRequest)).thenReturn(false);

		GetNextPasswordNumberRequest request = new GetNextPasswordNumberRequest();
		request.setPasswordType(PasswordType.NORMAL);
		
		Integer expectedPasswordNumber = 1;
		Integer passwordNumber = this.getNextPasswordNumberEntry.execute(request);
		assertEquals(expectedPasswordNumber, passwordNumber);
	}

	@Test
	public void return500IfNoPreferredPasswordGeneratedForToday() {
		ExistsPasswordRequest existsPasswordRequest = new ExistsPasswordRequest();
		existsPasswordRequest.setPasswordType(PasswordType.PREFERENCIAL);
		
		when(this.existsPasswordEntry.execute(existsPasswordRequest)).thenReturn(false);
		
		GetNextPasswordNumberRequest request = new GetNextPasswordNumberRequest();
		request.setPasswordType(PasswordType.PREFERENCIAL);
		
		Integer expectedPasswordNumber = 500;
		Integer passwordNumber = this.getNextPasswordNumberEntry.execute(request);
		assertEquals(expectedPasswordNumber, passwordNumber);
	}

	@Test
	public void return2IfNormalPasswordGeneratedToday() {
		/*
		ExistsPasswordRequest existsPasswordRequest = new ExistsPasswordRequest();
		existsPasswordRequest.setPasswordType(PasswordType.NORMAL);
		*/

		when(this.existsPasswordEntry.execute(ArgumentMatchers.any(ExistsPasswordRequest.class))).thenReturn(true);
		
		when(this.getGreaterPasswordNumberData.execute(PasswordType.NORMAL, LocalDate.now())).thenReturn(1);

		GetNextPasswordNumberRequest request = new GetNextPasswordNumberRequest();
		request.setPasswordType(PasswordType.NORMAL);
		
		Integer expectedPasswordNumber = 2;
		Integer passwordNumber = this.getNextPasswordNumberEntry.execute(request);
		assertEquals(expectedPasswordNumber, passwordNumber);
	}
	
	@Test
	public void return501IfNormalPasswordGeneratedToday() {
		/*
		ExistsPasswordRequest existsPasswordRequest = new ExistsPasswordRequest();
		existsPasswordRequest.setPasswordType(PasswordType.PREFERENCIAL);
		*/
		
		when(this.existsPasswordEntry.execute(ArgumentMatchers.any(ExistsPasswordRequest.class))).thenReturn(true);
		
		when(this.getGreaterPasswordNumberData.execute(PasswordType.PREFERENCIAL, LocalDate.now())).thenReturn(500);
		
		GetNextPasswordNumberRequest request = new GetNextPasswordNumberRequest();
		request.setPasswordType(PasswordType.PREFERENCIAL);
		
		Integer expectedPasswordNumber = 501;
		Integer passwordNumber = this.getNextPasswordNumberEntry.execute(request);
		assertEquals(expectedPasswordNumber, passwordNumber);
	}
	
}