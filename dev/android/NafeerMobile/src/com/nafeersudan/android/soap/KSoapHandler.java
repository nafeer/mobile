/**
 * 
 */
package com.nafeersudan.android.soap;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

public class KSoapHandler {
	static String NAMESPACE = "urn:NafeerWebService";
	private String url;
	String TAG = "KSoapHandler";
	private final String ROW_SPLITTER = ",";
	private final String FIELD_SPLITTER = "-";

	public KSoapHandler(String url)
	{
		this.url = url;
	}


	public boolean login(String userName, String password)
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
		if(processRequest(methodName, credintials).equalsIgnoreCase("1"))
			return true;

		return false;
		
	}
//	public String loadStates()
//	{
//		String methodName = "loadStates";
//		String soapAction = "urn:NafeerWebService#loadStateName";
//		HashMap<String, String> args = new HashMap<String, String>();
//		String response = processRequest(methodName, null,soapAction );
//		String[] rows = response.split(ROW_SPLITTER)
//		return response;
//	}
	public HashMap<String, String> loadStates()
	{
		String methodName = "loadStates";
		HashMap<String, String> args = new HashMap<String, String>();
		String response = processRequest(methodName, args);
		HashMap<String, String> ret = new HashMap<String, String>();

		if(!response.equalsIgnoreCase("Error"))
		{
			String[] states = response.split(ROW_SPLITTER);
			for(int i = 0; i < states.length; i++)
			{
				ret.put(states[i].split(FIELD_SPLITTER)[1],
						states[i].split(FIELD_SPLITTER)[0]);

			}
			return ret;
		}	
		return null;
	}

	public ArrayList<String> loadAreas(String stateId)
	{
		String methodName = "loadAreas";
		HashMap<String, String> args = new HashMap<String, String>();
		args.put("stateID", stateId);
		String response = processRequest(methodName, args);
		ArrayList<String> ret = new ArrayList<String>();

		if(!response.equalsIgnoreCase("Error"))
		{
			String[] areas = response.split(ROW_SPLITTER);
			for(int i = 0; i < areas.length; i++)
			{
//				ret.put(areas[i].split(FIELD_SPLITTER)[0],
//						areas[i].split(FIELD_SPLITTER)[1]);
				ret.add(areas[i]);

			}
			return ret;
		}	


		return null;


		//return processRequest(methodName, args);
	}

	public boolean saveNotification(String date, String creator, String tell, String occupation,
			String areaId, String locationId, String pepNum, String womNum, String chiNum,
			String oldNum, String deathNum, String injNum, String compDestHuose, 
			String parDestHouse, String torrHouse, String stockHouse, String elecProblem,
			String damageRoad, String emergencyCase, String closeDrainage, String other )
	{
		String methodName = "saveNotification";
		HashMap<String, String> args = new HashMap<String, String>();
		args.put("notification_date",date);
		args.put("notification_creator",creator);
		args.put("notification_tell",tell);
		args.put("notification_occupation",occupation);
		args.put("notification_area_id",areaId);
		args.put("notification_location_id",locationId);
		args.put("notification_pep_num",pepNum);
		args.put("notification_wom_num",womNum);
		args.put("notification_chi_num",chiNum);
		args.put("notification_oldnum",oldNum);
		args.put("notification_death_num",deathNum);
		args.put("notification_inj_num",injNum);
		args.put("notification_comp_dest_huose",compDestHuose);
		args.put("notification_par_dest_house",parDestHouse);
		args.put("notification_torr_house",torrHouse);
		args.put("notification_stock_house",stockHouse);
		args.put("notification_elec_problem",elecProblem);
		args.put("notification_damage_road",damageRoad);
		args.put("notification_emergency_case",emergencyCase);
		args.put("notification_close_drainage",closeDrainage);
		args.put("notification_other",other);

		String response =  processRequest(methodName, args);
		if(response.equalsIgnoreCase("1"))
			return true;
		return false;

	}

	//	public String loadAreas()
	//	{
	//	    String methodName = "Areas";
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
	public String processRequest(String methodName, HashMap<String, String> properties, String soapAction)
	{
		//String soapAction = NAMESPACE + "#" + ;
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
		Log.e("tst", "Starting this thing");
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
			Log.e("ksoapprob",e.toString());
			//Log.d(TAG, androidHttpTransport.responseDump);
			//e.printStackTrace();
		}		
		return stringResponse;
	}
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
		Log.e("tst", "Starting this thing");
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
			Log.e("ksoapprob",e.getMessage());
			//Log.d(TAG, androidHttpTransport.responseDump);
			//e.printStackTrace();
		}		
		return stringResponse;
	}
}


