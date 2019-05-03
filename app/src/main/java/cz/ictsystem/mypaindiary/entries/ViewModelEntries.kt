package cz.ictsystem.mypaindiary.entries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cz.ictsystem.mypaindiary.domain.Domain
import cz.ictsystem.mypaindiary.domain.entity.Entry

class ViewModelEntries(domain: Domain) : ViewModel() {

    //    val entries: LiveData<List<Entry>>
//        get() {
//            val data = MutableLiveData<List<Entry>>()
//            data.postValue(listOf(
//                Entry(0, Date(2019, 1, 20, 4, 35), 3, "description 03", "note 03"),
//                Entry(0, Date(2019, 1, 20, 4, 30), 2, "description 02", "note 02"),
//                Entry(0, Date(2019, 1, 20, 4, 25), 1, "description 01", "note 01"),
//
//                Entry(0, Date(2019, 1, 21, 5, 35), 3, "description 06", "note 06"),
//                Entry(0, Date(2019, 1, 21, 5, 30), 2, "description 05", "note 05"),
//                Entry(0, Date(2019, 1, 21, 5, 25), 1, "description 04", "note 04"),
//
//                Entry(0, Date(2019, 1, 22, 6, 35), 3, "description 09", "note 09"),
//                Entry(0, Date(2019, 1, 22, 6, 30), 2, "description 08", "note 08"),
//                Entry(0, Date(2019, 1, 22, 6, 25), 1, "description 07", "note 07")))
//
//            return data
//        }
    val entries: LiveData<List<Entry>> = domain.loadEntries()
}