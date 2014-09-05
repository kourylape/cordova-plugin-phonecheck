//
//  CDVPhoneCheck.m
//  WCAL
//
//  Created by Koury Lape on 9/2/14.
//
//

#import "CDVPhoneCheck.h"
#import <CoreTelephony/CTTelephonyNetworkInfo.h>
#import <CoreTelephony/CTCarrier.h>
#import <Cordova/CDV.h>


@implementation CDVPhoneCheck

/* 
 * canDeviceMakeACall
 * Returns: bool true|false
*/
-(void)check:(CDVInvokedUrlCommand*)command {
    
    NSString *check = @"UNKNOWN";
    
    // Check if Device Supports tel:// hrefs
    if ([[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:@"tel://"]]) {
        
        CTTelephonyNetworkInfo *netInfo = [[CTTelephonyNetworkInfo alloc] init];
        CTCarrier *carrier = [netInfo subscriberCellularProvider];
        NSString *mnc = [carrier mobileNetworkCode];
        
        // Check if device can make a call right now (Airplane Mode or Not-Activated)
        if (([mnc length] == 0) || ([mnc isEqualToString:@"65535"])) {
            check = @"INACTIVE";
        } else {
            check = @"CANCALL";
        }
            
    } else {
        check = @"IMPOSSIBLE";
    }
    
    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:check];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        
}

@end
