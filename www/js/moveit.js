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
