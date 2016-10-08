//
//  ViewController.swift
//  Art-Data
//
//  Created by Alexey Potapov on 07/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit
import Alamofire
import ObjectMapper
import AlamofireObjectMapper
import SVGPath

class WeatherOverviewViewContoller: UIViewController {

    @IBOutlet weak var temperatureLabel: UILabel!
    @IBOutlet weak var weatherStateLabel: UILabel!
    @IBOutlet weak var artImage: UIImageView!
    @IBOutlet weak var imageNameLabel: UILabel!
    @IBOutlet weak var authorNameLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var moreBtn: UIButton!

    var isDay: Bool = true
    var shapeLayer = CAShapeLayer()

    override func viewDidLoad() {
        super.viewDidLoad()
        
        temperatureLabel.font = UIFont(name: "Lato-Regular", size: 16.0)
        weatherStateLabel.font = UIFont(name: "Lato-Regular", size: 16.0)
        imageNameLabel.font = UIFont(name: "Lato-Bold", size: 18.0)
        authorNameLabel.font = UIFont(name: "Lato-Regular", size: 16.0)
        descriptionLabel.font = UIFont(name: "Lato-Regular", size: 16.0)
        self.toggleNight()
    }
    
    func toggleNight() {
        if isDay {
            self.view.backgroundColor = UIColor(red: 242.0/255.0, green: 242.0/255.0, blue: 235.0/255.0, alpha: 1.0)
            temperatureLabel.textColor = UIColor.black
            weatherStateLabel.textColor = UIColor.black
            imageNameLabel.textColor = UIColor.black
            authorNameLabel.textColor = UIColor.black
            descriptionLabel.textColor = UIColor(red: 76.0/255.0, green: 124.0/255.0, blue: 29.0/255.0, alpha: 1.0)
            self.moreBtn.setImage(UIImage(named: "visitus_button_day"), for: .normal)
        } else {
            self.view.backgroundColor = UIColor(red: 34.0/255.0, green: 35.0/255.0, blue: 55.0/255.0, alpha: 1.0)
            temperatureLabel.textColor = UIColor.white
            weatherStateLabel.textColor = UIColor.white
            imageNameLabel.textColor = UIColor.white
            authorNameLabel.textColor = UIColor.white
            descriptionLabel.textColor = UIColor(red: 241.0/255.0, green: 21.0/255.0, blue: 94.0/255.0, alpha: 1.0)
            self.moreBtn.setImage(UIImage(named: "visitus_button_night"), for: .normal)
        }
    }
    
    func getRequestForWeather() {
        let url = "https://raw.githubusercontent.com/tristanhimmelman/AlamofireObjectMapper/d8bb95982be8a11a2308e779bb9a9707ebe42ede/sample_json"
        Alamofire.request(url).responseObject {
            [unowned self] (response: DataResponse<ResponseModel>) in
            let responseModel = response.result.value
            self.temperatureLabel.text = responseModel?.weather?.temperature
            self.weatherStateLabel.text = responseModel?.weather?.weatherState
            self.imageNameLabel.text = responseModel?.museet?[0].title
            self.authorNameLabel.text = responseModel?.museet?[0].author
            
            self.toggleNight()
        }
    }
}
