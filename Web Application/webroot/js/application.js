var Application = {
	initApplication : function() {
		var self = this;
		
		$('#zipcode').on("keypress", function(e){
			if(e.which == 13)
				self.findWeather();
		});
		
		$('#find').on("click", function(e){
			self.findWeather();
		});
	},
	
	findWeather : function() {
		// get zipcode first
		var zipcode = $('#zipcode').val();
		// now call API
		WeatherService.findWeather(zipcode, 
			// before sending
			function(){
				$('.box').hide();
				$('#msgbox').show();
				$('#msg').removeClass();
				$('#msg').addClass('info').text('Loading weather information for zip code [\'' + zipcode + '\']...');
			}, 
			// on complete
			function(){
				
			},
			// on success
			function(report){
				$('.box').hide();
				$('#msgbox').hide();
				$('#msg').removeClass();
				
				$('#result').show();
				$('#city').text(report.city);
				$('#state').text(report.state);
				$('#temperature').text(report.temperatureF);
			},
			// on error
			function(errmsg){
				$('.box').hide();
				$('#msgbox').show();
				$('#msg').removeClass();
				$('#msg').addClass('error').text(errmsg);
			});
	}
};