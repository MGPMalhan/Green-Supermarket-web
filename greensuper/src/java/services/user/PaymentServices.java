/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.user;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.List;
import models.OrderDetails;

public class PaymentServices {

    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";
    private static final String MODE = "sandbox";

    public String authorizePayment(List<OrderDetails> orderDetail)
            throws PayPalRESTException {

        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        System.out.println("=== CREATED PAYMENT: ====");
        System.out.println(approvedPayment);

        return getApprovalLink(approvedPayment);

    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("William")
                .setLastName("Peterson")
                .setEmail("william.peterson@company.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/greensuper/cancel.jsp");
        redirectUrls.setReturnUrl("http://localhost:8080/greensuper/review_payment");

        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(List<OrderDetails> orderDetailsList) {

        Transaction transaction = new Transaction();

        Details details = new Details();
        double subtotal = 0;
        double tax = 0;
        double shipping = 0;

        List<Item> items = new ArrayList<>();

        for (OrderDetails orderDetail : orderDetailsList) {
            // Accumulate details for each item
            subtotal += Double.parseDouble(orderDetail.getSubtotal());
            tax += Double.parseDouble(orderDetail.getTax());
            shipping += Double.parseDouble(orderDetail.getShipping());

            // Create an item
            Item item = new Item();
            item.setCurrency("USD");
            item.setName(orderDetail.getProductName());
            item.setPrice(orderDetail.getSubtotal());
            item.setTax(orderDetail.getTax());
            item.setQuantity("1");

            items.add(item);
        }
        

        details.setShipping(String.valueOf(shipping));
        details.setSubtotal(String.valueOf(subtotal));
        details.setTax(String.valueOf(tax));

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(String.format("%.2f", subtotal + tax + shipping));
        amount.setDetails(details);

        transaction.setAmount(amount);
        transaction.setDescription("Multiple Products Purchase");

        ItemList itemList = new ItemList();
        itemList.setItems(items);

        List<Transaction> listTransaction = new ArrayList<>();
        transaction.setItemList(itemList);
        listTransaction.add(transaction);
        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }

        return approvalLink;
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }
}
