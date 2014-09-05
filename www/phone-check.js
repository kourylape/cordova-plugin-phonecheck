/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/

var channel = require('cordova/channel'),
    exec = require('cordova/exec');

function PhoneCheck() {
  var me = this;
  me.status = 'UNKNOWN';
  me.getInfo(function(result) {
      me.status = result;
  },function(e) {
    console.log("[ERROR] Plugin Error: " + e);  
  });
}

PhoneCheck.prototype.getInfo = function(successCallback,failureCallback) {
    exec(successCallback, failureCallback, "PhoneCheck", "check", []);
};


module.exports = new PhoneCheck();