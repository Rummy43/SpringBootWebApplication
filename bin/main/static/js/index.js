var menu1Clicked = false;
function submitUser() {
	console.log("in submit form..")
	 $.ajax({
         type: "POST",
         url: $("#contextPath").val() + "/submitUser",
         data: $("#userForm").serialize(), // serializes the form's elements.
         success: function(data)
         {
        	 $("#userMessage").text(data)
         }
       });
}

function getUsers() {
	if (!menu1Clicked) {
		$.ajax({
			type : "GET",
			// contentType : "application/json",
			url : "/getUser",
			// data : JSON.stringify(json),
			// dataType : 'json',
			cache : false,
			timeout : 600000,
			success : function(data) {
				menu1Clicked = true;
				$("#userMenu").html(data);
			},
			error : function(e) {
				alert(e);
			}
		});
	}
}

$(document).ready(function() {
	/*
	 * $('#example').DataTable( { ajax:"data/data.txt", deferRender:true,
	 * scrollY:200, scrollCollapse:true, scroller:true } );
	 */

	$('#example').DataTable({
		"sAjaxSource" : $("#contextPath").val() + "/loadData",
		"sAjaxDataProp" : "",
		'dom': 'Rlfrtip',
		'colReorder': {
	        'allowReorder': false
	    },
		"aoColumns" : [ {
			"mData" : "id","visible":false
		}, {
			"mData" : "firstName"
		}, {
			"mData" : "lastName"
		}, {
			"mData" : "phone",
			/*"render": function ( data, type, row, meta ) {
			      return '<input type="text" path="phone" value="'+data+'"/>';
			    }*/
		}, {
			"mData" : "email"
		}, {
			"mData" : "address"
		} ],
		deferRender : true,
		scrollY : 200,
		scrollCollapse : true,
		scroller : true
	});
	
	$('#userTable').DataTable({
		"sAjaxSource" : $("#contextPath").val() + "/loadData",
		"sAjaxDataProp" : "",
		'dom': 'Rlfrtip',
		'colReorder': {
	        'allowReorder': false
	    },
		deferRender : true,
		scrollY : 200,
		scrollCollapse : true,
		scroller : true
	});

});


$(document).ready(function() {
	console.log($('#menu2'))
	$("#tab2").trigger("click");
	$("#testTable").colResizable({
	    fixed:false,
	    liveDrag:true,
	    gripInnerHtml:"<div class='grip2'></div>", 
	    draggingClass:"dragging" 
	});
});

function clicked2(){
	console.log("yes it is...")
}