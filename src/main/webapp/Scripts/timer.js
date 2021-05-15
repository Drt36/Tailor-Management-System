var timer2 = "02:00";
var interval = setInterval(function() {


  var timer = timer2.split(':');
  //by parsing integer, I avoid all extra string processing
  var minutes = parseInt(timer[0], 10);
  var seconds = parseInt(timer[1], 10);
  --seconds;
  minutes = (seconds < 0) ? --minutes : minutes;
  if (minutes < 0) clearInterval(interval);
  seconds = (seconds < 0) ? 59 : seconds;
  seconds = (seconds < 10) ? '0' + seconds : seconds;
  //minutes = (minutes < 10) ?  minutes : minutes;
  $('#timer').html(minutes + ':' + seconds);
  if (minutes < 0) clearInterval(interval);
  //check if both minutes and seconds are 0
  if ((seconds <=0) && (minutes <=0)) clearInterval(interval);
  timer2 = minutes + ':' + seconds;
  
}, 1000);

setTimeout(function() {
    $("#timer").hide(); 
    $('#expire').html('OTP Code has been Expired!');
    $.ajax({
                url: 'expireotpcodeservlet',
                type: 'POST'      
        });
},120*1000);