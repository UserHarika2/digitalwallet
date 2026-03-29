package com.digitalwallet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DigitalWalletTest {

    @Test
    void testDeposit() {
        DigitalWallet wallet = new DigitalWallet("User1", 1000);
        wallet.deposit(500);
        assertEquals(1500, wallet.getBalance());
    }

    @Test
    void testWithdraw() {
        DigitalWallet wallet = new DigitalWallet("User1", 1000);
        wallet.withdraw(400);
        assertEquals(600, wallet.getBalance());
    }

    @Test
    void testWithdrawInsufficientBalance() {
        DigitalWallet wallet = new DigitalWallet("User1", 500);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            wallet.withdraw(1000);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    void testTransfer() {
        DigitalWallet sender = new DigitalWallet("User1", 1000);
        DigitalWallet receiver = new DigitalWallet("User2", 500);

        sender.transfer(receiver, 300);

        assertEquals(700, sender.getBalance());
        assertEquals(800, receiver.getBalance());
    }

    @Test
    void testInvalidDeposit() {
        DigitalWallet wallet = new DigitalWallet("User1", 1000);
        assertThrows(IllegalArgumentException.class, () -> {
            wallet.deposit(-100);
        });
    }

    @Test
    void testInvalidWithdraw() {
        DigitalWallet wallet = new DigitalWallet("User1", 1000);
        assertThrows(IllegalArgumentException.class, () -> {
            wallet.withdraw(-50);
        });
    }
}