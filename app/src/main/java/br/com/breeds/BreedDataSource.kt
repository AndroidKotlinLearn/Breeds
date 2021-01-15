package br.com.breeds

interface BreedDataSource {
    fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit)
}