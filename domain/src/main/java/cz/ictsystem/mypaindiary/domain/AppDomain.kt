package cz.ictsystem.mypaindiary.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import cz.ictsystem.mypaindiary.domain.entity.Description
import cz.ictsystem.mypaindiary.domain.entity.Entry
import cz.ictsystem.mypaindiary.domain.entity.Location
import cz.ictsystem.mypaindiary.repository.DescriptionRep
import cz.ictsystem.mypaindiary.repository.EntryRep
import cz.ictsystem.mypaindiary.repository.LocationRep
import cz.ictsystem.mypaindiary.repository.Repository
import java.util.*
import kotlin.collections.ArrayList

class AppDomain(private val repository: Repository) : Domain {

    private val properties: Properties

    init {
        properties = AppProperties(repository)

        if (properties.isNewInstallationValue()) {
            AppDemoData(repository).insert()
            properties.setNewInstallation(false)
        }
    }

    override fun loadEntries(): LiveData<List<Entry>> {
        return Transformations.map(repository.loadEntries()) {
            val items: List<Entry> = ArrayList()
            it.forEach {
                (items as ArrayList).add(Entry(it))
            }
            items
        }
    }

    override fun loadEntries(from: Date, to: Date): LiveData<List<Entry>> {
        return Transformations.map(repository.loadEntries(from, to)) {
            val items: List<Entry> = ArrayList()
            it.forEach {
                (items as ArrayList).add(Entry(it))
            }
            items
        }
    }

    override fun insertEntry(entry: Entry) {
        repository.insertEntry(entry.getRep())
    }

    override fun insertEntries(entries: List<Entry>) {
        val items: List<EntryRep> = ArrayList()
        entries.forEach { entry ->
            (items as ArrayList).add(entry.getRep())
        }
        repository.insertEntries(items)
    }

    override fun deleteEntry(entry: Entry) {
        repository.deleteEntry(entry.getRep())
    }

    override fun deleteEntries(entries: List<Entry>) {
        val items: List<EntryRep> = ArrayList()
        entries.forEach { entry ->
            (items as ArrayList).add(entry.getRep())
        }
        repository.deleteEntries(items)
    }

    override fun loadDescription(): LiveData<List<Description>> {
        return Transformations.map(repository.loadDescription()) {
            val items = ArrayList<Description>()
            it.forEach {
                items.add(Description(it))
            }
            items
        }
    }

    override fun insertDescription(description: Description) {
        repository.insertDescription(description.getRep())
    }

    override fun insertDescriptions(descriptions: List<Description>) {
        val items = ArrayList<DescriptionRep>()
        descriptions.forEach {
            items.add(it.getRep())
        }
        repository.insertDescriptions(items)
    }

    override fun deleteDescription(description: Description) {
        repository.deleteDescription(description.getRep())
    }

    override fun deleteDescriptions(descriptions: List<Description>) {
        val items = ArrayList<DescriptionRep>()
        descriptions.forEach {
            items.add(it.getRep())
        }
        repository.deleteDescriptions(items)
    }

    override fun loadLocation(): LiveData<List<Location>> {
        return Transformations.map(repository.loadLocation()) {
            val items = ArrayList<Location>()
            it.forEach {
                items.add(Location(it))
            }
            items
        }
    }

    override fun insertLocation(location: Location) {
        repository.insertLocation(location.getRep())
    }

    override fun insertLocations(locations: List<Location>) {
        val items = ArrayList<LocationRep>()
        locations.forEach {
            items.add(it.getRep())
        }
        repository.insertLocations(items)
    }

    override fun deleteLocation(location: Location) {
        repository.deleteLocation(location.getRep())
    }

    override fun deleteLocations(locations: List<Location>) {
        val items = ArrayList<LocationRep>()
        locations.forEach {
            items.add(it.getRep())
        }
        repository.deleteLocations(items)
    }

    override fun properties() = properties
}

