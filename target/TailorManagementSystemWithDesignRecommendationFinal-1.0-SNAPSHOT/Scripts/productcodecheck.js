/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
            $('#product_codecheck').change(function(){
                var product_code= $('#product_codecheck').val();
                $.ajax({
                url: 'product_productcodecheckservlet',
                type: 'POST',
                data: {product_code: product_code},
                success: function(productcoderesult) {
                    if(productcoderesult==="Product Code Already Exist!"){
                        $('#productcoderesult').html(productcoderesult);
                        $('#productcoderesult').show();
                        $('#addproduct').prop('disabled',true);
                    }
                    
                    if(productcoderesult==="NotExist"){
                        $('#addproduct').prop('disabled',false);
                        $('#productcoderesult').hide();
                    }
               
                }
        });
            });
        });