package com.herolife.core.model

data class PlayerProgress(
    val level: Int,
    val xp: Int,
    val xpToNextLevel: Int
)

data class GameWallet(
    val gold: Long,
    val diamonds: Long
)

enum class TaskPriority {
    CRITICAL,
    HIGH,
    MEDIUM,
    LOW
}

enum class GameLane {
    NETWORKING,
    PERSONAL_GROWTH,
    PERSONAL
}

data class TaskDefinition(
    val id: String,
    val title: String,
    val priority: TaskPriority,
    val lane: GameLane,
    val estimatedMinutes: Int,
    val xpReward: Int,
    val goldReward: Int,
    val diamondReward: Int = 0
)
