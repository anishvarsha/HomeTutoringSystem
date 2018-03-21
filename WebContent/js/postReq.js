/**
 * Post method for data
 */
function post(){
    var str1 = document.getElementById("select1").value;
    var str2 = document.getElementById("select2").value;
    var xmlhttp = new XMLHttpRequest();
	  var url = "?year="+str1+"&gender="+str2;
    xmlhttp.open("POST",url,true);
    xmlhttp.send();
	  
    xmlhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
			var res = xmlHttp.responseText;
			alert(res);
			document.getElementById("content").innerHTIML = xmlhttp.responseText;
		}
    }
    
    var data = {};
    $.ajax({
        type: 'POST',
        url: "http://",  //Interface address
        data: JSON.stringify(data), 
        success: function(data) {
            var result = JSON.stringify(data);
            document.getElementById("result").innerHTML = result;
            },
        dataType:"json"
    })
}

