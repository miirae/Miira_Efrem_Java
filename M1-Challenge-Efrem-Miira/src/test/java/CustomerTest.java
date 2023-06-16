import com.company.AccountRecord;
import com.company.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer a;
    Customer b;
    Customer c;
    @BeforeEach
    public void setUp() {
        a = new Customer();
        a.setId(1);
        a.setName("Miira");

        b = new Customer();
        b.setId(2);
        b.setName("Tom");

        AccountRecord ar1 = new AccountRecord();
        ar1.setCharge(1500);
        ar1.setChargeDate("06-01-2023");

        b.getCharges().add(ar1);

        c = new Customer();
        c.setId(10);
        c.setName("Gloria");

        c.getCharges().add(ar1);
        AccountRecord ar2 = new AccountRecord();
        ar2.setChargeDate("01-23-2022");
        ar2.setCharge(-2000);
        c.getCharges().add(ar2);
    }

    @Test
    public void shouldGetBalance() {
        assertEquals(0, a.getBalance());
        assertEquals(1500, b.getBalance());
        assertEquals(-500, c.getBalance());
    }

    @Test
    public void testToString() {
        assertEquals("1,Miira,0", a.toString());
        assertEquals("2,Tom,1500", b.toString());
        assertEquals("10,Gloria,-500", c.toString());
    }
}