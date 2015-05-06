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

var UserInteraction = {
  action: function(fromEmail, toEmail, draggable, action, name){

    if(fromEmail != toEmail && action != ''){
      console.log(fromEmail);
      console.log(toEmail);
      draggable.animate({
        left: '+=400px'
      }, 250);

      draggable.siblings('.interaction-message.' + action).removeClass('hidden');
      draggable.hide();

      var data = {
        from_email_id : fromEmail,
        to_email_id : toEmail
      };

      $.ajax({
        dataType: 'json',
        url: settings.getSetting("userApiUrl") + action,
        type: 'POST',
        data: data,
        success: function(data, textStatus, jqXHR) {
          console.log(action + "ing....");
          Materialize.toast("You " + action + "'d " + name, 2000);
          draggable.unbind("swiperight");
          draggable.addClass('blank');
        },
        error: function() {
          Materialize.toast("Oops, something went wrong", 2000);
        }
      });

      setTimeout(function(){
        draggable.show();
        draggable.animate({
          left: '-=400px'
        }, 250);
        draggable.siblings('.interaction-message.' + action).addClass('hidden');
      }, 500);
    }
  }
};

