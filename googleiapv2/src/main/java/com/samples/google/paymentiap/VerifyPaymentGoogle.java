package com.samples.google.paymentiap;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.androidpublisher.AndroidPublisher;
import com.google.api.services.androidpublisher.model.ProductPurchase;

public class VerifyPaymentGoogle {

	public GoogleVerifyResponse verifyPayment(String packageName, String productId, String purchaseToken, GoogleIAPConfig iapConfig){
		GoogleVerifyResponse response = new GoogleVerifyResponse();
		try {
			JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
			NetHttpTransport TRANSPORT = new NetHttpTransport();
			URL url = getClass().getClassLoader().getResource(iapConfig.getPathFile());
			String serviceAccount = iapConfig.getServiceAccount();
			Set<String> scopes = Collections.singleton(iapConfig.getScopes());
			
			GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(JSON_FACTORY)
					.setTransport(TRANSPORT)
					.setServiceAccountId(serviceAccount)
					.setServiceAccountScopes(scopes)
					.setServiceAccountPrivateKeyFromP12File(new File(url.getFile()))
					.build();
			AndroidPublisher publisher = new AndroidPublisher.Builder(TRANSPORT, JSON_FACTORY, credential)
					.setApplicationName(packageName)
					.build();
			
			AndroidPublisher.Purchases.Products.Get get = publisher.purchases().products().get(packageName, productId, purchaseToken);
			ProductPurchase iap = get.execute();
			
			System.out.println(response.toString());
			String iapStr = toJsonString(iap);
			
			response = new ObjectMapper().readValue(iapStr, GoogleVerifyResponse.class);
		} catch (Exception e) {
			System.out.println("[ERROR ] " +  e);
		} 
		
		return response;
	}
	
	public <T> String toJsonString(T obj) {
		ObjectMapper objectMapper = new ObjectMapper();//.writer().withDefaultPrettyPrinter();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			System.out.println("[ERROR ParseJSON] " +  e);
			return obj.toString();
		}
	}
}
