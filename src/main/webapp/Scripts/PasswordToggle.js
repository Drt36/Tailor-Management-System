/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//const togglePassword = document.querySelector('#togglePassword');
const password = document.querySelector('#password');

togglePassword.addEventListener('click', function (e) {
    
     var temp = document.getElementById("password"); 
            if (temp.type === "password") { 
                temp.type = "text"; 
            } 
            else { 
                temp.type = "password"; 
            } 
    temp.style.width="100%";
    temp.style.border = "1px solid #ccc";
    temp.style.borderRadius = "15px";
    temp.style.margin= "8px 0px";
    temp.style.padding = "12px 20px";
    temp.style.display = "inline-block";
    temp.style.boxSizing = "border-box";


    // toggle the eye slash icon
    this.classList.toggle('fa-eye-slash');
});