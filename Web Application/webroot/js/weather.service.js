var WeatherService = {	
	// service URL
	serviceUrl : null,
	
	initService : function(ctx)	{
		this.serviceUrl = ctx + "/getreport.html";
	},
	
	findWeather : function(zipcode, oninit, oncomplete, onsuccess, onerror)	{
		
		var self = this;
		var params = "zip=" + zipcode;
		
		$.ajax(
	  	{
			url : self.serviceUrl,
			type : "GET",
			data : params,
			xhr: function() 
			{
				var myXhr = $.ajaxSettings.xhr();
				return myXhr;
			},
			beforeSend : function(jqXHR, settings)
			{
				oninit();
			},
			complete : function(xhr,status)
			{
				oncomplete();
			},
			success : function(result,status,xhr)
			{	
				if(result.status == undefined)
				{
					onerror("Error : Unable to parse the response.");
					return;
				}
				
				if(result.status == 'F')
				{
					onerror(result.message);
					return;
				}
				
				onsuccess({
					city : result.report.city,
					state : result.report.state,
					temperatureF : result.report.temperatureF
				});
			},
			error : function(xhr,status,error)
			{
				onerror ("Error : We are having network problem. Please try again later.");
			}
	  	});
	}
};