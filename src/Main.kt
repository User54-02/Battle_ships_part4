// Печатаем два поля рядом.
fun printBothFields(player: Player, enemy: Player) {
    println("=== Поле игрока ${player.name} ===          === Поле игрока ${enemy.name} ===")
    print("  ")
    for (c in 0..9) print("$c ")
    print("        ")
    for (c in 0..9) print("$c ")
    println()
    for (r in 0..9) {
        print("$r ")
        for (c in 0..9) print("${player.field()[r][c].toChar()} ") // Используем .toChar()
        print("        ")
        print("$r ")
        for (c in 0..9) print("${enemy.field()[r][c].toChar()} ") // Используем .toChar()
        println()
    }
}

fun main() {
    // --- Тест из урока (Проверка Player) ---
    val player = Player("Вы")
    val enemy = Player("Компьютер")

    player.placeShip(3, 2)
    player.placeShip(3, 3)
    player.placeShip(3, 4)
    player.placeShip(3, 5)

    enemy.placeShip(5, 7)
    enemy.placeShip(6, 7)
    enemy.placeShip(7, 7)

    printBothFields(player, enemy)
    println()

    player.registerShot(true)
    player.registerShot(false)
    player.registerShot(true)

    println(player.status())
    println("Выстрелов: ${player.shots}")
    println("Попаданий: ${player.hits}")
    println()

    // --- Проверка Задания 2 ---
    println("--- Задание 2: Типы кораблей ---")
    for (type in ShipType.values()) {
        println("${type.name}: ${type.size} клетки")
    }
    println()

    // --- Проверка Задания 3 ---
    println("--- Задание 3: Свой enum ---")
    println("Статус: ${describe(GameState.PLAYER_TURN)}")
    println()

    // --- Проверка Задания 5 ---
    println("--- Задание 5: Метод isBig ---")
    println("BATTLESHIP большой? ${ShipType.BATTLESHIP.isBig()}") // true
    println("BOAT большой? ${ShipType.BOAT.isBig()}")             // false
}