function addUser(){
	alert("in add User...")
	$.ajax({
        type: "POST",
        url: "/addUser",
        data: $("#addUserForm").serialize(), // serializes the form's elements.
        success: function(data)
        {
       	 $("#addUserMessage").text(data)
        }
      });
}