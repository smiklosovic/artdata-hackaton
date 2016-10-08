////
////  File.swift
////  Art-Data
////
////  Created by Alexey Potapov on 08/10/2016.
////  Copyright © 2016 Community. All rights reserved.
////
//
//import UIKit
//
// protocol Layoutable {
//    var top:CGFloat {get}
//    var bottom:CGFloat {get}
//    var right:CGFloat {get}
//    var left:CGFloat {get}
//}
//
//struct Layout {
//    var top:CGFloat = 0.0
//    var bottom:CGFloat = 0.0
//    var right:CGFloat = 0.0
//    var left:CGFloat = 0.0
//    
//    var font:UIFont?
//    
//    init(top:CGFloat,bottom:CGFloat,right:CGFloat,left:CGFloat) {
//        self.top = top
//        self.bottom = bottom
//        self.right = right
//        self.left = left
//    }
//    
//    init(withLayoutable layout:Layoutable){
//        self.init(top: layout.top,bottom: layout.bottom,right: layout.right,left: layout.left)
//    }
//}
//
//struct DynamicCellSize {
//    
//    let cellClass:AnyClass
//    let font:UIFont
//    let owner:AnyObject
//    var separateNib:Bool = false
//    
//     init(cellClass:AnyClass,font:UIFont,owner:AnyObject)
//    {
//        self.cellClass = cellClass
//        self.font = font
//        self.owner = owner
//    }
//    
//     init(cellClass:AnyClass,font:UIFont,owner:AnyObject, separateNibCell:Bool)
//    {
//        self.cellClass = cellClass
//        self.font = font
//        self.owner = owner
//        self.separateNib = separateNibCell
//    }
//    
//    func layoutParams() -> (String,Layout)
//    {
//        let cellName = ~|cellClass
//        
//        var cellObject:AnyObject?
//        
//        cellObject = Bundle(for:cellClass).loadNibNamed(cellName, owner: self.owner, options: nil)!.first as AnyObject?
//        
//        let cell = cellObject as! Layoutable
//        
//        var layout:Layout = Layout(withLayoutable: cell)
//        layout.font = self.font
//        
//        return (cellName,layout)
//    }
//}
//
//class DynamicCellSizeFlowLayout: UICollectionViewFlowLayout {
//    
//    var registeredLayouts:[String: Layout] = [:]
//    
//    required  init(coder aDecoder: NSCoder) {
//        super.init(coder: aDecoder)!
//        
//        self.minimumInteritemSpacing = 0.0
//        self.minimumLineSpacing = 0.0
//        self.sectionInset = UIEdgeInsetsMake(0.0, 0.0, 0.0, 0.0)
//    }
//    
//     func registerCell(forDynamicSize size:DynamicCellSize)
//    {
//        let (first,second) = size.layoutParams()
//        self.registeredLayouts[first] = second
//    }
//    
//     func cellHeight(forWidth width:CGFloat,cellClass:AnyClass, text:NSString) -> CGFloat
//    {
//        if let layout:Layout = self.registeredLayouts[~|cellClass]
//        {
//            let widthDiff = self.sectionInset.left + self.sectionInset.right + self.minimumInteritemSpacing + layout.left + layout.right
//            let height = text.heightWithFont(layout.font, constraintToWidth: width - widthDiff)
//            return height + layout.top + layout.bottom + 2.0
//        }
//        
//        return 0.0
//    }
//    
//     func cellWidth(forHeight height:CGFloat,cellClass:AnyClass, text:NSString) -> CGFloat
//    {
//        if let layout:Layout = self.registeredLayouts[~|cellClass]
//        {
//            let heightDiff = self.sectionInset.top + self.sectionInset.bottom + layout.top + layout.bottom
//            let width = text.widthWithFont(layout.font, constraintToHeight: height - heightDiff)
//            
//            return width + layout.left + layout.right + 2.0
//        }
//        
//        return 0.0
//    }
//}
