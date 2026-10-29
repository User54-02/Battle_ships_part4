// Класс игрока в морской бой.
class Player(val name: String) {

    // ======================== ПОЛЕ ========================
    // Приватное поле 10х10. Каждая клетка — это CellState.
    private val _field: Array<Array<CellState>> = Array(10) { Array(10) { CellState.EMPTY } }

    // Get-ер для поля. Снаружи можно только ЧИТАТЬ.
    fun field(): Array<Array<CellState>> = _field

    // ======================== СТАТИСТИКА ========================
    private var _shots: Int = 0
    private var _hits: Int = 0

    val shots: Int
        get() = _shots

    val hits: Int
        get() = _hits

    // ======================== МЕТОДЫ ========================
    fun accuracy(): Double =
        if (_shots == 0) 0.0 else _hits * 100.0 / _shots

    fun registerShot(hit: Boolean) {
        _shots++
        if (hit) _hits++
    }

    // Ставим палубу корабля - теперь CellState.SHIP вместо '#'.
    fun placeShip(row: Int, col: Int) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = CellState.SHIP
        }
    }

    // Отмечаем выстрел противника - CellState.HIT или CellState.MISS.
    fun markShot(row: Int, col: Int, hit: Boolean) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = if (hit) CellState.HIT else CellState.MISS
        }
    }

    fun reset() {
        _shots = 0
        _hits = 0
        for (r in 0..9) {
            for (c in 0..9) {
                _field[r][c] = CellState.EMPTY
            }
        }
    }

    fun status(): String {
        val acc = String.format("%.1f", accuracy())
        return "Игрок $name: выстрелов $_shots, попаданий $_hits, точность $acc%"
    }
}
// ЗАДАНИЕ 2 и 5
enum class ShipType(val size: Int) {
    BATTLESHIP(4),
    CRUISER(3),
    DESTROYER(2),
    BOAT(1);

    fun isBig(): Boolean = size >= 3
}
// ЗАДАНИЕ 3
enum class GameState {
    PLACING, PLAYER_TURN, ENEMY_TURN, FINISHED
}

fun describe(state: GameState): String {
    return when (state) {
        GameState.PLACING -> "Игроки расставляют корабли"
        GameState.PLAYER_TURN -> "Ход игрока"
        GameState.ENEMY_TURN -> "Ход компьютера"
        GameState.FINISHED -> "Игра завершена"
    }
}