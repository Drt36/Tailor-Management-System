/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global thirddiv, firstdiv, seconddiv, fourthdiv, TailorManagementSystemWithDesignRecommendationFinal*/

console.log("This is sample design page");

// Create an ajax get request
const xhr = new XMLHttpRequest();
xhr.open('GET','https://api-test-tmswdr.herokuapp.com/samplesuit', true);

// What to do when response is ready
xhr.onload = function () {
    if (this.status === 200) {
        let json = JSON.parse(this.responseText);
        console.log(json);
        let designHtml= "";
        let count=0;
        var context="TailorManagementSystemWithDesignRecommendationFinal";
        var customer_email=document.getElementById("customer_email_id").value;
        var product_code=document.getElementById("product_code_id").value;
        console.log(customer_email);
         console.log(product_code);
        json.forEach(function(element,index){
            console.log(element, index);
            
            var design=`<img src="${element["Design_url"]}"  width="200" height="200">
            <div class="container">
                <h4><b>${element["Design_title"]}</b></h4> 
                <h4 id="design_code">${element["Design_code"]} </h4>
              <br>
              <form action="recommendation_displayrecommendeddesignsservlet" id="beforerecommendform" method="post">
                  <input type="hidden" name="customer_email_id"value="${customer_email}" >
                  <input type="hidden" name="product_code_id" value="${product_code}">
                  <input type="hidden" name="design_url_id" value="${element["Design_url"]}">
                  <input type="hidden" name="design_code_id" value="${element["Design_code"]}">
                  <button id="recommendationbutton" type="submit"class="btn  success">Recommend</button>
              </form>
               <form action="order_afterproductselectservlet" id="beforerecommendform" method="post">
                  <input type="hidden" name="customer_email_id"value="${customer_email}" >
                  <input type="hidden" name="product_code_id" value="${product_code}">
                  <input type="hidden" name="design_url_id" value="${element["Design_url"]}">
                  <button id="selectbutton" type="submit">Select</button>
               </form> 
            </div>
         </div>`;
             designHtml=design;
             
             count++;
             if(count===1){
            
                firstdiv.innerHTML = designHtml; 

             }
             else if(count===2){
                seconddiv.innerHTML = designHtml;
             }
             else if(count===3){
                 thirddiv.innerHTML = designHtml;

             }
             else if(count===4){
                 fourthdiv.innerHTML = designHtml;
                
             }
        });
        
      
    }
    else {
        console.log("Some error occured");
    }
};

xhr.send();



