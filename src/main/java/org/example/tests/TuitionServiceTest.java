package org.example.tests;

public class TuitionServiceTest {

    @Test
    void testRemainingBalanceAfterPayment() {
        // ARRANGE
        ITuitionService tuitionService = new TuitionServiceImpl();
        TuitionFeePayment paymentRecord = new TuitionFeePayment(5000.0); // Total fee is 5000

        // ACT
        tuitionService.makePayment(paymentRecord, 2000.0);

        // ASSERT
        assertEquals(3000.0, paymentRecord.getRemainingBalance(), "Balance should be 3000 after 2000 payment.");
    }

    @Test
    void testOverpaymentDoesNotResultInNegativeBalance() {
        ITuitionService tuitionService = new TuitionServiceImpl();
        TuitionFeePayment paymentRecord = new TuitionFeePayment(1000.0);

        // ACT: Paying more than the balance
        tuitionService.makePayment(paymentRecord, 1500.0);

        // ASSERT: Ensure it handles the 'change' or caps the balance at 0
        assertTrue(paymentRecord.getRemainingBalance() >= 0);
    }
}
