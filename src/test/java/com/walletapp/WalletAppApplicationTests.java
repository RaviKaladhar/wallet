package com.walletapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
class WalletAppApplicationTests {
//
//	WalletDto registerWallet(WalletDto wallet)throws WalletException ;
//	WalletDto getWalletById(Integer walletId) throws WalletException;
//	WalletDto updateWallet(WalletDto wallet)throws WalletException;
//	WalletDto deleteWalletById(Integer walletId)throws WalletException;
//
//
//	Double addFundsToWalletById(Integer walletId,Double amount)throws WalletException;
//	Double withdrawFundsFromWalletById(Integer walletById,Double amount) throws WalletException;
//	Boolean fundTransfer(Integer fromWalletId,Integer toWalletId,Double amount)throws WalletException;
//
//	List<WalletDto> getAllWallets();
    @Autowired
	private CollectionWalletService walletService;
	@Test
	@BeforeEach
	void registerWalletTest() throws WalletException{
		WalletDto registeredWallet=walletService.registerWallet(new WalletDto(1,"rakesh",2500.0,"rakesh@gmail.com","rakesh@123",LocalDate.of(2021,10,12)));

       assertEquals(registeredWallet,registeredWallet);
	}
    @Test
	void updateWalletTest()
	{

		assertThrows(WalletException.class,()->walletService.updateWallet(new WalletDto(2)));
	}
	@Test
	public void deleteWalletTest() throws WalletException
	{
		assertEquals("rakesh",walletService.deleteWalletById(1).getName());
	}
	@Test
	public void getWalletByIdTest() throws WalletException
	{
		assertThrows(WalletException.class,()->walletService.getWalletById(100));
		assertThat(walletService.getWalletById(1).getName()).contains("rakesh");
	}
}
