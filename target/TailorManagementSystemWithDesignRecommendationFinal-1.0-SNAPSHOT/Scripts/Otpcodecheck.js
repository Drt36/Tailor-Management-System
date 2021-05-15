$(document).ready(function(){
            $('#otpcode').change(function(){
                var otpcode= $('#otpcode').val();
                $.ajax({
                url: 'Otpcodecheckservlet',
                type: 'POST',
                data: {otpcode: otpcode},
                success: function(otpcoderesult) {
                    if(otpcoderesult==="True"){
                        $('#matched').html('OTP Code Matched');
                        $('#submit').prop('disabled',false);
                        $('#notmatched').hide();
                        $('#matched').show();
                    }
                    
                    if(otpcoderesult==="False"){
                        $('#notmatched').html('OTP Code Not Matched !');
                        $('#submit').prop('disabled',true);
                        $('#matched').hide();
                        $('#notmatched').show();
                    }
                    
                }
        });
            });
        });