//
//  WeatherViewModel.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit

class WeatherOverviewViewModel: AnyObject {
    
    var weatherModel: WeatherModel!
    
    lazy var connectionService: ConnectionService = {
        return ConnectionService()
    }()
    
    func loadModel() {
        self.weatherModel = connectionService.getRequestForWeather()
    }
}
