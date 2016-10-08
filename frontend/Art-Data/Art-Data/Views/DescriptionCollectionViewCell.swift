//
//  DescriptionCollectionViewCell.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit

class DescriptionCollectionViewCell: UICollectionViewCell {
    
    @IBOutlet weak var authorNameLabel: UILabel!
    @IBOutlet weak var imageNameLabel: UILabel!
    @IBOutlet weak var moreBtn: UIButton!
    var assets:[AssetModel]!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        let asset = assets.first
        authorNameLabel.text = asset?.author
        imageNameLabel.text = asset?.title
    }
}
