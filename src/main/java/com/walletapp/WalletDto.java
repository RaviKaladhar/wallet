package com.walletapp;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
@Entity
public class WalletDto { // POJO
    @NotNull(message = "id cannot be null")
    @Min(value = 1,message = "must be greater than or equal to 1")
    @Max(value = 100,message = "must be less than 100 or equal to 100")
    @Id
    private Integer id;
    @NotNull(message = "name cannot be null")
    @Pattern(regexp = "[A-Za-z_ ]{3,20}[0-9]{0,5}",message = "must be alphabets without special characters")
    private String name;
    @NotNull(message = "balance cannot be null")
    @Min(0)
    private Double balance;
    @Email(regexp = "[a-z]{1,8}@[a-z]{1,8}.com")
    private String email;
    @Pattern(regexp = ".{5,10}",message = "password length must be between 5 to 10")
    private String password;
    @NotNull
    private LocalDate dateOfCreation;
    // email, pWD, date of wallet creation

    public WalletDto() {
    }

    public WalletDto(Integer id, String name, Double balance, String email, String password, LocalDate dateOfCreation) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.dateOfCreation = dateOfCreation;
    }
    public WalletDto(Integer id)
    {
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }

}
