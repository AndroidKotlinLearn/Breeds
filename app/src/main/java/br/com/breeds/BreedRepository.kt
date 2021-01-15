package br.com.breeds

class BreedRepository(private val dogCeoDataSource: DogCeoDataSource): BreedDataSource {
    override fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit) {
        dogCeoDataSource.listAll(success, failure)
    }

}