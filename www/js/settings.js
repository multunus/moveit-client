var settings = {
  test:{
    baseUrl: "https://pink-server.herokuapp.com/",
    apiUrl: "https://pink-server.herokuapp.com/api/"
  },
  production:{
    baseUrl: "https://mov3it.herokuapp.com/",
    apiUrl: "https://mov3it.herokuapp.com/api/"
  },

  getSetting: function(setting){
    var settings = JSON.parse(localStorage.getItem("settings")) || {};
    var mode = settings.mode || "production";
    return this[mode][setting];
  }
};
