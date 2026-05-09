import org.example.Entities.Course;
import org.example.Entities.TuitionFeePayment;
import org.example.Exceptions.InvalidPaymentAmountException;
import org.example.Implementations.TuitionServiceImpl;
import org.example.Interfaces.ITuitionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class TuitionServiceTest {
    private ITuitionService tuitionService;

    @BeforeEach
    void setUp() {
        tuitionService = new TuitionServiceImpl();
    }

    @Test
    @DisplayName("Should correctly subtract payment from balance")
    void testRemainingBalanceAfterPayment() throws InvalidPaymentAmountException {
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

        // ACT & ASSER
        assertThrows(InvalidPaymentAmountException.class, () -> {
            tuitionService.makePayment(paymentRecord, 1500.0);
        });;
    }

    @Test
    @DisplayName("Should not change balance if payment is zero")
    void testZeroPaymentDoesNotChangeBalance() {
        TuitionFeePayment paymentRecord = new TuitionFeePayment(1000.0);
        assertThrows(InvalidPaymentAmountException.class, () -> {
            tuitionService.makePayment(paymentRecord, 0.0);
        });
    }

    @Test
    @DisplayName("Should throw exception if payment is zero or negative")
    void testInvalidPaymentThrowsException() {
        TuitionFeePayment paymentRecord = new TuitionFeePayment(1000.0);

        // Test Zero
        assertThrows(InvalidPaymentAmountException.class, () -> {
            tuitionService.makePayment(paymentRecord, 0.0);
        });

        // Test Negative
        assertThrows(InvalidPaymentAmountException.class, () -> {
            tuitionService.makePayment(paymentRecord, -100.0);
        });
    }

    @Test
    @DisplayName("Should calculate tuition correctly based on course count")
    void testCalculateTotalFee() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("101", "Java", "IT"));
        courses.add(new Course("102", "Python", "IT"));

        double total = tuitionService.calculateTotalFee(courses);

        // 2 courses * 1500 = 3000
        assertEquals(3000.0, total);
    }
}