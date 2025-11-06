package com.Myntra.clone.clone.modal;


import com.Myntra.clone.clone.user.domain.PaymentMethod;
import com.Myntra.clone.clone.user.domain.PaymentStatus;
import lombok.Data;

@Data
public class PaymentDetails {
	
	private PaymentMethod paymentMethod;
	private PaymentStatus status;
	private String paymentId;
	private String razorpayPaymentLinkId;
	private String razorpayPaymentLinkReferenceId;
	private String razorpayPaymentLinkStatus;
	private String razorpayPaymentId​;

}
