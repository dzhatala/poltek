<?php
include_once "nim.php";
//echo "#1<br>";
//phpinfo();


$q="SELECT u.id AS userid, u.username AS studentid, gi.id AS itemid, ".
"c.shortname AS courseshortname, gi.itemname AS itemname, ".
"gi.grademax AS itemgrademax, ".
"gi.aggregationcoef AS itemaggregation, g.finalgrade AS         finalgrade ".
"FROM mdl_user u ".
"JOIN  mdl_grade_grades g ON g.userid = u.id JOIN mdl_grade_items gi ".
"ON g.itemid = gi.id ".
"JOIN mdl_course c ON c.id = gi.courseid WHERE gi.courseid = 6 AND ".
"u.username = '".getNIM()."'"  ;

//echo $q."<BR>";

$conn=mysql_connect("localhost","007","007");
//echo "#2".$conn."<BR>";
if(!$conn) {
        echo "conn failed connect". mysql_error();
        die;
}

$result=mysql_db_query("db_007",$q);
//echo "#3".$result."<BR>";
if (!$result) {
        echo ("invalid query " . mysql_error());
	die;
}

$numr = mysql_num_rows($result);
//echo "#4=".$numr."rows <BR>" ;
if($numr<=0){
	echo "ERROR: NIM  '".getNIM()."'    tidak terdaftar<br>" ;
	echo "rubah file 'nim.php' dengan nim yang benar contohnya 1315147777" ;
	die ;
}

//@todo fix never attend person, that have no value ...
// or in moodle set all grades to zero

//mysql_free_result($result);
	$GLOBALS['job1']=0;
	$GLOBALS['job2']=0;
	$GLOBALS['job3']=0;
	$GLOBALS['job4']=0;
	$GLOBALS['uts']=0;
        $GLOBALS['csname']="UNKNOWN_BY_PHP";
	
	//$job1_my=0;$job2_my=0;$job3_my=0;
	while ($row=mysql_fetch_assoc($result)){
		//echo $row['itemname']."  ===>  ".$row['finalgrade']."<br>"; 
                if(strpos($row['itemname'],"_JOB_1")!==FALSE){
                        $GLOBALS['job1']=$row['finalgrade']*10;
                }

                if(strpos($row['itemname'],"_JOB_2")!==FALSE){
                        $GLOBALS['job2']=$row['finalgrade']*10;
                }

		if(strpos($row['itemname'],"_JOB_3")!==FALSE){
			$GLOBALS['job3']=$row['finalgrade']*10;
		}
                if(strpos($row['itemname'],"_JOB_4")!==FALSE){
                        $GLOBALS['job4']=$row['finalgrade']*10;
                }

                if(strpos($row['itemname'],"UTS")!==FALSE){
                        $GLOBALS['uts']=$row['finalgrade']*100/25;
                }
                if($row)  
                        $GLOBALS['csname']=$row['courseshortname'];

	}
	$job1_my=1;
function getJOB1(){
	$job1=0;
        if($GLOBALS['job1']>0) $job1=$GLOBALS['job1'];
	return $job1;
}

function getJOB2(){
        $job2=0;
        if($GLOBALS['job2']>0) $job2=$GLOBALS['job2'];
 
        return $job2;
}
function getJOB3(){
        $job3=0;
        if($GLOBALS['job3']>0) $job3=$GLOBALS['job3'];
 
        return $job3;
}
function getJOB4(){
        $job4=0;
        if($GLOBALS['job4']>0) $job1=$GLOBALS['job4'];
 
        return $job4;
}
function getUTS(){
        $uts=0;
        if($GLOBALS['uts']>0) $uts=$GLOBALS['uts'];
 
        return $uts;
}
function getUAS(){
        $uas=0;

        return $uas;
}

function getCourseName(){

        return $GLOBALS['csname'];
}


mysql_free_result($result);
//echo "#100  completed";


?>
