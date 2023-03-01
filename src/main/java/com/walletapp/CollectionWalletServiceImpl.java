package com.walletapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CollectionWalletServiceImpl implements CollectionWalletService {
    @Autowired
    private CollectionWalletRepository walletRepository;
    @Override
    public WalletDto registerWallet(WalletDto wallet)  {
        return walletRepository.createWallet(wallet);
    }

    @Override
    public WalletDto getWalletById(Integer walletId) throws WalletException {
        return walletRepository.getWalletById(walletId);
    }

    @Override
    public WalletDto updateWallet(WalletDto wallet) throws WalletException {
        return walletRepository.updateWallet(wallet);
    }

    @Override
    public WalletDto deleteWalletById(Integer walletId) throws WalletException {
        return walletRepository.deleteWalletById(walletId);
    }

    @Override
    public WalletDto addFundsToWalletById(Integer walletId, Double amount) throws WalletException {
        if(amount<0)
            throw new WalletException("given amount:"+amount+" is invalid");
        WalletDto walletToAddFund=walletRepository.getWalletById(walletId);
        walletToAddFund.setBalance(amount+walletToAddFund.getBalance());
        return walletToAddFund;
    }

    @Override
    public WalletDto withdrawFundsFromWalletById(Integer walletById, Double amount) throws WalletException {
        if(amount<0)
            throw new WalletException("given amount:"+amount+" is invalid");
        WalletDto walletToWithdrawFund=walletRepository.getWalletById(walletById);
        if(amount>walletToWithdrawFund.getBalance())
            throw new WalletException("Insufficient funds,balance in wallet with id:"+walletById+" is:"+walletToWithdrawFund.getBalance());
        walletToWithdrawFund.setBalance(walletToWithdrawFund.getBalance()-amount);
        return walletToWithdrawFund;
    }

    @Override
    public String  fundTransfer(Integer fromWalletId, Integer toWalletId, Double amount) throws WalletException {
          if(amount<0)
           throw new WalletException("given amount:"+amount+" is invalid");
       //calculation
        WalletDto walletToWithdrawFund=walletRepository.getWalletById(fromWalletId);
        if(amount>walletToWithdrawFund.getBalance())
           throw new WalletException("Insufficient funds,balance in wallet with id:"+fromWalletId+" is:"+walletToWithdrawFund.getBalance());
        walletToWithdrawFund.setBalance(walletToWithdrawFund.getBalance()-amount);
        WalletDto walletToAddFund=walletRepository.getWalletById(toWalletId);
        walletToAddFund.setBalance(amount+walletToAddFund.getBalance());
        return "transaction successful!";
    }

    @Override
    public List<WalletDto> getAllWallets() {
        return walletRepository.getAllWallets();
    }
}
