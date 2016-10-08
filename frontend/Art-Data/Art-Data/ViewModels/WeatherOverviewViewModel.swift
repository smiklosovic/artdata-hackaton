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
    
    lazy var count: Int = {
        return 1
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
    
    func count(forSection section: Int) -> Int {
        return 3
    }
    
    func configureCell(forCollectionView collectionView: UICollectionView, forIndexPath indexPath: IndexPath) -> UICollectionViewCell {
        var cell = UICollectionViewCell()
        switch indexPath.row {
        case 0:
            let collectionCell = collectionView.dequeueReusableCell(withReuseIdentifier:~|InfoCollectionViewCell.self, for: indexPath) as! InfoCollectionViewCell
            collectionCell.temperatureLabel.text = weatherModel.temperature
            collectionCell.weatherStateLabel.text = weatherModel.weatherState
            cell = collectionCell
            break
        case 1:
            let collectionCell = collectionView.dequeueReusableCell(withReuseIdentifier:~|ImageCollectionViewCell.self, for: indexPath) as! ImageCollectionViewCell
            collectionCell.assets = weatherModel.assets
            cell = collectionCell
            break
        case 2:
            let collectionCell = collectionView.dequeueReusableCell(withReuseIdentifier:~|DescriptionCollectionViewCell.self, for: indexPath) as! DescriptionCollectionViewCell
            collectionCell.assets = weatherModel.assets
            cell = collectionCell
            break
        default:
            break
        }
        
        return cell
    }
}
