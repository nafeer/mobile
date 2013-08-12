<?php

// include functions
include 'functions.php';

// Pull in the NuSOAP code
require_once('lib/nusoap.php');

// Create the server instance
$server = new soap_server();

// set encoding to UTF-8
$server->soap_defencoding = 'UTF-8';

// Initialize WSDL support
$server->configureWSDL('NafeerWebService', 'urn:NafeerWebService');

// Register the method to expose
$server->register('login',                									// method name
    array('email' => 'xsd:string','password' => 'xsd:string'),       		// input parameters
    array('status' => 'xsd:string'),      									// output parameters
    'urn:NafeerWebService',                     							// namespace
    'urn:NafeerWebService#login',               							// soapaction
    'rpc',                               									// style
    'encoded',                            									// use
    'Check if credentials are correct'          							// documentation
);

$server->register('loadStates',                								// method name
    array(),       								    						// input parameters
    array('states' => 'xsd:string'),      									// output parameters
    'urn:NafeerWebService',                     							// namespace
    'urn:NafeerWebService#loadStateName',               					// soapaction
    'rpc',                               									// style
    'encoded',                            									// use
    'Load state name by taking area name'          							// documentation
);


$server->register('loadAreas',                								// method name
    array('stateID' => 'xsd:string'),									    // input parameters
    array('areas' => 'xsd:string'),      									// output parameters
    'urn:NafeerWebService',                     							// namespace
    'urn:NafeerWebService#loadAreas',               						// soapaction
    'rpc',                               									// style
    'encoded',                            									// use
    'Load areas names'					          							// documentation
);

$server->register('saveNotification',                						// method name
    array(																	// input parameters
    'notification_date' => 'xsd:string',
    'notification_creator' => 'xsd:string',
    'notification_tell' => 'xsd:string',
    'notification_occupation' => 'xsd:string',
    'notification_area_id' => 'xsd:string',
    'notification_location_id' => 'xsd:string',
	'notification_pep_num' => 'xsd:string',
	'notification_wom_num' => 'xsd:string',
	'notification_chi_num' => 'xsd:string',
	'notification_oldnum' => 'xsd:string',
	'notification_death_num' => 'xsd:string',
	'notification_inj_num' => 'xsd:string',
	'notification_comp_dest_huose' => 'xsd:string',
	'notification_par_dest_house' => 'xsd:string',
	'notification_torr_house' => 'xsd:string',
	'notification_stock_house' => 'xsd:string',
	'notification_elec_problem' => 'xsd:string',
	'notification_damage_road' => 'xsd:string',
	'notification_emergency_case' => 'xsd:string',
	'notification_close_drainage' => 'xsd:string',
	'notification_other' => 'xsd:string'
	),       								    
    array('status' => 'xsd:string'),      									// output parameters
    'urn:NafeerWebService',                     							// namespace
    'urn:NafeerWebService#saveNotification',               					// soapaction
    'rpc',                               									// style
    'encoded',                            									// use
    'Save notification form'          										// documentation
);

// Use the request to (try to) invoke the service
$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';
$server->service($HTTP_RAW_POST_DATA);
?>
