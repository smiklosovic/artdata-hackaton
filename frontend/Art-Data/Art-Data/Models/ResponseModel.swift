//
//  ResponseModel.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import ObjectMapper

class ResponseModel: Mappable {
    
    var museet: [MuseetModel]?
    var weather: WeatherModel?
    
    required init?(map: Map) {
    }
    
    func mapping(map: Map) {
        museet <- map["museet"]
        weather <- map["weather"]
    }
}
