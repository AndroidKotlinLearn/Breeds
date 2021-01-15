package br.com.breeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.breeds_activity.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class BreedsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.breeds_activity)

        addFragmentTo(R.id.content_frame, createFragment())
        setSupportActionBar(toolbar)
    }

    fun createViewModel(): BreedsViewModel {
        val retrofit = Retrofit.Builder().baseUrl("http://dog.ceo/api/").addConverterFactory(GsonConverterFactory.create()).build()
        val dogCeoDataSource = DogCeoDataSource(retrofit.create(DogCeoApi::class.java))
        val repository = BreedRepository(dogCeoDataSource)
        return BreedsViewModel(repository, applicationContext)
    }

    fun createFragment(): BreedsFragment {
        return BreedsFragment.newInstance(createViewModel())
    }

    }
}