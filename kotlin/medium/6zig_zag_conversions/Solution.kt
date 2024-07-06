package io.mpolivaha.coroutines.baeldung

import java.lang.StringBuilder

class Solution {

    /**
     *   ABCDEFGHIGKLMNOP
     * 1.ABCDEFGHIGKLMNOP
     *
     * 2.ACEG
     *   BDFH
     *
     *   i
     * 3.A  E
     *   B D
     *   C
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *
     * P - 1
     * S - 1
     *
     * (2 * (row - 1)) + 1 --> (2 * (i - 1 - 1)) + 1
     *
     * P    H
     * A   SI
     * Y  I R
     * P L  IG
     * A    N
     * index % numRows
     *
     * 4.A   G              d = 3
     *   B  FH               d = 2
     *   C E I K               d = 1
     *   D   J               d = 0
     *
     *   i = 0: i + 1
     *
     *   1 + (rowNum - 2) * 2
     *   1 + (rowNum - 3) * 2
     *   1 + (rowNum - 4) * 2
     *   1 + (rowNum - 5) * 2
     *
     *   depth = 3, 2, 1, 0 --> until hit zero then up --> 1, 2, 3 --> until hit numRows - 1
     *   depth = 0 -> same char
     *   depth = 1 -> next + 1 for ()
     *   depth = 2 -> next + 1 + (2 * (depth - 1)) -> next + 3
     *   depth = n -> next + 1 + (2 * (depth - 1)) -> ...
     */
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val result = StringBuilder()
        var jump : Int
        for (i in 1..numRows) {
            if (i == 1 || i == numRows) {
                jump = 1 + (numRows - 2) * 2
                var index: Int = i - 1
                result.append(s[index])
                while (index + jump + 1 < s.length) {
                    index += (jump + 1)
                    result.append(s[index])
                }
            } else {
                val jumpViaBottom = 1 + (numRows - (2 + i - 1)) * 2
                val jumpViaTop = (2 * (i - 2)) + 1
                // numRows - i
                var bottomJump = true
                var index: Int = i - 1
                result.append(s[index])

                while (true) {
                    if (bottomJump) {
                        index += (jumpViaBottom + 1)
                        bottomJump = false
                    } else {
                        index += (jumpViaTop + 1)
                        bottomJump = true
                    }
                    if (index >= s.length) break
                    result.append(s[index])
                }
            }
        }
        return result.toString()
    }
}
