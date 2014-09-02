//
//  CDVPhoneCheck.h
//  WCAL
//
//  Created by Koury Lape on 9/2/14.
//
//

#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>

@interface CDVPhoneCheck : CDVPlugin

//Check If Phone Can Make A Call
- (void) check:(CDVInvokedUrlCommand*)command;

@end
