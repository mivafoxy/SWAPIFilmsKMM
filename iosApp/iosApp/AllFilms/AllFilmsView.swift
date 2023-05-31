//
//  AllFilmsView.swift
//  iosApp
//
//  Created by Илья Малахов on 03.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import shared
import SwiftUI

struct AllFilmsView: View {
    @ObservedObject private var viewModel = AllFilmsViewModel()
    
    var body: some View {
        NavigationStack {
            List {
                if let items = viewModel.model?.items as? NSArray as? [Film] {
                    ForEach(items, id: \.self) { modelItem in
                        NavigationLink(modelItem.title) {
                            FilmView(urlString: modelItem.url)
                        }
                    }
                }
            }
        }
        .navigationTitle("Фильмы")
        .onAppear {
            Task {
                try await viewModel.fetchFilms()
            }
        }
    }
}

struct AllFilmsView_Previews: PreviewProvider {
    static var previews: some View {
        AllFilmsView()
    }
}
