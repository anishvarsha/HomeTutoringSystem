$('#btn_register').click(function() {
	$.ajax({
		url : "ParentSignup",
		success : function(data) {
			
			$('#username').val(data.firstName);
		}
	});
});

