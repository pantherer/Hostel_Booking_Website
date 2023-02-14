function confirm(){
    let FullName = document.getElementById("FullName").value
    let Phone = document.getElementById("Phone").value
    let RoomType = document.getElementById("RoomType").value
    let checkOutDate = document.getElementById("checkOutDate").value
    let checkInDate = document.getElementById("checkInDate").value
    let btn = document.getElementById("btn");

    if(FullName==""){
        alert("Please enter your fullname!!")
    }else if(Phone==""){
        alert("please enter your phone number!!")
    }else if(Phone.length!==10){
        alert("Phone number must be of 10 digit!!")
    }else if(RoomType==""){
        alert("please enter your RoomType!!")
    }else if(checkOutDate==""){
        alert("please enter your checkOutDate!!")
    }else if(checkInDate==""){
        alert("please enter your checkInDate!!")
    }else{
        alert("Hurray! Successfully Booked!!")
        btn.type="submit"
    }
}
