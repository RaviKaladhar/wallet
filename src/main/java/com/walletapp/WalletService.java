package com.walletapp;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.List;

public interface WalletService {
    WalletDto registerWallet(WalletDto wallet);
    WalletDto getWalletById(Integer walletId) throws WalletException;
    WalletDto updateWallet(WalletDto wallet)throws WalletException;
    WalletDto deleteWalletById(Integer walletId)throws WalletException;
    List<WalletDto> findAll();
    List<WalletDto> findByName(String name);
    List<WalletDto> findByNameContaining(String name);
    List<WalletDto> findByBalanceBetweenOrderByBalanceDesc(Double min,Double max);
    List<WalletDto> findByDateOfCreation(LocalDate date);
}
