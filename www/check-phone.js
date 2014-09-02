





var CheckPhone = {

  check: function() {

    cordova.exec(callback, null, 'CheckPhone', 'check', []);

  },

  callback: function() {
    alert('test');
  }

};