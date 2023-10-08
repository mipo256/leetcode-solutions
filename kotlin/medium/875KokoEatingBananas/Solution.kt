class Solution {

    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        return minEatingSpeed(piles, h, 1, piles.maxOrNull()!!)
    }

    fun minEatingSpeed(piles: IntArray, h: Int, min: Int, max: Int) : Int {
        if (min == max) return min
        var k = (max + min) / 2
        return if (canEatAllPiles(piles, h, k)) {
            minEatingSpeed(piles, h, min, k)
        } else {
            minEatingSpeed(piles, h, if (k != min) k else k + 1 , max)
        }
    }

    fun canEatAllPiles(piles: IntArray, h: Int, k: Int) : Boolean {
        var roundTrips = 0;
        piles.forEach { pile ->
            roundTrips += ((pile / k) + if (pile % k != 0) 1 else 0)
        }
        return roundTrips <= h
    }
}
