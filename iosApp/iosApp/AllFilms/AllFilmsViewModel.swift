//
//  AllFilmsViewModel.swift
//  iosApp
//
//  Created by Илья Малахов on 03.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

@MainActor
final class AllFilmsViewModel: ObservableObject {
    // MARK: - Properties
    
    private var viewModel = FilmsViewModel()
    @Published private(set) var model: FilmsViewModel.FilmModel?
    
    
    // MARK: -  Actions
    
    func fetchFilms() async throws {
        try await viewModel.fetchAllFilms() { model in
            self.model = model
        }
    }
}
