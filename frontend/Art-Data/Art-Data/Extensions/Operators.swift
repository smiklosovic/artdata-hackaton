//
//  Operators.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit

public func asQualifiedStr(target:AnyClass) -> String {
    
    let mirror = Mirror(reflecting: target)
    
    let subjectTypeAsString =  String(describing: mirror.subjectType)
    
    var components = subjectTypeAsString.components(separatedBy: ".")
    components.removeLast()
    
    //TODO: workaround for Modul, find solution for Mirror reflect
    let modulName = Bundle.main.infoDictionary!["CFBundleName"]! as! String
    
    components.insert(modulName , at: 0)
    
    return components.joined(separator: ".")
}

public func asString(target:AnyClass) -> String {
    
    let components = asQualifiedStr(target: target).components(separatedBy: ".")
    return components.last!
}

public func asClass(className:String) -> AnyObject.Type {
    return NSClassFromString(className)! as AnyObject.Type
}

prefix operator ~|
public prefix func ~|(target:AnyClass) -> String {
    return asString(target: target)
}

prefix operator ~||
public prefix func ~||(target:AnyClass) -> String {
    return asQualifiedStr(target: target)
}

prefix operator |~
public prefix func |~(className:String) -> AnyObject.Type {
    return asClass(className: className)
}
