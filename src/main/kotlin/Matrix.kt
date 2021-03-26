class Matrix<T>(val h: Int, val w: Int, private val matrix: Array<Array<T>>) {
    init {
        require(matrix.size == h)
        require(h == 0 || matrix.first().size == w)
    }

    operator fun get(i: Int, j: Int): T = this.matrix[i][j]

    operator fun set(i: Int, j: Int, x: T) {this.matrix[i][j] = x}

    companion object {
        inline operator fun <reified T> invoke(height: Int, width: Int, valueFunction: (x: Int, y: Int) -> T)
                = Matrix(height, width, matrix(height, width, valueFunction))
    }

    override fun toString(): String {
        val s = StringBuilder()
        for (i in 0 until h) {
            for (j in 0 until w) s.append(this.matrix[i][j].toString()).append(" ")
            s.append('\n')
        }
        return s.toString()
    }
}


inline fun <reified T> matrix(height: Int, weight: Int, valueFunction: (x: Int, y: Int) -> T)
        = Array(height) { x -> Array(weight) { y -> valueFunction(x, y) } }


@JvmName("plusMatrixInt") // без него в JVM будет ругаться
operator fun Matrix<Int>.plus(other: Matrix<Int>): Matrix<Int> {
    return Matrix(h, w) { i, j -> this[i, j] + other[i,j] }
}

@JvmName("timesMatrixInt") // без него в JVM будет ругаться
operator fun Matrix<Int>.times(other: Matrix<Int>): Matrix<Int> {
    return Matrix(h, w) { i, j -> this[i, j] * other[i,j] }
}

@JvmName("transponirMatrixInt") // без него в JVM будет ругаться
fun Matrix<Int>.transponir(): Matrix<Int> {
    val tmp = Matrix(w, h) { _, _ -> this[0, 0]}
    for (i in 0 until h)
        for (j in 0 until w)
            tmp[j, i] = this[i, j]
    return tmp
}

@JvmName("getMatrMatrixInt") // без него в JVM будет ругаться
fun Matrix<Int>.getMatr(matrix: Matrix<Int>, i: Int, j: Int, m: Int): Matrix<Int> {
    val matrix2 = Matrix(w, h) { _, _ -> this[0, 0]}
    var ki = 0; var kj: Int; var di = 0; var dj: Int
    val m1: Int = m - 1
    while (ki < m1) {
        if (ki == i) di = 1
        dj = 0
        kj = 0
        while (kj < m1) {
            if (kj == j) dj = 1
            matrix2[ki, kj] = matrix[ki + di, kj + dj]
            kj++
        }
        ki++
    }
    return matrix2
}

@JvmName("printMatrixInt") // без него в JVM будет ругаться
fun Matrix<Int>.printMat(matrix: Matrix<Int>, n: Int = h, m: Int = w): String{
    val s = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until m) s.append(matrix[i,j].toString()).append(" ")
        s.append('\n')
    }
    return s.toString()
}

@JvmName("determinantMatrixInt") // без него в JVM будет ругаться
fun Matrix<Int>.determinant(matrix: Matrix<Int> = this, m: Int = h): Int {
    var d = 0; var k = 1
    var matrix2: Matrix<Int>
    val n: Int = m - 1
    if (m<1) print("Определитель вычислить невозможно!")

    if (m == 1) {
        d = matrix[0,0]
        return(d)
    }

    if (m == 2) {
        d = matrix[0,0] * matrix[1,1] - (matrix[1,0] * matrix[0,1])
        return(d)
    }

    if (m>2) {
        var i = 0
        while (i < m) {
            matrix2 = getMatr(matrix, i, 0, m)
            //println(printMat(matrix2, n , n))
            d += k * matrix[i,0] * determinant(matrix2, n)
            k = -k
            i++
        }
    }
    return(d)
}


@JvmName("plusMatrixComplexNumber") // без него в JVM будет ругаться
operator fun Matrix<ComplexNumber>.plus(other: Matrix<ComplexNumber>): Matrix<ComplexNumber> {
    return Matrix(h, w) { i, j -> this[i, j] + other[i,j] }
}

@JvmName("timesMatrixComplexNumber") // без него в JVM будет ругаться
operator fun Matrix<ComplexNumber>.times(other: Matrix<ComplexNumber>): Matrix<ComplexNumber> {
    return Matrix(h, w) { i, j -> this[i, j] * other[i,j] }
}

@JvmName("transponirMatrixComplexNumber") // без него в JVM будет ругаться
fun Matrix<ComplexNumber>.transponir(): Matrix<ComplexNumber> {
    val tmp = Matrix(w, h) { _, _ -> this[0, 0]}
    for (i in 0 until h)
        for (j in 0 until w)
            tmp[j, i] = this[i, j]
    return tmp
}

@JvmName("getMatrMatrixComplexNumber") // без него в JVM будет ругаться
fun Matrix<ComplexNumber>.getMatr(matrix: Matrix<ComplexNumber>, i: Int, j: Int, m: Int): Matrix<ComplexNumber> {
    val matrix2 = Matrix(w, h) { _, _ -> this[0, 0]}
    var ki = 0; var kj: Int; var di = 0; var dj: Int
    val m1: Int = m - 1
    while (ki < m1) {
        if (ki == i) di = 1
        dj = 0
        kj = 0
        while (kj < m1) {
            if (kj == j) dj = 1
            matrix2[ki, kj] = matrix[ki + di, kj + dj]
            kj++
        }
        ki++
    }
    return matrix2
}

@JvmName("printMatrixComplexNumber") // без него в JVM будет ругаться
fun Matrix<ComplexNumber>.printMat(matrix: Matrix<ComplexNumber>, n: Int = h, m: Int = w): String{
    val s = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until m) s.append(matrix[i,j].toString()).append(" ")
        s.append('\n')
    }
    return s.toString()
}

@JvmName("determinantMatrixComplexNumber") // без него в JVM будет ругаться
fun Matrix<ComplexNumber>.determinant(matrix: Matrix<ComplexNumber> = this, m: Int = h): ComplexNumber {
    var d = ComplexNumber(0.0, 0.0); var k = ComplexNumber(1.0,0.0)
    var matrix2: Matrix<ComplexNumber>
    val n: Int = m - 1
    if (m<1) print("Определитель вычислить невозможно!")

    if (m == 1) {
        d = matrix[0,0]
        return(d)
    }

    if (m == 2) {
        d = matrix[0,0] * matrix[1,1] - (matrix[1,0] * matrix[0,1])
        return(d)
    }

    if (m>2) {
        var i = 0
        while (i < m) {
            matrix2 = getMatr(matrix, i, 0, m)
            //println(printMat(matrix2, n , n))
            d += k * matrix[i,0] * determinant(matrix2, n)
            k *= ComplexNumber(-1.0, -1.0)
            i++
        }
    }
    return(d)
}