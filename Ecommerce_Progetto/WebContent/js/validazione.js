/**
 * 
 */

function validate()
{
	var nome_valid=/^[a-z A-Z]+$/;
	var cognome_valid=/^[a-z A-Z]+$/;
	var email_valid=/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/;
	var password_valid=/^[A-Z a-z 0-9 !@#$%&*()<>]{6,12}$/;
	
	var nome=document.getElementById("nome");
	var cognome=document.getElementById("cognome");
	var email=document.getElementById("email");
	var password=document.getElementById("password");
	
	var nome_check=true;
	var cognome_check=true;
	var email_check=true;
	var password_check=true;
	if(!nome_valid.test(nome.value) || nome.value=='')
	{
		nome.focus();
		nome.style.background='#f08080';
		nome_check=false;
	}
	if(!cognome_valid.test(cognome.value) || cognome.value=='')
	{
		cognome.focus();
		cognome.style.background='#f08080';
		cognome_check=false;
	}
	if(!email_valid.test(email.value) || email.value=='')
	{
		email.focus();
		email.style.background='#f08080';
		email_check=false;
	}
	if(!password_valid.test(password.value) || password.value=='')
	{
		password.focus();
		password.style.background='#f08080';
		password_check=false;
	}
	if(!nome_check || !cognome_check || !email_check || !password_check)
	{
		return false;
	}
}