package com.walletapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Primary
@Service
public class WalletServiceImpl implements WalletService{
    @Autowired
    WalletRepository walletRepository;
    @Override
    public WalletDto registerWallet(WalletDto wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public WalletDto getWalletById(Integer walletId) throws WalletException {
         Optional<WalletDto> foundWallet=walletRepository.findById(walletId);
         if(!foundWallet.isPresent())
             throw new WalletException("wallet with given id :"+walletId+" doesn't exist");
         return foundWallet.get();
    }

    @Override
    public WalletDto updateWallet(WalletDto wallet) throws WalletException {
        Optional<WalletDto> foundWallet=walletRepository.findById(wallet.getId());
        if(!foundWallet.isPresent())
            throw new WalletException("wallet with given id :"+wallet.getId()+" doesn't exist to update");
        return walletRepository.save(wallet);
    }

    @Override
    public WalletDto deleteWalletById(Integer walletId) throws WalletException {
        Optional<WalletDto> foundWallet=walletRepository.findById(walletId);
        if(foundWallet.isEmpty())
            throw new WalletException("wallet with given id :"+walletId+" doesn't exist to delete");
        WalletDto wallet=foundWallet.get();
        walletRepository.deleteById(walletId);
        return wallet;
    }
    @Override
    public List<WalletDto> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public List<WalletDto> findByName(String name)
    {
        return walletRepository.findByName(name);
    }
    public List<WalletDto> findByNameContaining(String name)
    {
        return walletRepository.findByNameContaining(name);
    }
    public List<WalletDto> findByBalanceBetweenOrderByBalanceDesc(Double min,Double max)
    {
       return walletRepository.findByBalance(min,max);
    }
    public List<WalletDto> findByDateOfCreation(LocalDate date)
    {
        return walletRepository.findByDateOfCreation(date);
    }
}
