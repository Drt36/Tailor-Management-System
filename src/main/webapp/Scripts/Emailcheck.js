$(document).ready(function(){
            $('#checkemail').change(function(){
                var user_email= $('#checkemail').val();
                $.ajax({
                url: 'emailcheckservlet',
                type: 'POST',
                data: {user_email: user_email},
                success: function(emailresult){
                    if(emailresult==="Email Already Exist!")
                    { 
                         $('#emailexist').hide();
                         $('#submitemail').prop('disabled',false);
                    }
                    else if(emailresult==="NotExist")
                    {
                        $('#emailexist').html('This email is not regestred with us!');
                        $('#emailexist').show();
                        $('#submitemail').prop('disabled',true);
                    }
                    else{
                        $('#emailexist').hide();
                        $('#submitemail').prop('disabled',true);
                        
                    }
                }
        });
    });
 });