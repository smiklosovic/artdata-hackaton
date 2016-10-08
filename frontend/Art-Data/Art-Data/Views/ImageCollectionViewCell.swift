//
//  ImageCollectionReusableView.swift
//  Art-Data
//
//  Created by Alexey Potapov on 08/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit

final class ImageCollectionViewCell: UICollectionViewCell {
    
    @IBOutlet weak var artImage: UIImageView!
    var assets:[AssetModel]!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        let asset = assets.first
        self.artImage.image = UIImage(contentsOfFile: "i8")
    }
    
}
