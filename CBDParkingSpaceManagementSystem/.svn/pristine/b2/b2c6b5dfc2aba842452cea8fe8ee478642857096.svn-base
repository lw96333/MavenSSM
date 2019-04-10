window.onload = function(){
    var divTip = document.createElement("div");
    divTip.id = "tip";
    //divTip.innerHTML = "<h1><a href='javascript:void(0)' onclick='start()'>关闭</a>新消息通知</h1><p></p>";
    divTip.style.height = '0px';
    divTip.style.bottom = '0px';
    divTip.style.position = 'fixed';
    document.body.appendChild(divTip);
}
   var handle;
   function start(messge){
    var obj = document.getElementById("tip");
    obj.innerHTML = "<h1><a href='javascript:void(0)' onclick='start()'>关闭</a>新消息通知</h1><p>"+messge+"</p>";
    if (parseInt(obj.style.height) == 0) {
     obj.style.display = "block";
     handle = setInterval("changeH('up')", 20);
    }
    else {
     handle = setInterval("changeH('down')", 20)
    }
   }
   function changeH(str){
    var obj = document.all ? document.all["tip"] : document.getElementById("tip"); //docuemnt.all ??????
    if (str == "up") {
     if (parseInt(obj.style.height) > 100) 
      clearInterval(handle);
     else
      obj.style.height = (parseInt(obj.style.height) + 8).toString() + "px";
    }
    if (str == "down") {
     if (parseInt(obj.style.height) < 8) {
      clearInterval(handle);
      obj.style.display = "none";
     }
     else
      obj.style.height = (parseInt(obj.style.height) - 8).toString() + "px";
    }
   }
   function showwin(){
    //document.getElementsByTagName("html")[0].style.overflow = "hidden";
    start();
   }
