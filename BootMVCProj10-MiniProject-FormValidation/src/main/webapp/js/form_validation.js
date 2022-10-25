function validate(frm) {
	//Read form data
	let name = frm.ename.value;
	let job = frm.job.value;
	let sal = frm.sal.value;
	let deptno = frm.deptno.value;
	let validationFlag =  true;
	
	//form validation logics (client side)
	if(name=="") {
		document.getElementById("enameErr").innerHTML="Employee name is required";
		validationFlag=false;
	}
	else if(name.length()<5){
		document.getElementById("enameErr").innerHTML="Employee name must have minimum of 5 character";	
		validationFlag=false;
	}
	
	if(job=="") {
		document.getElementById("jobErr").innerHTML="Employee designation is required";
		validationFlag=false;
	}
	else if(job.length()<5){
		document.getElementById("jobErr").innerHTML="Employee designation must have minimum of 5 character";	
		validationFlag=false;
	}

	if(sal=="") {
		document.getElementById("salErr").innerHTML="Employee salary is required";
		validationFlag=false;
	}
	else if(isNaN(sal)){
		document.getElementById("salErr").innerHTML="Employee salary must have be numberic value";	
		validationFlag=false;
	}
	else if(sal<10000 || sal>100000){
		document.getElementById("salErr").innerHTML="Employee salary must have be given in the range of 10000 to 100000";	
		validationFlag=false;
	}

	if(deptno=="") {
		document.getElementById("deptnoErr").innerHTML="Employee Dept no is required";
		validationFlag=false;
	}
	else if(isNaN(deptno)){
		document.getElementById("deptnoErr").innerHTML="Employee Dept no must have be numberic value";	
		validationFlag=false;
	}
	else if(deptno<10000 || deptno>100000){
		document.getElementById("deptnoErr").innerHTML="Employee Dept no must have be given in the range of 10 to 100";	
		validationFlag=false;
	}
	
	// changing vflag (hidden box value 'yes' indicating client-side form validations are performed) 
	frm.vflag.value="yes";
	
	return validationFlag;
}