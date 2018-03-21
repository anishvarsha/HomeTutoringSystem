/**
 * Validation for parent_login and parent_signup
 */

$(document).ready(function() {
	$("#username").focus(function(){
	  $('<span class="info">The username field must contain only alphabetical or numeric characters.</span>').insertAfter("#username");
	  $("#uok").remove();
	  $("#uerror").remove();
	});
	
	$("#username").blur(function(){
	    var regusername = /^[a-zA-Z0-9_]{1,}$/;  
        var uname = $("#username").val();
		if(uname.length<=0||!regusername.test(uname))
		{
		   $(".info").remove();
		   $('<span class="error" id="uerror">empty field</span>').insertAfter("#username");
		}
		else
		{
		   $(".info").remove();
		   $('<span class="ok" id="uok">ok</span>').insertAfter("#username");
		}
	  }); 	  
	  
	$("#password").focus(function(){
	  $('<span class="info">The password field should be at least 8 characters long.</span>').insertAfter("#password");
	  $("#pok").remove();
	  $("#perror").remove();
	});  
	
	$("#password").blur(function(){
        var pword = $("#password").val();
		if(pword.length<8)
		{
		   $(".info").remove();
		   $('<span class="error" id="perror">empty field</span>').insertAfter("#password");
		}
		else
		{
		   $(".info").remove();
		   $('<span class="ok" id="pok">ok</span>').insertAfter("#password");
		}
	}); 	  
	  
	$("#email").focus(function(){
	  $('<span class="info">The email field should be a valid email address (local-part@domain).</span>').insertAfter("#email");
	  $("#eok").remove();
	  $("#eerror").remove();
	}); 
	 
    $("#email").blur(function(){
        var mail = $("#email").val();
		var rugemail= /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if(!rugemail.test(mail))
		{
		   $(".info").remove();
		   $('<span class="error" id="eerror">empty field</span>').insertAfter("#email");
		}
		else
		{
		   $(".info").remove();
		   $('<span class="ok" id="eok">ok</span>').insertAfter("#email");
		}
	});  
		
});