//
//  ViewController.swift
//  Art-Data
//
//  Created by Alexey Potapov on 07/10/2016.
//  Copyright © 2016 Community. All rights reserved.
//

import UIKit

class WeatherOverviewViewContoller: UIViewController {
    
    @IBOutlet weak var collectionView: UICollectionView!
    @IBOutlet weak var flowLayout: UICollectionViewFlowLayout!
    
    lazy var viewModel: WeatherOverviewViewModel = {
        return WeatherOverviewViewModel()
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.configureUI()
        self.configureCollection()
    }
    
    func configureUI() {
        
    }
    
    func configureCollection() {
        collectionView.delegate = self
        collectionView.dataSource = self
    
        flowLayout.minimumLineSpacing = 0.0
        flowLayout.minimumInteritemSpacing = 0.0
        flowLayout.sectionInset = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)

        collectionView.register(InfoCollectionViewCell.self, forCellWithReuseIdentifier: NSStringFromClass(InfoCollectionViewCell.self))
        collectionView.register(ImageCollectionViewCell.self, forCellWithReuseIdentifier: NSStringFromClass(ImageCollectionViewCell.self))
        collectionView.register(DescriptionCollectionViewCell.self, forCellWithReuseIdentifier: NSStringFromClass(DescriptionCollectionViewCell.self))
        
        collectionView.register(UINib(nibName: NSStringFromClass(InfoCollectionViewCell.self), bundle: nil), forCellWithReuseIdentifier: NSStringFromClass(InfoCollectionViewCell.self))
        collectionView.register(UINib(nibName: NSStringFromClass(ImageCollectionViewCell.self), bundle: nil), forCellWithReuseIdentifier: NSStringFromClass(ImageCollectionViewCell.self))
        collectionView.register(UINib(nibName: NSStringFromClass(DescriptionCollectionViewCell.self), bundle: nil), forCellWithReuseIdentifier: NSStringFromClass(DescriptionCollectionViewCell.self))
    }
}

extension WeatherOverviewViewContoller: UICollectionViewDataSource {
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return self.viewModel.count(forSection: section)
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        return self.viewModel.configureCell(forCollectionView: collectionView, forIndexPath: indexPath)
    }
}

extension WeatherOverviewViewContoller: UICollectionViewDelegate {
    
}
