package com.walletapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface WalletRepository extends JpaRepository<WalletDto,Integer> {
    List<WalletDto> findByName(String name);
    List<WalletDto> findByNameContaining(String name);
    @Query("select w from WalletDto w where w.balance between :min and :max order by w.id DESC")
    List<WalletDto> findByBalance(Double min, Double max);
    @Query("select w from WalletDto w where w.dateOfCreation>:date")
    List<WalletDto> findByDateOfCreation(LocalDate date);
}
