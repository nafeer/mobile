/**
 * 
 */
package com.nafeersudan.android.soap;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.http.util.EntityUtils;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;
import android.widget.Toast;

/**
 * @author Nadir
 *
 */
public class KSoapHandler {
	static String NAMESPACE = "urn:NafeerWebService";
	private String url;
	String TAG = "KSoapHandler";

	public KSoapHandler(String url)
	{
		this.url = url;
	}

	
	public String login(String userName, String password)
	{
	    String methodName = "login";
//		String soapAction = NAMESPACE + "#" + methodName;
//	    //////////////////////////////////////////////////////
//
//		SoapObject request = new SoapObject(NAMESPACE, methodName);
//		PropertyInfo userNamePi = new PropertyInfo();
//		userNamePi.setName("email");
//		userNamePi.setValue(userName);
//		userNamePi.setType(String.class);
//		PropertyInfo passwordPi = new PropertyInfo();
//		passwordPi.setValue(password);
//		passwordPi.setName("password");
//		passwordPi.setType(String.class);
//		request.addProperty(userNamePi);
//		request.addProperty(passwordPi);
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//				SoapEnvelope.VER11);
//		String stringResponse = "Error";
//		envelope.setOutputSoapObject(request);
//		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//		//androidHttpTransport.debug = true;
//		try {
//			androidHttpTransport.call(soapAction, envelope);
//			SoapObject response = (SoapObject) envelope.bodyIn;
//			stringResponse = response.getProperty(0).toString();			
//		} catch (Exception e) {
//			Log.e(TAG, e.getMessage());
//			//Log.d(TAG, androidHttpTransport.responseDump);
//			//e.printStackTrace();
//		}
//		
//		
//		return stringResponse;
//	}
//
		HashMap<String, String> credintials = new HashMap<String, String>();
		credintials.put("password", password);
		credintials.put("email", userName);
		return processRequest(methodName, credintials);
	}
//	public String loadAreas()
//	{
//	    String methodName = "loadAreas";
//		String soapAction = NAMESPACE + "#" + methodName;
//	    //////////////////////////////////////////////////////
//
//		SoapObject request = new SoapObject(NAMESPACE, methodName);
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//				SoapEnvelope.VER11);
//		String stringResponse="Error";
//		envelope.setOutputSoapObject(request);
//		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//		//androidHttpTransport.debug = true;
//		try {
//			androidHttpTransport.call(soapAction, envelope);
//			SoapObject response = (SoapObject) envelope.bodyIn;
//			stringResponse = response.getProperty(0).toString();			
//		} catch (Exception e) {
//			Log.e(TAG, e.getMessage());
//			//Log.d(TAG, androidHttpTransport.responseDump);
//			//e.printStackTrace();
//		}
//	}
	//////////////////////////////////////////////////////////////////////////////////////

	public String processRequest(String methodName, HashMap<String, String> properties)
	{
		String soapAction = NAMESPACE + "#" + methodName;
	    //////////////////////////////////////////////////////

		SoapObject request = new SoapObject(NAMESPACE, methodName);
		if (properties != null)
		{
			PropertyInfo pi;
			Iterator it = properties.entrySet().iterator();
			while (it.hasNext()) {
				pi = new PropertyInfo();
				HashMap.Entry<String,String> pair = (HashMap.Entry<String,String>)it.next();
				pi.setName(pair.getKey());
				pi.setValue(pair.getValue());
				request.addProperty(pi);
			}
		}
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		String stringResponse = "Error";
		Log.d(TAG, request.toString());
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(url);
		//androidHttpTransport.debug = true;
		try {
			androidHttpTransport.call(soapAction, envelope);
			SoapObject response = (SoapObject) envelope.bodyIn;
			stringResponse = response.getProperty(0).toString();			
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			//Log.d(TAG, androidHttpTransport.responseDump);
			//e.printStackTrace();
		}		
		return stringResponse;
	}
}


