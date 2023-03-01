package com.walletapp;

import java.util.List;

public interface CollectionWalletService {

    WalletDto registerWallet(WalletDto wallet);
    WalletDto getWalletById(Integer walletId) throws WalletException;
    WalletDto updateWallet(WalletDto wallet)throws WalletException;
    WalletDto deleteWalletById(Integer walletId)throws WalletException;


    WalletDto addFundsToWalletById(Integer walletId,Double amount)throws WalletException;
    WalletDto withdrawFundsFromWalletById(Integer walletById,Double amount) throws WalletException;
    String  fundTransfer(Integer fromWalletId,Integer toWalletId,Double amount)throws WalletException;

    List<WalletDto> getAllWallets();
}
