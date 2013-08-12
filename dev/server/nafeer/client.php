<?php
/*************************************
 *    		Login function - WS
 ************************************/
function login($email,$password)
{
	$con = mysql_connect("nafeer.fatcowmysql.com","wstest","wtest");
	mysql_set_charset("utf8");
	
	if (!$con)
	{
		echo "Error: " . mysql_error();
	}
	else
	{
		if(mysql_num_rows(mysql_query("select * from `nafeer`.`admin` where admin_email like '".$email."' and admin_password like '".$password."'"))=="1")
		{
			mysql_close($con);
			return "1";
		}
		else
		{
			mysql_close($con);
			return "0";
		}
	}	
}
/*************************************
 *		Load states function - WS
 ************************************/
function loadStates()
{
	$con = mysql_connect("nafeer.fatcowmysql.com","wstest","wtest");
	mysql_set_charset("utf8");
	$states="";
	
	if (!$con)
	{
		echo "Error: " . mysql_error();
	}
	else
	{
		$result = mysql_query("SELECT `state_name`,`state_id` FROM `nafeer`.`state`;");

		while($row = mysql_fetch_array($result))
		{
			$states = $states . $row["state_name"] . "-" . $row["state_id"] . ",";
		}

	mysql_close($con);
	$states = rtrim($states, ",");
	return $states;
	}
}

/*************************************
 *		Load areas function - WS
 ************************************/
function loadAreas($stateID)
{
	$con = mysql_connect("nafeer.fatcowmysql.com","wstest","wtest");
	mysql_set_charset("utf8");
	$areas="";
	
	if (!$con)
	{
		echo "Error: " . mysql_error();
	}
	else
	{
		$result = mysql_query("SELECT `area_name` FROM `nafeer`.`area` WHERE `area_state_id`=$stateID");

		while($row = mysql_fetch_array($result))
		{
			$areas = $areas . $row["area_name"] . ",";
		}

	mysql_close($con);
	$areas = rtrim($areas, ",");
	#return $areas;
	echo $areas;
	}
}

/***************************************************
 *		save notification function - WS
 **************************************************/
function saveNotification($notification_date,$notification_creator,$notification_tell,$notification_occupation,$notification_area_id,$notification_location_id,
						$notification_pep_num,$notification_wom_num,$notification_chi_num,$notification_oldnum,$notification_death_num,$notification_inj_num,
						$notification_comp_dest_huose,$notification_par_dest_house,$notification_torr_house,$notification_stock_house,$lunotification_elec_problem,
						$notification_damage_road,$notification_emergency_case,$notification_close_drainage,$notification_other)
{
	$con = mysql_connect("nafeer.fatcowmysql.com","wstest","wtest");
	mysql_set_charset("utf8");
	
	if (!$con)
	{
		echo "Error: " . mysql_error();
	}
	else
	{
		
		mysql_query("insert into `nafeer`.`notification`
					(
					notification_date,notification_creator,notification_tell,notification_occupation,notification_area_id,notification_location_id,
					notification_pep_num,notification_wom_num,notification_chi_num,notification_oldnum,notification_death_num,notification_inj_num,notification_comp_dest_huose,
					notification_par_dest_house,notification_torr_house,notification_stock_house,notification_elec_problem,notification_damage_road,notification_emergency_case,
					notification_close_drainage,notification_other
					)
					values 
					(
					$notification_date,$notification_creator,$notification_tell,$notification_occupation,$notification_area_id,$notification_location_id,
					$notification_pep_num,$notification_wom_num,$notification_chi_num,$notification_oldnum,$notification_death_num,$notification_inj_num,
					$notification_comp_dest_huose,$notification_par_dest_house,$notification_torr_house,$notification_stock_house,$lunotification_elec_problem,
					$notification_damage_road,$notification_emergency_case,$notification_close_drainage,$notification_other
					);
					");
	mysql_close($con);
	return "1";
	}
}
?>
