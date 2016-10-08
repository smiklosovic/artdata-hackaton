//
//  ConnectionManager.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit

class ConnectionService: AnyObject {
    
    lazy var baseURL: URL = {
        return URL(string: "test")!
    }()

    func getRequestForWeather() -> WeatherModel{
        
        return WeatherModel()
    }
}
