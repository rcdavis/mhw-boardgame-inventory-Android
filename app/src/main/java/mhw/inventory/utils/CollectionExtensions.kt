package mhw.inventory.utils

/**
 * Adds the item if it doesn't exist in the list or will replace existing entry.
 */
fun <T> MutableList<T>.addOrReplace(item: T, predicate: (T) -> Boolean) {
    val i = indexOfFirst(predicate)
    if (i == -1) {
        add(item)
    } else {
        this[i] = item
    }
}

/**
 * Only adds the item if it doesn't already exist within the list based on the
 * predicate.
 *
 * @return True if the item was added or false if not
 */
fun <T> MutableList<T>.addIfNotExist(item: T, predicate: (T) -> Boolean): Boolean {
    if (indexOfFirst(predicate) == -1) {
        add(item)
        return true
    }

    return false
}
