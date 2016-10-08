//
//  ViewController.swift
//  Art-Data
//
//  Created by Alexey Potapov on 07/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit

class WeatherOverviewViewContoller: UIViewController {

    @IBOutlet weak var temperatureLabel: UILabel!
    @IBOutlet weak var weatherStateLabel: UILabel!
    @IBOutlet weak var artImage: UIImageView!
    @IBOutlet weak var imageNameLabel: UILabel!
    @IBOutlet weak var authorNameLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var moreBtn: UIButton!
    
    lazy var viewModel: WeatherOverviewViewModel = {
        return WeatherOverviewViewModel()
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.configureUI()
    }
    
    func configureUI() {
        viewModel.loadModel()
    }
    
}
