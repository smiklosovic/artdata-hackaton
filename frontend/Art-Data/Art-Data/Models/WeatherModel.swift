//
//  WeatherModel.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import ObjectMapper

class WeatherModel: Mappable {
    
    var assets: [AssetModel]?
    var temperature: String?
    var weatherState: String?
    
    required init?(map: Map) {
    
    }
    
    func mapping(map: Map) {
        assets <- map["link"]
        temperature <- map["temperature"]
        weatherState <- map["weatherState"]
    }
}
