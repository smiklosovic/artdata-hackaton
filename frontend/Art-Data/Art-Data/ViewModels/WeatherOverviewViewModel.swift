//
//  WeatherViewModel.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit

class WeatherOverviewViewModel: AnyObject {
    
    lazy var connectionService: ConnectionService = {
        return ConnectionService()
    }()
    
    //mock
    lazy var weatherModel: WeatherModel = {
        let element = WeatherModel()
        element.temperature = "37"
        element.weatherState = "Rain"
        element.assets = [AssetModel]()
        
        let asset1 = AssetModel()
        asset1.link = "https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fmedia.caranddriver.com%2Fimages%2F14q2%2F593136%2F2014-bmw-i8-photo-614786-s-1280x782.jpg&f=1"
        asset1.author = "Author"
        asset1.title = "BMW i8"
        
        element.assets.append(asset1)
        return element
    }()
    
    func loadModel() {
        
    }
}
