$(function(){
  $('.add-entry-btn').on('click', 'i' , function(){
    window.location = "index.html";
  });
});

var disableSaveButtonWith = function(form, text){
  var saveBtn = $(form).find('button[type=submit]')[0];
  saveBtn.disabled = true;
  saveBtn.textContent = text;
};

var enableSaveButtonWith = function(form, text){
  var saveBtn = $(form).find('button[type=submit]')[0];
  saveBtn.disabled = false;
  saveBtn.textContent = text;
};

var getParameterByName = function(name, location) {
  var query_name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
  var regex = new RegExp("[\\?&]" + query_name + "=([^&#]*)"),
      results = regex.exec(location.search);
  return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
};
