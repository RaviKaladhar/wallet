package com.walletapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class WalletControllerTest {
    @Value("${local.server.port}")
    Integer port;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    TestRestTemplate testRestTemplate;
    @MockBean
    CollectionWalletRepository walletRepository;
//    @MockBean
//    WalletController walletController;
    @Test
    public void getWalletById() throws WalletException
    {
        //given(walletController.getWalletById(1)).willReturn(new WalletDto(1,"Ford",null,null,null,null));
        given(walletRepository.getWalletById(1)).willReturn(new WalletDto(1,"Ford",null,null,null,null));
        assertEquals(testRestTemplate.getForObject("http://localhost:"+port+"/wallet/1",WalletDto.class).getName(),"Ford");
    }
}
