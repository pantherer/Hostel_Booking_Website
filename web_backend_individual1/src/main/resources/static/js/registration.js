
function confirmReg(){
    let fullname=document.getElementById("FullName").value
    let phone=document.getElementById("Phone").value;
    let address=document.getElementById("Address").value;
    let username=document.getElementById("UserName").value;
    let password=document.getElementById("Password").value;
    let btn = document.getElementById("btn");

    // alert(fullname);
    if(fullname==""){
        alert("Please enter your fullname!!")
    }else if(phone==""){
        alert("please enter your phone number!!")
    }else if(phone.length!==10){
        alert("Phone number must be of 10 digit!!")
    }
    else if(address==""){
        alert("Please enter your fullname!!")
    }else if(username==""){
        alert("please enter your phone number!!")
    }else if(password==""){
        alert("Phone number must be of 10 digit!!")
    }else{
        alert("Hurray! Successfully Booked!!")
        btn.type="submit"
    }
}