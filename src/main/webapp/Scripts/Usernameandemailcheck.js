
var usernameresultglobal;
var emailresultglobal;
$(document).ready(function(){
            $('#usernamecheck').change(function(){
                var username= $('#usernamecheck').val();
                $.ajax({
                url: 'usernamecheckservlet',
                type: 'POST',
                data: {username: username},
                success: function(usernameresult) {
                    usernameresultglobal=usernameresult;
                    if(usernameresult==="Username Already Exist!"){
                        $('#usernameresult').html(usernameresult);
                        $('#usernameresult').show();
                        $('#submit').prop('disabled',true);
                    }
                    
                    if(usernameresult==="NotExist"){
                        $('#submit').prop('disabled',false);
                        $('#usernameresult').hide();
                    }
                    if(emailresultglobal==="Email Already Exist!" && usernameresultglobal==="NotExist")
                    {
                        $('#submit').prop('disabled',true);
                       
                    }
                }
        });
            });
        });
        
        
        $(document).ready(function(){
            $('#emailcheck').change(function(){
                var user_email= $('#emailcheck').val();
                $.ajax({
                url: 'emailcheckservlet',
                type: 'POST',
                data: {user_email: user_email},
                success: function(emailresult) {
                    emailresultglobal=emailresult;
                    if(emailresult==="Email Already Exist!")
                    {
                        $('#emailresult').html(emailresult);
                        $('#emailresult').show();
                        $('#submit').prop('disabled',true);
                    }
                    if(emailresult==="NotExist")
                    {
                        $('#submit').prop('disabled',false);  
                        $('#emailresult').hide();
                    }
                    
                    if(usernameresultglobal==="Username Already Exist!" && emailresult==="NotExist")
                    {
                        $('#submit').prop('disabled',true);  
                    }
                    
                }
        });
            });
        });
 