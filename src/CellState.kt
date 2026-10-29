// Состояние одной клетки на поле. Всего четыре возможных состояния.
enum class CellState {
    EMPTY, // пусто
    SHIP,  // палуба корабля
    HIT,   // попадание
    MISS;  // промах

    // Преобразуем состояние в символ для печати.
    fun toChar(): Char {
        return when (this) {
            CellState.EMPTY -> '.'
            CellState.SHIP -> '#'
            CellState.HIT -> 'X'
            CellState.MISS -> '0'
        }
    }
}