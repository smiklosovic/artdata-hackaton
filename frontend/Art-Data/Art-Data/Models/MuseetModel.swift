//
//  MuseetModel.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import ObjectMapper

class MuseetModel: Mappable {
    
    var link: String?
    var title: String?
    var author: String?
    
    required init?(map: Map) {}
    
    func mapping(map: Map) {
        link <- map["link_to_image"]
        title <- map["title"]
        author <- map["author"]
    }
}
