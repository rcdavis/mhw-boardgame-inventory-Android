package mhw.inventory.profile

data class Profile(
    val id: Int = 0,
    val campaignName: String = "",
    val playerName: String = "",
    val hunterName: String = "",
    val palicoName: String = ""
) {
    companion object {
        fun fromProfileDBEntry(pdbe: ProfileDBEntry): Profile {
            return Profile(
                id = pdbe.id,
                campaignName = pdbe.campaignName,
                playerName = pdbe.playerName,
                hunterName = pdbe.hunterName,
                palicoName = pdbe.palicoName
            )
        }
    }
}
