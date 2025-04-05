package lt.vilniustech.dgrigorovic.pirmas.model;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private BigInteger accountNumber;
    private float balance;

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getAccountName() {
        return accountNumber;
    }

    public void setAccountName(BigInteger accountName) {
        this.accountNumber = accountName;
    }

    public float getAmount() {
        return balance;
    }

    public void setAmount(float amount) {
        this.balance = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
