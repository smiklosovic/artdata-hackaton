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

    var isDay: Bool = false

    override func viewDidLoad() {
        super.viewDidLoad()
        
        temperatureLabel.font = UIFont(name: "Lato-Regular", size: 19.0)
        weatherStateLabel.font = UIFont(name: "Lato-Regular", size: 19.0)
        imageNameLabel.font = UIFont(name: "Lato-Bold", size: 19.0)
        authorNameLabel.font = UIFont(name: "Lato-Regular", size: 17.0)
        descriptionLabel.font = UIFont(name: "Lato-Regular", size: 17.0)
        self.toggleNight()
        self.getRequestForWeather()
    }
    
    func toggleNight() {
        if isDay {
            UIApplication.shared.statusBarStyle = .default
            self.view.backgroundColor = UIColor(red: 242.0/255.0, green: 242.0/255.0, blue: 235.0/255.0, alpha: 1.0)
            temperatureLabel.textColor = UIColor.black
            weatherStateLabel.textColor = UIColor.black
            imageNameLabel.textColor = UIColor.black
            authorNameLabel.textColor = UIColor.black
            descriptionLabel.textColor = UIColor(red: 76.0/255.0, green: 124.0/255.0, blue: 29.0/255.0, alpha: 1.0)
            self.moreBtn.setImage(UIImage(named: "visitus_button_day"), for: .normal)
            descriptionLabel.text = "Nasjonal museet is open 3 more hours"
        } else {
            UIApplication.shared.statusBarStyle = .lightContent
            self.view.backgroundColor = UIColor(red: 34.0/255.0, green: 35.0/255.0, blue: 55.0/255.0, alpha: 1.0)
            temperatureLabel.textColor = UIColor.white
            weatherStateLabel.textColor = UIColor.white
            imageNameLabel.textColor = UIColor.white
            authorNameLabel.textColor = UIColor.white
            descriptionLabel.textColor = UIColor(red: 241.0/255.0, green: 21.0/255.0, blue: 94.0/255.0, alpha: 1.0)
            self.moreBtn.setImage(UIImage(named: "visitus_button_night"), for: .normal)
            descriptionLabel.text = "Nasjonal museet is closed now."
        }
    }
    
    @IBAction func openInBrowser()
    {
        UIApplication.shared.open(URL(string: "http://nasjonalmuseet.no")!, options: [:], completionHandler: nil)
    }
    
    func getRequestForWeather() {
        var url = ""
        if isDay {
            url = "http://127.0.0.1:8080/api/search?time=8"
        } else {
            url = "http://127.0.0.1:8080/api/search?time=20&city=Bratislava"
        }
        Alamofire.request(url).responseObject {
            [unowned self] (response: DataResponse<ResponseModel>) in
            let responseModel = response.result.value
            self.temperatureLabel.text = responseModel?.weather?.temperature?.appending(" °C")
            self.weatherStateLabel.text = responseModel?.weather?.weatherState
            self.imageNameLabel.text = responseModel?.museet?[0].title
            self.authorNameLabel.text = responseModel?.museet?[0].author
            let imageURL = responseModel?.museet?[0].link
            Alamofire.request(imageURL!).responseData {
                [unowned self] response in
                if let data = response.result.value {
                    self.artImage.image = UIImage(data: data)
                }
            }
        }
    }
}
