//
//  FilmViewModel.swift
//  iosApp
//
//  Created by Илья Малахов on 03.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

@MainActor
final class FilmViewModel: ObservableObject {
    // MARK: - Properties
    
    private let filmViewModel: shared.FilmViewModel
    @Published private(set) var film: Film?
    
    init(urlString: String) {
        filmViewModel = shared.FilmViewModel(urlString: urlString)
    }
    
    // MARK: - Actions
    
    func fetch() async throws {
        try await filmViewModel.fetchFilm() { film in
            self.film = film
        }
    }
}
