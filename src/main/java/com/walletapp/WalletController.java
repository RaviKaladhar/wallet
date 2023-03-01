package com.walletapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class WalletController {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    private WalletService walletService;
    @GetMapping(value = "greet/")
    public String greet(){
        return "Hello welcome to wallet app.";
    }
    @PostMapping(value = "/wallet/")
    public WalletDto registerWallet(@RequestBody @Valid WalletDto wallet)
    {
        return walletService.registerWallet(wallet);
    }
    @GetMapping(value = "/wallet/{id}")
    public WalletDto getWalletById(@PathVariable Integer id)throws WalletException
    {
        return walletService.getWalletById(id);
    }
    @PutMapping(value = "/wallet/")
    public WalletDto updateWalletById(@RequestBody @Valid WalletDto wallet)throws WalletException
    {
        return walletService.updateWallet(wallet);
    }
    @DeleteMapping(value = "/wallet/{id}")
    public WalletDto deleteWalletById(@PathVariable Integer id) throws WalletException
    {
        return walletService.deleteWalletById(id);
    }
//    @PutMapping(value = "/wallet/{id}/{amount}")
//    public WalletDto addFundsToWalletById(@PathVariable Integer id,@PathVariable Double amount)throws WalletException
//    {
//        return walletService.addFundsToWalletById(id,amount);
//    }
//    @PutMapping(value = "/wallet/fund/{id}/{amount}")
//    public WalletDto withdrawFundsFromWalletById(@PathVariable("id") Integer walletById,@PathVariable("amount") Double amount) throws WalletException {
//        return walletService.withdrawFundsFromWalletById(walletById,amount);
//    }
//    @PutMapping(value = "/wallet/{fromWalletId}/{toWalletId}/{amount}")
//    public String  fundTransfer(@PathVariable Integer fromWalletId,@PathVariable Integer toWalletId,@PathVariable Double amount) throws WalletException {
//        return walletService.fundTransfer(fromWalletId,toWalletId,amount);
//    }
//    @GetMapping("/wallets/")
//    public List<WalletDto> getAllWallets()
//    {
//        return walletService.getAllWallets();
//    }
    @GetMapping("/wallets/")
    public List<WalletDto> findAll() {
        return walletService.findAll();
    }
    @GetMapping("/wallets/name/{name}")
    public List<WalletDto> findByName(@PathVariable("name") String name)
    {
        return walletService.findByName(name);
    }
    @GetMapping("/wallets/like/{name}")
    List<WalletDto> findByNameContaining(@PathVariable String name)
    {
        return walletService.findByNameContaining(name);
    }
    @GetMapping("/wallets/between/{min}/{max}")
    List<WalletDto> findByBalanceBetweenOrderByBalanceDesc(@PathVariable("min") Double min,@PathVariable("max") Double max)
    {
        return walletService.findByBalanceBetweenOrderByBalanceDesc(min,max);
    }
    @GetMapping("/wallets/date/{date}")
    List<WalletDto> findByDateOfCreation(@PathVariable("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date)
    {
        return walletService.findByDateOfCreation(date);
    }
    @PutMapping("/wallet/query/")
    public void insertIntoTable(@RequestBody WalletDto wallet) {
        walletService.insertIntoTable(wallet);
    }
}
