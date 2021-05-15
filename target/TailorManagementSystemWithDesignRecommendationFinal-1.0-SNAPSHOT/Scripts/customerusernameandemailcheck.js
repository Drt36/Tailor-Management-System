/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var usernameresultglobal;
var emailresultglobal;
$(document).ready(function(){
            $('#usernamecheck').change(function(){
                var username= $('#usernamecheck').val();
                $.ajax({
                url: 'customer_usernamecheckservlet',
                type: 'POST',
                data: {username: username},
                success: function(usernameresult) {
                    usernameresultglobal=usernameresult;
                    if(usernameresult==="Username Already Exist!"){
                        $('#usernameresult').html(usernameresult);
                        $('#usernameresult').show();
                        $('#submitcustomer').prop('disabled',true);
                    }
                    
                    if(usernameresult==="NotExist"){
                        $('#submitcustomer').prop('disabled',false);
                        $('#usernameresult').hide();
                    }
                    if(emailresultglobal==="Email Already Exist!" && usernameresultglobal==="NotExist")
                    {
                        $('#submitcustomer').prop('disabled',true);
                       
                    }
                }
        });
            });
        });
        
        
        $(document).ready(function(){
            $('#emailcheck').change(function(){
                var customer_email= $('#emailcheck').val();
                $.ajax({
                url: 'customer_emailcheckservlet',
                type: 'POST',
                data: {customer_email: customer_email},
                success: function(emailresult) {
                    emailresultglobal=emailresult;
                    if(emailresult==="Email Already Exist!")
                    {
                        $('#emailresult').html(emailresult);
                        $('#emailresult').show();
                        $('#submitcustomer').prop('disabled',true);
                    }
                    if(emailresult==="NotExist")
                    {
                        $('#submitcustomer').prop('disabled',false);  
                        $('#emailresult').hide();
                    }
                    
                    if(usernameresultglobal==="Username Already Exist!" && emailresult==="NotExist")
                    {
                        $('#submitcustomer').prop('disabled',true);  
                    }
                    
                }
        });
            });
        });
 

