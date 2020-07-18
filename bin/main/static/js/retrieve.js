$( function() {
    $( "#tabs" ).tabs();
  } );

function getData(){
	dataNew();
	var search = {
		      "fromDate" : "12/12/2019",
		      "toDate" :"12/12/2019",
		    	  "fromTime":"00:00:00",
		    	  "toTime" : "00:00:00"
		   }

		   $.ajax({
		       type: "POST",
		       contentType : 'application/json; charset=utf-8',
		       async:false,
		       dataType : 'json',
		       url: "/retrieveDataNew",
		       data: JSON.stringify(search), // Note it is important
		       success :function(result) {
		       // do what ever you want with data
		    	   console.log(result);
		    	   var span=null;
		    	   for(var i=0;i<result.length;i++){
		    		   var color;
		    		   if(result[i].selected){
		    			   color = "yellow";
		    		   }else{
		    			   color="";
		    		   }
		    		   if(span==null){
		    			   span='<span style="background-color:'+color+'" title="'+result[i].tooltip+'" onclick=alert("'+result[i].data+'");>'+result[i].data+'</span><br/>'
		    		   }else{
		    			   span+='<span style="background-color:'+color+'" title="'+result[i].tooltip+'">'+result[i].data+'</span><br/>'
		    		   }
		    	   }
		    	   $("#dataDiv").html(span);
		       }
		   });
}

function update(){
	$.ajax({
        type: "GET",
        url: "/update",
        success: function(data)
        {
       	getData();
        }
      });
}

function dataNew(){
	$.ajax({
	       type: "GET",
	       async:false,
	       contentType : 'application/json; charset=utf-8',
	       //dataType : 'json',
	       url: "/dataNew",
	       data: {"str":"Ramesh","str2":"Rummy"}, // Note it is important
	       success :function(result) {
	    	   console.log("Test...")
	    	   data= result;
	    	   console.log(data)
	    	   console.log(result);
	       }
	   });
}

function loadJsp(){
	$.ajax({
		type : "GET",
		// contentType : "application/json",
		url : "/getJsp",
		// data : JSON.stringify(json),
		// dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			$("#jspDiv").html(data);
		},
		error : function(e) {
			alert(e);
		}
	});
}

