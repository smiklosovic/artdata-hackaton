////
////  File.swift
////  Art-Data
////
////  Created by Alexey Potapov on 08/10/2016.
////  Copyright © 2016 Community. All rights reserved.
////
//
//import UIKit
//import Foundation
//
//extension UIDevice {
//    
//    func acquire() -> UIUserInterfaceIdiom{
//        return UIDevice.current.userInterfaceIdiom
//    }
//
//    func isPad() -> Bool {
//        return self.acquire() == .pad
//    }
//    
//    func isPhone() -> Bool {
//        return self.acquire() == .phone
//    }
//
//    func isPadPro() -> Bool {
//        return self.isPad() && UIScreen.main.bounds.size.height == 1366 || UIScreen.main.bounds.size.width == 1366
//    }
//}
//
//
//protocol StringExtension {
//    
//    var length: Int {get}
//    
//    func heightWithFont(font:UIFont, constraintToWidth width:CGFloat) -> CGFloat
//    func widthWithFont(font:UIFont, constraintToHeight height:CGFloat) -> CGFloat
//    func sizeWithFont(font:UIFont) -> CGSize
//    func underscore() -> String
//    func camelcase() -> String
//    func classify() -> String
//}
//
//extension String : StringExtension {
//    
//    public var length: Int { return self.characters.count }
//    
//    public func heightWithFont(font:UIFont, constraintToWidth width:CGFloat) -> CGFloat {
//        
//        let stringSelf = self as String
//        return stringSelf.heightWithFont(font: font, constraintToWidth: width)
//    }
//    
//    public func widthWithFont(font:UIFont, constraintToHeight height:CGFloat) -> CGFloat {
//        
//        let stringSelf = self as String
//        return stringSelf.widthWithFont(font: font, constraintToHeight: height)
//    }
//    
//    public func sizeWithFont(font:UIFont) -> CGSize {
//        
//        let stringSelf = self as String
//        return stringSelf.size(attributes: [NSFontAttributeName:font])
//    }
//    
//    public func underscore() -> String {
//        let stringSelf = self as String
//        return stringSelf.underscore()
//    }
//    
//    public func camelcase() -> String {
//        let stringSelf = self as String
//        return stringSelf.camelcase()
//    }
//    
//    public func classify() -> String {
//        let stringSelf = self as String
//        return stringSelf.classify()
//    }
//}
//
//extension String {
//    public func rangesOfString(searchString:String, options: String.CompareOptions = [], searchRange:Range<Index>? = nil ) -> [Range<Index>] {
//        if let range = rangeOfString(searchString, options: options, range:searchRange) {
//            
//            let nextRange = Range(range.endIndex ..< self.endIndex)
//            return [range] + rangesOfString(searchString, searchRange: nextRange)
//        } else {
//            return []
//        }
//    }
//}
