<?php
	if(isset($_POST["sub"])){
		$max = 5;
		$anzahl = 0;
		$nutzer = null;
		if(file_exists("nutzer.txt")){
			$nutzer = unserialize(file_get_contents("nutzer.txt"));
			$anzahl = count($nutzer);
		}
		if(($anzahl < $max) && ($_POST["kennwort"] == $_POST["test"])){
			if($anzahl == 0){$nutzer = array($_POST["nutzer"] => $_POST["kennwort"]);}
			else{array_push($nutzer, array($_POST["nutzer"] => $_POST["kennwort"]));}
			file_put_contents("nutzer.txt", serialize($nutzer));
		}else{
			echo "Anlegen des Nutzers nicht möglich!"."<br />";
		}
	}
?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Aufgabe3.1</title>
	</head>
	<body>
		<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
			<input type="text" name="nutzer" id="nutzer" /><br />
			<input type="password" name="kennwort" id="kennwort"/><br />
			<input type="password" name="test" id="test"/><br />
			<input type="submit" name="sub" id="sub" /> <br />
		</form>
	</body>
</html>