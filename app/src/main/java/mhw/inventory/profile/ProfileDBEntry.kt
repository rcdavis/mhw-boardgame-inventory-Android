package mhw.inventory.profile

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class ProfileDBEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val campaignName: String = "",
    val playerName: String = "",
    val hunterName: String = "",
    val palicoName: String = ""
) {
    companion object {
        fun fromProfile(profile: Profile): ProfileDBEntry {
            return ProfileDBEntry(
                id = profile.id,
                campaignName = profile.campaignName,
                playerName = profile.playerName,
                hunterName = profile.hunterName,
                palicoName = profile.palicoName
            )
        }
    }
}
