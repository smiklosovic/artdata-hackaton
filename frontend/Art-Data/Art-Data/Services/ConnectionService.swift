//
//  ConnectionManager.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit
import Alamofire
import ObjectMapper
import AlamofireObjectMapper

class ConnectionService: AnyObject {
    
    lazy var baseURL: URL = {
        return URL(string: "test")!
    }()

    func getRequestForWeather() {
        
        let url = "https://raw.githubusercontent.com/tristanhimmelman/AlamofireObjectMapper/d8bb95982be8a11a2308e779bb9a9707ebe42ede/sample_json"
        Alamofire.request(url).responseObject { (response: DataResponse<WeatherModel>) in
            
//            let weatherResponse = response.result.value
//            print(weatherResponse?.location)
//            
//            if let threeDayForecast = weatherResponse?.threeDayForecast {
//                for forecast in threeDayForecast {
//                    print(forecast.day)
//                    print(forecast.temperature)           
//                }
//            }
        }
    }
}
