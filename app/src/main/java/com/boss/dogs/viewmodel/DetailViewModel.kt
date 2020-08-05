package com.boss.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.boss.dogs.model.DogBreed
import com.boss.dogs.model.DogDatabase
import kotlinx.coroutines.launch
import java.util.*

class DetailViewModel(application: Application) : BaseViewModel(application) {

    val dogLiveData =  MutableLiveData<DogBreed>()

    fun fetch(uuid: Int) {
        launch {
            val dog = DogDatabase(getApplication()).dogDAO().getDog(uuid)
            dogLiveData.value = dog
        }


       /* val dog = DogItem("1","Corgi","15 years","breedGroup","bredFor",

            Height(),Weight(),"temperament","")*/
      //  dogLiveData.value = dog
    }
}