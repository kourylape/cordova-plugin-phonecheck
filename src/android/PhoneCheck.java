/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/

package local.plugin.phonecheck;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;


public class PhoneCheck extends CordovaPlugin {
  

  /**
   * Constructor.
   */
  public PhoneCheck() {
  }

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      super.initialize(cordova, webView);
      Log.d("STRING","STRING!");
  }


  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
  Log.d("STRING","STRING!");
    if (action.equals("check")) {
      String check = this.check();
      callbackContext.success(check);
    } else {
      return false;
    }
    return true;
  }
  
    private String check() {
      String response;
      try {
        if (((TelephonyManager) this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE)).getPhoneType() == TelephonyManager.PHONE_TYPE_NONE)
        {
            response = "IMPOSSIBLE";
        } else {
            response = "CANCALL";
        }
      } catch (Exception e) {
        response = "UNKNOWN";
      }
        
      return response;
    }

}