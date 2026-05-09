import org.example.Entities.TuitionFeePayment;
import org.example.Implementations.TuitionServiceImpl;
import org.example.Interfaces.ITuitionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TuitionServiceTest {

    @Test
    @DisplayName("Should correctly subtract payment from balance")
    void testRemainingBalanceAfterPayment() {
        // ARRANGE
        ITuitionService tuitionService = new TuitionServiceImpl();
        TuitionFeePayment paymentRecord = new TuitionFeePayment(5000.0);

        // ACT
        tuitionService.makePayment(paymentRecord, 2000.0);

        // ASSERT
        assertEquals(3000.0, paymentRecord.getRemainingBalance(),
                "Balance should be exactly 3000 after a 2000 payment.");
    }

    @Test
    @DisplayName("Should cap balance at zero when student overpays")
    void testOverpaymentDoesNotResultInNegativeBalance() {
        // ARRANGE
        ITuitionService tuitionService = new TuitionServiceImpl();
        TuitionFeePayment paymentRecord = new TuitionFeePayment(1000.0);

        // ACT: Paying 1500 on a 1000 debt
        tuitionService.makePayment(paymentRecord, 1500.0);

        // ASSERT:
        assertEquals(0.0, paymentRecord.getRemainingBalance(),
                "Balance should be capped at 0.0, not negative.");
    }

    @Test
    @DisplayName("Should not change balance if payment is zero")
    void testZeroPaymentDoesNotChangeBalance() {
        ITuitionService tuitionService = new TuitionServiceImpl();
        TuitionFeePayment paymentRecord = new TuitionFeePayment(1000.0);

        tuitionService.makePayment(paymentRecord, 0.0);
        assertEquals(1000.0, paymentRecord.getRemainingBalance());
    }
}