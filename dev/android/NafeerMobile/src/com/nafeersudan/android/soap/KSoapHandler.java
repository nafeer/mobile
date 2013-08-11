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
	static String URL = "http://192.168.43.149/nafeer/index.php";
	String TAG = "KSoapHandler";


	
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
//	public KSoapHandler(String ClientPWD, String ClientID) {
//		this.OPID = ClientID;
//		this.OPPWD = ClientPWD;
//		this.ClientID = ClientID;
//		this.ClientPWD = ClientPWD;
//
//		credentials = Crypto.Encrypt(OPPWD + ";" + OPID + ";" + ClientPWD + ";"
//				+ ClientID);
//	}
//
//	public String getInfo(String MeterNo ,String Amount) {
//		///////////////////////////////////////////////////////
//	    String SOAP_ACTION = "http://tempuri.org/getInfo";
//	    String METHOD_NAME = "getInfo";
//	    //////////////////////////////////////////////////////
//	    String getResponse = "";
//		SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
//		PropertyInfo pi = new PropertyInfo();
//		pi.setName("credentials");
//		pi.setValue(credentials);
//		pi.setType(String.class);
//		Request.addProperty(pi);
//		PropertyInfo pi2 = new PropertyInfo();
//		getInfoRequest =Crypto.Encrypt( MeterNo + ";" + Amount );
//		pi2.setName("getInfoRequest");
//		pi2.setValue(getInfoRequest);
//		pi2.setType(String.class);
//		Request.addProperty(pi2);
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//				SoapEnvelope.VER11);
//		envelope.dotNet = true;
//		envelope.setOutputSoapObject(Request);
//		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//		try {
//			androidHttpTransport.call(SOAP_ACTION, envelope);
//			SoapObject response = (SoapObject) envelope.bodyIn;
//			getResponse = response.getProperty(0).toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (getResponse == "")
//        	return "Error : Missing data or no connection .. ";
//		String[] Info = Crypto.Decrypt(getResponse).split(";");
//		if (Info[4].equals("1"))
//			return "Customer Name : " + Info[1] + "\n" + "Amount  : " + Info[0] + " SDG\n" + "Installment/Arries : "+Info[6]+" SDG\n"+
//			"Units       : " + Info[8] + " KWh\n"+"Meter NO: " + Info [2] ;
//			
//			else 
//				return "Error : " + Info[5];
//			}
//
////------------------------------------ creditVend ------------------
//	public String creditVend(String MeterNo,String Amount) {
//		/////////////////////////////////////////////////////////
//		String SOAP_ACTION = "http://tempuri.org/creditVend";
//	    String METHOD_NAME = "creditVend";
//	    /////////////////////////////////////////////////////////
//	    String getResponse = "";
//	    SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
//		PropertyInfo pi = new PropertyInfo();
//		pi.setName("credentials");
//		pi.setValue(credentials);
//		pi.setType(String.class);
//		Request.addProperty(pi);
//		PropertyInfo pi2 = new PropertyInfo();
//		creditVendReq =Crypto.Encrypt(MeterNo + ";" + Amount);
//		pi2.setName("creditVendReq");
//		pi2.setValue(creditVendReq);
//		pi2.setType(String.class);
//		Request.addProperty(pi2);
//
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//				SoapEnvelope.VER11);
//
//		envelope.dotNet = true;
//		envelope.setOutputSoapObject(Request);
//		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//		try {
//			
//			androidHttpTransport.call(SOAP_ACTION, envelope);
//			SoapObject response = (SoapObject) envelope.bodyIn;
//			getResponse = response.getProperty(0).toString();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//
//		return Crypto.Decrypt(getResponse);
//        
//	}
//
//	public String confirm(String MeterNo) {
//		// ///////////////////////////////////////////////////////
//		String SOAP_ACTION = "http://tempuri.org/confirm";
//		String METHOD_NAME = "confirm";
//		// ///////////////////////////////////////////////////////
//		String getResponse = "";
//		SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
//		PropertyInfo pi = new PropertyInfo();
//		pi.setName("credentials");
//		pi.setValue(credentials);
//		pi.setType(String.class);
//		Request.addProperty(pi);
//		PropertyInfo pi2 = new PropertyInfo();
//		rittalReq = Crypto.Encrypt(MeterNo);
//		pi2.setName("rittalReq");
//		pi2.setValue(rittalReq);
//		pi2.setType(String.class);
//		Request.addProperty(pi2);
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//				SoapEnvelope.VER11);
//		envelope.dotNet = true;
//		envelope.setOutputSoapObject(Request);
//		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//		try {
//			androidHttpTransport.call(SOAP_ACTION, envelope);
//			SoapObject response = (SoapObject) envelope.bodyIn;
//			getResponse = response.getProperty(0).toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return getResponse;
//	}
//
//	public int IsLive() {
//		// ///////////////////////////////////////////////////////
//		String SOAP_ACTION = "http://tempuri.org/IsLive";
//		String METHOD_NAME = "IsLive";
//		// ///////////////////////////////////////////////////////
//		int getResponse = 0;
//		SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//				SoapEnvelope.VER11);
//		envelope.dotNet = true;
//		envelope.setOutputSoapObject(Request);
//		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//		try {
//			androidHttpTransport.call(SOAP_ACTION, envelope);
//			SoapObject response = (SoapObject) envelope.bodyIn;
//			getResponse = Integer.parseInt(response.getProperty(0).toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return getResponse;
//	}
//
//	public String GetCustBalance() {
//		// ///////////////////////////////////////////////////////
//		String SOAP_ACTION = "http://tempuri.org/GetCustBalance";
//		String METHOD_NAME = "GetCustBalance";
//		// ///////////////////////////////////////////////////////
//		String getResponse = "";
//		SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
//		PropertyInfo pi = new PropertyInfo();
//		pi.setName("credentials");
//		pi.setValue(credentials);
//		pi.setType(String.class);
//		Request.addProperty(pi);
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//				SoapEnvelope.VER11);
//		envelope.dotNet = true;
//		envelope.setOutputSoapObject(Request);
//		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//		try {
//			androidHttpTransport.call(SOAP_ACTION, envelope);
//			SoapObject response = (SoapObject) envelope.bodyIn;
//			getResponse = response.getProperty(0).toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return getResponse;
//	}
//
//	public String getReportByDate(int y, int m, int d) {
//		// ///////////////////////////////////////////////////////
//		String SOAP_ACTION = "http://tempuri.org/GetReportByDate";
//		String METHOD_NAME = "GetReportByDate";
//		// ///////////////////////////////////////////////////////
//		String getResponse = "Software074";
//		String date = String.valueOf(y) + ";" + String.valueOf(m) + ";"
//				+ String.valueOf(d);
//		SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
//		PropertyInfo pi = new PropertyInfo();
//		pi.setName("credentials");
//		pi.setValue(credentials);
//		pi.setType(String.class);
//		Request.addProperty(pi);
//		PropertyInfo pi2 = new PropertyInfo();
//		pi2.setName("Trans_Date_s");
//		pi2.setValue(date);
//		pi2.setType(String.class);
//		Request.addProperty(pi2);
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//				SoapEnvelope.VER11);
//		envelope.dotNet = true;
//		envelope.setOutputSoapObject(Request);
//		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//		try {
//			androidHttpTransport.call(SOAP_ACTION, envelope);
//			SoapObject response = (SoapObject) envelope.bodyIn;
//			getResponse = response.getProperty(0).toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//			return getResponse;
//			}
//
//	public String getRe0port(String getResponse, int i) {
//
//		String[] row = getResponse.split("_");
//		String[] coloumn = row[i].split(";");
//
//		return "Meter No: " + coloumn[1] + "\n" + "Time      : "
//				+ coloumn[12].substring(0, 7) + "\n" + "Amount  : "
//				+ coloumn[2] + "  SDG\n" + "Purchase Amount : " + coloumn[3]
//				+ "  SDG\n" + "Units   : " + coloumn[5].substring(0, 10)
//				+ " KWh\n" + "Arries  : " + coloumn[4] + " SDG\n" + "Token :  \t" +
//	    		coloumn [6].substring(0,4)+"  "+ coloumn [6].substring(4,8)+"  "+coloumn [6].substring(8,12)+"\n\t\t\t\t\t "+coloumn [6].substring(12,16)+
//	    		"  "+coloumn [6].substring(16,20);
//	}
//
//	public String getReportMeterDate(String getResponse, String MeterNo) {
//
//		String[] row = getResponse.split("_");
//		String rsp = "Software074";
//        for (int i = 1; i < row.length ; i++)
//        {
//        	String[] column = row[i].split(";");
//           	if (column[1].equals(MeterNo))
//			rsp += "_" + row[i];
//        }
//		
//			return rsp;
//	}
//
//	public String getPayments(String getResponse) {
//		
//		String[] row = getResponse.split("_");
//		float sum = 0;
//		for (int i = 1; i < row.length; i++) {
//			String[] coloumn = row[i].split(";");
//			sum += Float.parseFloat(coloumn[3]);
//		}
//		
//		return "Total Payments without Commission : " + String.valueOf((float) (Math.round(sum * 100))/100)
//				+ " SDG\n\n" + "Total Payments with Commission : "
//				+ String.valueOf ((float)(Math.round((((row.length-1)*0.25)+sum)*100))/100) + "  SDG\n";
//		
//
//	}
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
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
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


