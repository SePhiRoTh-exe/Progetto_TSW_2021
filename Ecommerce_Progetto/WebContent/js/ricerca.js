/**
 * 
 */

var req;
function ricercaTesto(){
	var ricerca=document.getElementById("barra-ricerca-box").value;
	if(window.XMLHttpRequest){
		req=new xmlHttpRequest();
	}
	else if(window.ActiveXObject){
		req=new ActiveXObject("Microsoft.XMLHttp");
	}
	var url="/catalogo?q="+ricerca;
	req.open("get",url,true);
	req.onreadystatechange=callback;
	req.send(null);
	function callback(){
		if(req.readystate===XMLHttpRequest.DONE){
			var stato=req.status;
			if(stato===0 || stato>=200 && stato<=400){
				console.log(req.resposeText);
			}
		}
	}
}