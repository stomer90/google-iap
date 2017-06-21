package com.samples.google.paymentiap;

public class App {

	public static void main(String[] args) {
		VerifyPaymentGoogle action = new VerifyPaymentGoogle();
		
		GoogleIAPConfig config = new GoogleIAPConfig();
		config.setPathFile("V21_PhongThanTuong-29ae39dfb1fc.p12");
		config.setServiceAccount("v21phongthantuong@api-6024552073570747935-484113.iam.gserviceaccount.com");
		
		String packageName = "phongthantuong.vtcgame.mobile";
		String productId = "phongthantuong.vtcgame.mobile0.99";
		String purchaseToken = "afdgdfopnlgoammakjheehlp.AO-J1OxrfO5B-D4qIZ4qp7jMs3RFkmgm9LEHu7ce5HMMiAFMDDWC1kDXSjZXCCA8wK0MWH8QSIGMcJh_NxhgBs7_xzXI-IgkyVk38ADbJhBa9RXsY0CZdtI-8cbMiXQGXXMEPwpo32P7RxTfT05-VtHgNs6v95XoRENyodJrreVrXdLI7HSNdlg";
		
		GoogleVerifyResponse response = action.verifyPayment(packageName, productId, purchaseToken, config);
		
		System.out.println("Response: " + action.toJsonString(response));
	}

}
