package core

class Transaction(reference: Int, val    entries: List<Entry>, date: String) {
    fun balance(): Int {
        return entries.sumOf { it.movement.value() }
    }

}