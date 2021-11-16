class TennisGame1 : TennisGame {

    private var playerOnePoints: Int = 0
    private var playerTwoPoints: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === "player1") playerOnePoints++ else playerTwoPoints++    }

    override fun getScore(): String {
        if (areTied()) {
            return getScoreWhenAreTied()
        }
        return if (hasPlayersMoreThan3Points()) {
            getScoreWhenPlayersHasMoreThan3Points()
        } else {
            getScoreWord(playerOnePoints) + "-" + getScoreWord(playerTwoPoints)
        }

    }

    private fun getScoreWhenPlayersHasMoreThan3Points(): String {
        val minusResult = calculateDiffPoints()
        return if (isPlayerOneWinningByOnePoint(minusResult))
            "Advantage player1"
        else if (isPlayerTwoWinningByTwoPoints(minusResult))
            "Advantage player2"
        else if (isPlayerOneWinningByTwoPoints(minusResult))
            "Win for player1"
        else
            "Win for player2"
    }

    private fun getScoreWord(tempScore: Int): String {

        return when (tempScore) {
            0 -> "Love"
            1 -> "Fifteen"
            2 -> "Thirty"
            else -> "Forty"
        }

    }

    private fun isPlayerOneWinningByTwoPoints(minusResult: Int) = minusResult >= 2

    private fun isPlayerTwoWinningByTwoPoints(minusResult: Int) = minusResult == -1

    private fun isPlayerOneWinningByOnePoint(minusResult: Int) = minusResult == 1

    private fun calculateDiffPoints() = playerOnePoints - playerTwoPoints

    private fun hasPlayersMoreThan3Points() = playerOnePoints >= 4 || playerTwoPoints >= 4

    private fun getScoreWhenAreTied() = when (playerOnePoints) {
        0 -> "Love-All"
        1 -> "Fifteen-All"
        2 -> "Thirty-All"
        else -> "Deuce"
    }

    private fun areTied() = playerOnePoints == playerTwoPoints
}
