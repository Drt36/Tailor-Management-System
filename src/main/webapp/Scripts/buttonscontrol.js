//login button control
$(document).ready(function () {
        $("#loginform").submit(function (e) {


            //disable the login button
            $("#login").attr("disabled", true);
            $("#login").prop("value", "Authenticating...");

            return true;

        });
    });

//user register Button control
$(document).ready(function () {

        $("#registerform").submit(function (e) {


            //disable the submit button
            $("#submit").attr("disabled", true);
            $("#submit").prop("value", "Please Wait...");

            return true;

        });
    });
    
    
 //verify button control   
 $(document).ready(function () {

        $("#mobileverificationform").submit(function (e) {


            //disable the submit button
            $("#verify").attr("disabled", true);
            $("#verify").prop("value", "Please Wait...");
  
            return true;

        });
    });
    
    
//Submit button control   
 $(document).ready(function () {

        $("#codevalidationform").submit(function (e) {


            //disable the submit button
            $("#submit").attr("disabled", true);
            $("#submit").prop("value", "Authenticating...");
  
            return true;

        });
    });
    //Submit send code button control   
 $(document).ready(function () {

        $("#emailverificationform").submit(function (e) {
            //disable the sendcode button
            $("#submitemail").attr("disabled", true);
            $("#submitemail").prop("value", "Sending...");
  
            return true;

        });
    });
    
 //change password submit button control   
 $(document).ready(function () {

        $("#changepasswordform").submit(function (e) {
            //disable the sendcode button
            $("#submitemail").attr("disabled", true);
            $("#submitemail").prop("value", "please Wait...");
  
            return true;

        });
    });
    
    
    
//edit profile Button control
$(document).ready(function () {

        $("#editprofileform").submit(function (e) {


            //disable the submit button
            $("#editprofilesubmit").attr("disabled", true);
            $("#editprofilesubmit").prop("value", "Please Wait...");

            return true;

        });
    });
    
    
//admin side edit profile Button control
$(document).ready(function () {

        $("#adminsideeditprofileform").submit(function (e) {


            //disable the submit button
            $("#adminsideeditprofilesubmit").attr("disabled", true);
            $("#adminsideeditprofilesubmit").prop("value", "Please Wait...");

            return true;

        });
    });
    
    //add customer button
    $(document).ready(function () {

        $("#customerregisterform").submit(function (e) {


            //disable the submit button
            $("#submitcustomer").attr("disabled", true);
            $("#submitcustomer").prop("value", "Please Wait...");

            return true;

        });
    });
    
    //edit customer button
    $(document).ready(function () {

        $("#customereditform").submit(function (e) {


            //disable the submit button
            $("#editcustomer").attr("disabled", true);
            $("#editcustomer").prop("value", "Please Wait...");

            return true;

        });
    });
    
    //addproduct button
    $(document).ready(function () {

        $("#productaddform").submit(function (e) {
            //disable the submit button
            $("#addproduct").attr("disabled", true);
            $("#addproduct").prop("value", "Please Wait...");

            return true;

        });
    });
    //editproduct button
    $(document).ready(function () {

        $("#producteditform").submit(function (e) {
            //disable the submit button
            $("#editproduct").attr("disabled", true);
            $("#editproduct").prop("value", "Please Wait...");

            return true;

        });
    });
    
    //add order button
    $(document).ready(function () {

        $("#addorderform").submit(function (e) {
            //disable the submit button
            $("#addorderbutton").attr("disabled", true);
            $("#addorderbutton").prop("value", "Please Wait...");

            return true;

        });
    });
    
    //editorder button
    $(document).ready(function () {

        $("#editorderform").submit(function (e) {
            //disable the submit button
            $("#editorderbutton").attr("disabled", true);
            $("#editorderbutton").prop("value", "Please Wait...");

            return true;

        });
    });
    
    //clear due button
    $(document).ready(function () {

        $("#cleardueform").submit(function (e) {
            //disable the submit button
            $("#clearduebutton").attr("disabled", true);
            $("#clearduebutton").prop("value", "Paying");

            return true;

        });
    });
   //addexpense button
    $(document).ready(function () {

        $("#expenseaddform").submit(function (e) {
            //disable the submit button
            $("#addexpense").attr("disabled", true);
            $("#addexpense").prop("value", "Please Wait...");

            return true;

        });
    });
    //editexpense button
    $(document).ready(function () {

        $("#expenseeditform").submit(function (e) {
            //disable the submit button
            $("#editexpense").attr("disabled", true);
            $("#editexpense").prop("value", "Please Wait...");

            return true;

        });
    });
    //profile picture update
    $(document).ready(function () {

        $("#profileform").submit(function (e) {
            //disable the submit button
            $("#updateprofilepicture").attr("disabled", true);
            $("#updateprofilepicture").prop("value", "updating");

            return true;

        });
    });
    
    //pay salary button
    $(document).ready(function () {

        $("#paysalaryform").submit(function (e) {
            //disable the submit button
            $("#paysalarybutton").attr("disabled", true);
            $("#paysalarybutton").prop("value", "Paying");

            return true;

        });
    });
    