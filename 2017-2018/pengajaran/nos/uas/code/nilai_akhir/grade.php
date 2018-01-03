
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Nilai</title>



<style type="text/css">
#clock { font-family: Arial, Helvetica, sans-serif; font-size: 1.2em; 
	color: white; background-color: black; 
	border: 2px solid purple; padding: 10px;
	
}
</style>
<script src="./jquery.js"></script>
<script type="text/javascript">
//<!--

var job1=0; var job2=0;var job3=0;
var job4=0; var uts=0;var uas=0;
var job1_or=1; var job2_or=2;var job3_or=3;
var job4_or=4; var uts_or=5;var uas=0;
var csname="UNKNOWN_BY_JS";
var OR_SET=false;
//php loading here, get values from servers

//backup values here
//var job1_ori=job1;

function setOR_JOB1(nj){
   
}

function init ( )
{
  timeDisplay = document.createTextNode ( "" );
  document.getElementById("clock").appendChild ( timeDisplay );
}

function getServerDate(){
		return "Jum Des 29 08:50:18"
}

/*function getNim(){
	return "007";
}*/

function setJOB1(val ){
	job1=val;
	$("#job1").val(val);
}

function setJOB2(val ){
	job2=val;
	$("#job2").val(val);
}
function setJOB3(val ){
	job3=val;
	$("#job3").val(val);
}
function setJOB4(val ){
	job4=val;
	$("#job4").val(val);
}
function setUTS(val ){
	uts=val;
	$("#uts").val(val);
}
function setUAS(val ){
	uas=val;
	$("#uas").val(val);
}


var  php_date = <?php echo time();  ?> ;
function updateClock ( )
{
  
  var currentTime = new Date ( );
  php_date++;  //increment a seconds
  currentTime = new Date(php_date*1000);
  var currentHours = currentTime.getHours ( );
  var currentMinutes = currentTime.getMinutes ( );
  var currentSeconds = currentTime.getSeconds ( );
	
  var currDay = currentTime.getDate();
  var currMonth = currentTime.getMonth()+1;
  var currYear  =currentTime.getFullYear();
  // Pad the minutes and seconds with leading zeros, if required
  currentMinutes = ( currentMinutes < 10 ? "0" : "" ) + currentMinutes;
  currentSeconds = ( currentSeconds < 10 ? "0" : "" ) + currentSeconds;

  // Choose either "AM" or "PM" as appropriate
  var timeOfDay = ( currentHours < 12 ) ? "AM" : "PM";

  // Convert the hours component to 12-hour format if needed
  currentHours = ( currentHours > 12 ) ? currentHours - 12 : currentHours;

  // Convert an hours component of "0" to "12"
  currentHours = ( currentHours == 0 ) ? 12 : currentHours;

  // Compose the string for display
  var currentTimeString = currDay+"/"+currMonth+"/"+currYear+"  "+currentHours + ":" + currentMinutes + ":" + currentSeconds + " " + timeOfDay;

  // Update the time display
  //document.getElementById("clock").firstChild.nodeValue = currentTimeString;
  $("#clock").html(currentTimeString);
  //$("#job1").val(currentTimeString);
}


function renderAngka(){
	var s_angka=0.1*(job1+job2+job3+job4)+0.25*uts+0.35*uas;
	var s_angka_pure=s_angka;
	if(OR_SET){
	if(job1!=job1_or) {
		s_angka+="<br> -- complain job1, "+job1_or +" => " + job1;
	}
	if(job2!=job2_or) {
                s_angka+="<br> -- complain job2, "+job2_or +" => " + job2;
        }
        if(job3!=job3_or) {
                s_angka+="<br> -- complain job3, "+job3_or +" => " + job3;
        }
        if(uts!=uts_or) {
                s_angka+="<br> -- complain uts, "+uts_or +" => " + uts;
        }
        if(job4!=job4_or) {
                s_angka+="<br> -- complain job4, "+job4_or +" => " + job4;
        }
        
	}//if OR_SET


	$("#angka").html(s_angka+"");
	var huruf = "E";
	
	if(s_angka_pure>=20) huruf ="D";
	if(s_angka_pure>=40) huruf ="C";
	if(s_angka_pure>=60) huruf ="B";
	if(s_angka_pure>=80) huruf ="A";
	
	var r_01="";
	var r_color="red";
	if(s_angka_pure>40) r_color="green";
	if(s_angka_pure>60) r_color="blue";
	r_01 +="<font color =\""+r_color+"\">";
	r_01 +=huruf+"  ("+s_angka_pure+")";	
	r_01 +="</font>";
	$("#huruf").html(r_01);
	if(OR_SET)
	$("#csname").html(csname);
	
	
}

function renderValues(){
	setJOB1(job1);
	setJOB2(job2);
	setJOB3(job3);
	setJOB4(job4);
	setUTS(uts);
	setUAS(uas);
	renderAngka();
}
<?php include_once  "nim.php" ;
//echo getNIM();
?>
function renderNIM(){
 var php_nim="<?php echo getNIM();?>";
 $("#nim").html(php_nim);
 
}




// -->
</script>

</head>
<body onload="updateClock(); setInterval('updateClock()', 1000 ) ;renderNIM();renderValues() ">
<?php include_once "my.php"  ;?>
<div style="clear: both;"> </div>


<!-- span inside div ... always centers span ?? -->
<!--<div style="width: 20em; text-align: left; margin: 20px auto;">-->
  
	<span style="text-align: left;" id="clock" >&nbsp;</span>
<!--</div> -->
<br>
<h3>Nilai <span id="csname" style="float:left"> UNKNOWN_BY_SPAN </span> </h3>
(  NIM : <span id="nim"> </span>)<br><br> 
JOB1 : <input id="job1" name="job1" type="text" size="5"></input>
JOB2 : <input id="job2" name="job2" type="text" size="5"></input>
JOB3 : <input id="job3" name="job3" type="text" size="5"></input><br>
UTS : <input id="uts" name="uts" type="text" size="5"></input>
JOB4 : <input id="job4" name="job4" type="text" size="5"></input>
UAS : <input id="uas" name="uas" type="text" size="5"></input><br>
<br>
Nilai angka <br> 10%x(JOB1+JOB2+JOB3+JOB4)+25%xUTS+35%xUAS = <span id="angka"> </span><br><br>
<h2>
Nilai Huruf :  <span id="huruf"> </span>
</h2>

<span id="keterangan"> </span>



<script type="text/javascript">
function checkValues(){
	var num_val=parseInt($("#job1").val());
	if(num_val<0|num_val>100) {
		alert ("Nilai job1 antara 0 - 100");
		$("#job1").focus();
		return false;
	} 
	else {
		setJOB1(num_val);
		//renderValues();
	}
	
	num_val=parseInt($("#job2").val());
	if(num_val<0|num_val>100) {
		alert ("Nilai job2 antara 0 - 100");
		$("#job2").focus();
		return false;
	}
	else {
		setJOB2(num_val);
		//renderValues();
	}
	
	num_val=parseInt($("#job3").val());
	if(num_val<0|num_val>100) {
		alert ("Nilai job3 antara 0 - 100");
		$("#job3").focus();
		return false;
	}
		else {
		setJOB3(num_val);
		//renderValues();
	}

	num_val=parseInt($("#job4").val());
	if(num_val<0|num_val>100) {
		alert ("Nilai job4 antara 0 - 100");
		$("#job4").focus();
		return false;
	}
		else {
		setJOB4(num_val);
		//renderValues();
	}

	num_val=parseInt($("#uts").val());
	if(num_val<0|num_val>100) {
		alert ("Nilai UTS antara 0 - 100");
		$("#uts").focus();
		return false;
	}
		else {
		setUTS(num_val);
		//renderValues();
	}

	num_val=parseInt($("#uas").val());
	if(num_val<0|num_val>100) {
		alert ("Nilai UAS antara 0 - 100");
		$("#uas").focus();
		return false;
	}
		else {
		setUAS(num_val);
		//renderValues();
	}
	return true;
}

 $("#job1").change(function(){
	if(checkValues())renderValues();
	
 });

 $("#job2").change(function(){
	if(checkValues())renderValues();
	
 });
 
 $("#job3").change(function(){
	
 		if(checkValues())renderValues();
	
 });

  $("#job4").change(function(){
	
	if(checkValues())renderValues();
	
 });


   $("#uts").change(function(){
	
	if(checkValues())renderValues();
	
 });

  $("#uas").change(function(){
	
	if(checkValues())renderValues();
	
 });
	//change grades using js
	//job1=1; job2=2;job3=3; job4=4; uts=5 ; uas=6;
 	
		//@todo change once  grades based on mysql php here ..
		job1=<?php echo getJOB1(); ?>; 
		job2=<?php echo getJOB2(); ?>;
		job3=<?php echo getJOB3(); ?> ;
		job4=<?php echo getJOB4(); ?> ;
		uts =<?php echo getUTS(); ?> ;
		uas = <?php echo getUAS(); ?> ;
		job1_or=job1; 
		job2_or=job2;
		job3_or=job3,
		job4_or=job4; 
		uts_or=uts;
		csname =<?php echo "\"".getCourseName()."\""; ?> ; 
		OR_SET=true;


</script>

</body>
</html>
