Cordova Phone Check Plugin
====================
The purpose of the Phone Check plugin is to check to see if the user's device can make a phone call and returns a string that can be used to hide and show elements. For example - hide tel:// links if the user cannot make calls.


## Suported Platforms

- **iOS**
- **Android**

## Installation
The plugin can installed to the local environment or via the Cordova CLI

### Adding the Plugin via Cordova
```bash
cordova plugin add https://github.com/ckylape/cordova-plugin-phonecheck.git
```

### Removing the Plugin
```bash
cordova plugin remove local.plugin.phonecheck
```

## Using the Plugin
The plugin creates and uses the object ```PhoneCheck.status``` and returns the following strings:

- ```CANCALL``` - the user can make phone calls
- ```IMPOSSIBLE``` - it's impossible for the user to make calls (ever)
- ```INACTIVE``` - (iOS only) the user can make calls but not at the moment (ie: Airplane Mode, no SIM, etc.))
- ```UNKNOWN``` - the details of the user's device could not be retrieved 

### Example
The following script checks if the user can call and shows a hidden element:

```javascript
if(PhoneCheck.status === 'CANCALL') {
  document.querySelector('#MY_ID').style.display = 'block';
}
```
