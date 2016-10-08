//
//  InfoCollectionViewCell.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit

final class InfoCollectionViewCell: UICollectionViewCell {
    
    @IBOutlet weak var temperatureLabel: UILabel!
    @IBOutlet weak var weatherStateLabel: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
        
    }
}
