<!DOCTYPE HTML>
<html>
<head>
	<title>weatherexpedia</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
	<div class="container_12">
		<div class="grid_12 tgap bgap">
			<h1 class="heading">weatherexpedia</h1>			
		</div>
		<div class="grid_12 bgap">
			<p class="note">Enter US zip code to find its weather condition</p>
			<input type="text" id="zipcode" placeholder="enter US zip code here..."/>
			<input type="button" id="find" value="Find" class="button"/>
		</div>
		<div id="msgbox" class="box grid_12 tgap bgap">
			<span id="msg"></span>
		</div>
		<div id="result" class="box grid_12 tgap bgap">
			<b>City :</b> <span id="city"></span><br/>
			<b>State :</b> <span id="state"></span><br/>
			<b>Temperature (F) :</b> <span id="temperature"></span><br/>
		</div>
		<div id="footer" class="grid_12 tgap bgap">
			<p class="note fright">Developed by Aung Thaw Aye (ata.aungthawaye@gmail.com)</p>
		</div>
	</div>	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/weather.service.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/application.js"></script>
	<script>
		$(document).ready(function(){
			WeatherService.initService('<%= request.getContextPath() %>');
			Application.initApplication();
		});
	</script>
</body>
</html>