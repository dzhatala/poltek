hello
<?php
phpinfo();
echo "test";
//include_once 'nim.php';
echo "#1<br>";
$q="SELECT u.id AS userid, u.username AS studentid, gi.id AS itemid, c.shortname AS courseshortname, gi.itemname AS itemname, gi.grademax AS itemgrademax, gi.aggregationcoef AS itemaggregation, g.finalgrade AS finalgrade FROM mdl_user u JOIN mdl_grade_grades g ON g.userid = u.id JOIN mdl_grade_items gi ON g.itemid = gi.id JOIN mdl_course c ON c.id = gi.courseid " ;
$q.= "WHERE gi.courseid = 6 AND u.username = '".getNIM()."'";

$conn=mysql_open_conn("localhost","007","007");
if(!$conn) {
	echo "conn failed connect". mysql_error();
	die;
}
$result=mysql_query($q);
fi (!$result) {
	die ("invalid query " . mysql_error());
}

$numr = mysql_num_rows($result);
if($numr<=0) {
	die ("Nim : ");
}

mysql_free_result($result);

?>


